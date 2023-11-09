package com.aOlindo.workshopmongodb.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.aOlindo.workshopmongodb.domain.Post;

public class PostDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private Date date;
	private String title;
	private String body;

	private AuthorDTO author;

	public PostDTO() {

	}

	public PostDTO(Post obj) {
		super();
		this.id = obj.getId();
		this.date = obj.getDate();
		this.title = obj.getTitle();
		this.body = obj.getBody();
		this.author = obj.getAuthor();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}



}
