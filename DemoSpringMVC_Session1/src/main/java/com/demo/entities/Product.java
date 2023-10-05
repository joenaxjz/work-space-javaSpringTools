package com.demo.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Product {
	private int id;
	private String name;
	private String photo;
	private double price;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date created;
	private String category;
	
	public Product(int id, String name, String photo, double price, Date created, String category) {
		super();
		this.id = id;
		this.name = name;
		this.photo = photo;
		this.price = price;
		this.created = created;
		this.category = category;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Product(int id, String name, String photo, double price, Date created) {
		super();
		this.id = id;
		this.name = name;
		this.photo = photo;
		this.price = price;
		this.created = created;
	}
	public Product() {
		super();
	}
	
	
}
