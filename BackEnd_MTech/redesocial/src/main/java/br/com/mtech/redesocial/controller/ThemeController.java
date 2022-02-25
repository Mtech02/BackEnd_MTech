package br.com.mtech.redesocial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping ("/{id}")
	public ResponseEntity<ThemeModel>getById (@PathVariable long id){
		
		return repository.findById(id).map(res-> ResponseEntity.ok(res))
				.orElse(ResponseEntity.notFound().build());
		
	}
	
	@GetMapping ("/theme/{theme}")
	public ResponseEntity<List<ThemeModel>>getByTheme(@PathVariable String theme){
		
		return ResponseEntity.ok(repository.findAllByDescriptionContainingIgnoreCase(theme));

	}
	
	@PostMapping
	public ResponseEntity<ThemeModel>post(@RequestBody ThemeModel theme){
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(theme));
	}
	
	@PutMapping
	public ResponseEntity<ThemeModel>put(@RequestBody ThemeModel theme){
		
		return ResponseEntity.ok(repository.save(theme));
	}
	
	@DeleteMapping ("/{id}")
		public void delete (@PathVariable long id) {
			repository.deleteById(id);
    }

}