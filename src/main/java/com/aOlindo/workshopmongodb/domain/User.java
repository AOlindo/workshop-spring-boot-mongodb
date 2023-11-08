package com.aOlindo.workshopmongodb.domain;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.aOlindo.workshopmongodb.dto.AtualizaUserDTO;
import com.aOlindo.workshopmongodb.dto.CadastroUserDTO;

@Document(collection = "user")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String name;
	private String email;
	
	public User() {
		
	}
	
	public User(CadastroUserDTO user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
	}

	public User(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public void atualiza(AtualizaUserDTO atualiza) {
		if(atualiza.getName() != null) {
			this.name = atualiza.getName();
		}
		if(atualiza.getEmail() != null) {
			this.email = atualiza.getEmail();
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
	

	
	
	
	
	
	

}
