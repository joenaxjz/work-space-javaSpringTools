package com.demo.dtos;

import java.util.Date;

import com.demo.entities.Category;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ProductDTO  {

	private int id;
	private String name;
	private double price;
	private int quantity;
	private String status;
	private String description;
	private String photo;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date created;
	
	private int categoryId;
	private String categoryName;
	
	
	
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String cateogoryName) {
		this.categoryName = cateogoryName;
	}
	
	
	
}
