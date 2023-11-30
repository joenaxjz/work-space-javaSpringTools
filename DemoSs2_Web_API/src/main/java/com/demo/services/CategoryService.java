package com.demo.services;

import java.util.List;

import com.demo.dtos.CategoryDTO;
import com.demo.entities.Category;

public interface CategoryService {
	public CategoryDTO find(int id);
	
	public List<CategoryDTO> findAll();
	
	public List<CategoryDTO> findByKeyword(String keyword);
	
	public boolean save(CategoryDTO categoryDTO);
	
	public boolean delete(int id);
}
