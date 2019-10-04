package com.crud.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/* @AllArgsConstructor cria automaticamente um construtor com todas os atributos da classe como argumento.*/
/* @NoArgsConstructor cria automaticamente um construtor vazio (sem argumentos).*/
/* @Data cria automaticamente os métodos toString, equals, hashCode, getters e setters*/
@Entity
public class Contact implements Serializable {
	
	private static final long serialVersionUID = 3960436649365666213L;	
	
	private Long id;
	
	private String name;
	private String email;
	private String phone;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="phone")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
