package br.com.mtech.redesocial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mtech.redesocial.model.PostModel;
import br.com.mtech.redesocial.repository.PostRepository;

@RestController
@RequestMapping("/post")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostController {

	@Autowired
	private PostRepository respository;
	
	@GetMapping
	public ResponseEntity<List<PostModel>> getAll(){
		
		return ResponseEntity.ok(respository.findAll());
	}
}
