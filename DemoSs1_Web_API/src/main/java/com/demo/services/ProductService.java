package com.demo.services;

import java.util.List;

import com.demo.entities.Product;

public interface ProductService {
	
	public Product find();
	
	public List<Product> findAll();
	
	public boolean Create (Product product);
	
	public boolean update (Product product);
	
	public boolean delete (int id);


}
