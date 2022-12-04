package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private long eid;
	@Column
private String name;
	@Column
private String email;
	@Column
private String mobile;	
	
	@Column
private String password;



public Employee(String name, String email,String mobile, String password) {
	super();
	this.name = name;
	this.email = email;
	this.mobile=mobile;
	this.password = password;
}


public Employee() {
	super();
}


public long getId() {
	return eid;
}


public void setId(long eid) {
	this.eid = eid;
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


public String getMobile() {
	return mobile;
}


public void setMobile(String mobile) {
	this.mobile = mobile;
}






}
