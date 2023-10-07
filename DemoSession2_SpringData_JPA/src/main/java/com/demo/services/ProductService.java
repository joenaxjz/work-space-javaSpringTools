package com.demo.services;

import java.util.List;

import com.demo.entities.Product;

public interface ProductService {
	
	public Iterable<Product> findAll();
	
	public Product find(int id);
	
	public boolean save(Product product);
	
	public boolean delete(int id);
	
	public List<Product> findByStatus(boolean status);
	
	public List<Product> findByPrice(double min, double max);
	
	public List<Product> findByKeyword(String keyword);

}
