package com.demo.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Employee {
	private int id;
	private String username;
	private String address;
	@JsonFormat(pattern = "dd/MM/yyy")
	private Date dob;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Employee(int id, String username, String address, Date dob) {
		super();
		this.id = id;
		this.username = username;
		this.address = address;
		this.dob = dob;
	}
	public Employee() {
		super();
	}
	
	
}
