package br.com.mtech.redesocial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mtech.redesocial.model.ThemeModel;

public interface ThemeRepository extends JpaRepository<ThemeModel, Long>{

	public List<ThemeModel> findAllByDescriptionContainingIgnoreCase(String description);
	
}
