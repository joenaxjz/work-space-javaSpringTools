package com.demo.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Product {
	private int id;
	private String name;
	private double price;
	private int quantity;
	@JsonFormat(pattern = "dd/MM/yyy")
	private Date create;
	private boolean status;
	private Category category;
	private List<String> colors = new ArrayList<>();
	
	
	
	public List<String> getColors() {
		return colors;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", create="
				+ create + ", status=" + status + ", category=" + category + "]";
	}
	public void setColors(List<String> colors) {
		this.colors = colors;
	}
	public Product(int id, String name, double price, int quantity, Date create, boolean status, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.create = create;
		this.status = status;
		this.category = category;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getCreate() {
		return create;
	}
	public void setCreate(Date create) {
		this.create = create;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Product(int id, String name, double price, int quantity, Date create, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.create = create;
		this.status = status;
	}
	public Product() {
		super();
	}
	
	
}
