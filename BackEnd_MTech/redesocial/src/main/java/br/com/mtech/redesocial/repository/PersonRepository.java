package br.com.mtech.redesocial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mtech.redesocial.model.PersonModel;

public interface PersonRepository extends JpaRepository<PersonModel, Long>{

	public List<PersonModel> findAllByNameContainingIgnoreCase(String name);
	
}
