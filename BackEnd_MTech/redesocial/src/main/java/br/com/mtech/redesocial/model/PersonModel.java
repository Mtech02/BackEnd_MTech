package br.com.mtech.redesocial.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_person")
public class PersonModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	@Size(min = 4, max = 255) // Fazer teste para ver o tamanho minimo.
	private String name;
	
	@NotBlank
	@Email(message = "Invalid Email!")
	private String email;
	
	@NotBlank
	@Size(min = 6)
	private String password;
	
	@OneToMany(mappedBy = "person", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("person")
	private List<PostModel> post;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<PostModel> getPost() {
		return post;
	}

	public void setPost(List<PostModel> post) {
		this.post = post;
	}
	
}
