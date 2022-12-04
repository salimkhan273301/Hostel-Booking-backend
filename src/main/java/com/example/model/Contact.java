package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class Contact {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String comments;
	public Contact(long id, String name, String email, String comments) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.comments = comments;
	}
	public Contact() {
		super();
	}
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
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", email=" + email + ", comment=" + comments + "]";
	}
	
	
	
}