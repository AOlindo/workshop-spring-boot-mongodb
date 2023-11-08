package com.aOlindo.workshopmongodb.dto;

import java.io.Serializable;

import com.aOlindo.workshopmongodb.domain.User;

public class AtualizaUserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private String email;

	public AtualizaUserDTO() {

	}

	public AtualizaUserDTO(User obj) {
		this.name = obj.getName();
		this.email = obj.getEmail();
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

}
