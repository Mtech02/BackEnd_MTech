package br.com.mtech.redesocial.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.mtech.redesocial.model.UserModel;
import br.com.mtech.redesocial.service.UserService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Autowired
	private UserService userService;
	
	@Test
	@Order(1)
	public void mustRegisterAUser() {
		
		HttpEntity<UserModel> request = new HttpEntity<UserModel>(new UserModel(0L, "Marie Jubs", 
				"mariejubs123@gmail.com", "123456789", "https://i.imgur.com/mhO83HD.png", "empresa"));
		
		ResponseEntity<UserModel> res = testRestTemplate.exchange("/user/register", HttpMethod.POST, request, UserModel.class);
		
		assertEquals(HttpStatus.CREATED, res.getStatusCode());
		
		assertEquals(request.getBody().getEmail(), res.getBody().getEmail());
	
	}
	
	@Test
	@Order(2)
	public void shouldntDuplicateUser() {
		
		userService.registerUser(new UserModel(0L, "Maria da Silva", 
				"maria_silva@email.com.br", "13465278", "https://i.imgur.com/T12NIp9.jpg", "empresa"));
		
		HttpEntity<UserModel> requestUpdate = new HttpEntity<UserModel>(new UserModel(0L, "Maria da Silva", 
				"maria_silva@email.com.br", "13465278", "https://i.imgur.com/T12NIp9.jpg", "empresa"));
		
		ResponseEntity<UserModel> res = testRestTemplate
				.exchange("/user/register", HttpMethod.POST, requestUpdate, UserModel.class);
		
		assertEquals(HttpStatus.BAD_REQUEST, res.getStatusCode());
		
	}
	
	
	@Test
	@Order(3)
	private void mustUpdateAUser() {
		
		Optional<UserModel> userRegistered = userService.registerUser(new UserModel(0L, "Juliana Andrews", 
				"juliana_andrews@email.com.br", "juliana123", "https://i.imgur.com/yDRVeK7.jpg", "empresa"));
		
		UserModel userUpdate = new UserModel(userRegistered.get().getId(), "Juliana Andrews Ramos", 
				"juliana_ramos@email.com.br", "juliana123" , "https://i.imgur.com/yDRVeK7.jpg", "empresa");
		
		HttpEntity<UserModel> requestUpdate = new HttpEntity<UserModel>(userUpdate);
		
		ResponseEntity<UserModel> resUpdate = testRestTemplate
				.withBasicAuth("root", "root")
				.exchange("user/update", HttpMethod.PUT, requestUpdate, UserModel.class);
		
		assertEquals(HttpStatus.OK, resUpdate.getStatusCode());
		assertEquals(requestUpdate.getBody().getName(), resUpdate.getBody().getName());
		assertEquals(requestUpdate.getBody().getEmail(), resUpdate.getBody().getEmail());
		
	}
	
	@Test
	@Order(4)
	public void mustShowAllUsers() {
		
		userService.registerUser(new UserModel(0L, "Sabrina Sanches", 
				"sabrina_sanches@email.com.br", "sabrina123", "https://i.imgur.com/5M2p5Wb.jpg","empresa"));
		
		userService.registerUser(new UserModel(0L, "Ricardo Marques", 
				"ricardo_marques@email.com.br", "ricardo123", "https://i.imgur.com/mhO83HD.png","empresa"));
		
		ResponseEntity<String> res = testRestTemplate
				.withBasicAuth("root", "root")
				.exchange("/user/all", HttpMethod.GET, null, String.class);
		
		assertEquals(HttpStatus.OK, res.getStatusCode());
		
	}
	
	@Test
	@Order(5)
	public void mustListOnlyOneUser() {
		
		Optional<UserModel> searchUser = userService.registerUser(new UserModel(0L, "Laura Santolia", 
				"laura_santolia@email.com.br", "laura12345", "https://i.imgur.com/EcJG8kB.jpg", "empresa"));
		
		ResponseEntity<String> res = testRestTemplate
				.withBasicAuth("root", "root")
				.exchange("/user/" + searchUser.get().getId(), HttpMethod.GET, null, String.class);
		
		assertEquals(HttpStatus.OK, res.getStatusCode());
		
	}
	
}
