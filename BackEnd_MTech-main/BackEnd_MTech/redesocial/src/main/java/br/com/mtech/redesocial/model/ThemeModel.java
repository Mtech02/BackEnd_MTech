package br.com.mtech.redesocial.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_theme")
public class ThemeModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@Size(min = 4, max = 100)	//Coloca os tema (Vaga, Material de apoio, Cursos...)
	private String description; //Ao puxar no post, coloca qual o tema que se refere o post...
	
	@OneToMany(mappedBy = "theme", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("theme")
	private List<PostModel> post;
	
	public ThemeModel(long id, String description) {
		
		this.id = id;
		this.description = description;
		
	}
	
	public ThemeModel() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<PostModel> getPost() {
		return post;
	}

	public void setPost(List<PostModel> post) {
		this.post = post;
	}
	
}
