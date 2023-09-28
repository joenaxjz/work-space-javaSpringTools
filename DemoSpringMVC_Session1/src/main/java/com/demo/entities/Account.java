package com.demo.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Account {
	
	private int id;
	private String username;
	private String password;
	private String fullname;
	private String description;
	private String details;
	private String gender;
	private int cert;
	private int role;
	private Address address;
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public int getCert() {
		return cert;
	}
	public void setCert(int cert) {
		this.cert = cert;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date DoB;
		
	private boolean status;
	private int[] languages;
	
	public int[] getLanguages() {
		return languages;
	}
	public void setLanguages(int[] languages) {
		this.languages = languages;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Date getDoB() {
		return DoB;
	}
	public void setDoB(Date doB) {
		DoB = doB;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public Account(int id, String username, String password, String fullname, String description) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.description = description;
	}
	public Account() {
		super();
	}

	
	
	
}
