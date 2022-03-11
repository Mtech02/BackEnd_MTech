package br.com.mtech.redesocial.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import br.com.mtech.redesocial.model.UserModel;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@BeforeAll
	public void start() {

		userRepository.save(new UserModel(0L, "Matheus da Silva", "matheusoliveira.3125@gmail.com", "123456789",
				"https://i.imgur.com/mhO83HD.png"));
		userRepository.save(new UserModel(0L, "Luiz Igor", "luiz.igor21@gmail.com", "123456789",
				"https://i.imgur.com/mhO83HD.png"));
		userRepository.save(new UserModel(0L, "Marcos Alves", "marcolaalves.222@gmail.com", "123456789",
				"https://i.imgur.com/mhO83HD.png"));
		userRepository.save(new UserModel(0L, "Igor Luiz", "luiz.carecabrabo@gmail.com", "123456789",
				"https://i.imgur.com/mhO83HD.png"));
		userRepository.save(new UserModel(0L, "Robson Carmo", "robsondosjapones@gmail.com", "123456789",
				"https://i.imgur.com/mhO83HD.png"));
		userRepository.save(new UserModel(0L, "Luiz Paulo", "Luiz.paulo@gmail.com", "123456789",
				"https://i.imgur.com/mhO83HD.png"));

	}

	@Test
	@DisplayName("Return only one user")
	public void returnOneUser() {

		Optional<UserModel> userModel = userRepository.findByEmail("robsondosjapones@gmail.com");

		assertTrue(userModel.get().getEmail().equals("robsondosjapones@gmail.com"));

	}

	@Test
	@DisplayName("Return must be three user")
	public void returnThreeUser() {

		List<UserModel> userList = userRepository.findAllByNameContainingIgnoreCase("Luiz");

		assertEquals(3, userList.size());

		assertTrue(userList.get(0).getName().equals("Luiz Igor"));
		assertTrue(userList.get(1).getName().equals("Igor Luiz"));
		assertTrue(userList.get(2).getName().equals("Luiz Paulo"));

	}

	@AfterAll
	public void end() {

		userRepository.deleteAll();

	}

}
