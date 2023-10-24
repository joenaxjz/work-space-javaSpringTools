package com.demo.services;

import com.demo.entities.Category;

public interface CategoryService {

	public Iterable<Category> findAll();
	
	public  boolean save(Category category);
	
	public  boolean delete(int id);
	public  Category find(int  id);


}
