package com.demo.entities;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class Employee {
	
	@Length(min =3, max = 15)
	@NotEmpty //khong duoc rong
	private String username;

	@NotEmpty
	@Pattern(regexp="((?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})")
	private String password;
	
	@NotEmpty
	@Email
	private String email;
	
	@URL
	private String website;
	
	@Min(18)
	@Max(35)
	private int age;
	
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Employee(String username) {
		super();
		this.username = username;
	}

	public Employee() {
		super();
	}
	
	
}
