package com.demo.entities;

import java.util.Date;

public class Product {
	private int id;
	private String name;
	private String photo;
	private double price;
	private Date created;
	
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
