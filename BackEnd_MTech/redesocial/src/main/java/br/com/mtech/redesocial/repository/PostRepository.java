package br.com.mtech.redesocial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mtech.redesocial.model.PostModel;

@Repository
public interface PostRepository extends JpaRepository<PostModel, Long>{

	public List<PostModel> findAllByTitleContainingIgnoreCase(String title);
	
}
