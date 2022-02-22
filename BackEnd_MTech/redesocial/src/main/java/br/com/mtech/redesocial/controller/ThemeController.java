package br.com.mtech.redesocial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mtech.redesocial.model.ThemeModel;
import br.com.mtech.redesocial.repository.ThemeRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/theme")
public class ThemeController {

	@Autowired
	private ThemeRepository repository;
	
	@GetMapping
	public ResponseEntity<List<ThemeModel>> getAll(){
		
		return ResponseEntity.ok(repository.findAll());
		
	}
	
}
