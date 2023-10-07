package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Category;
import com.demo.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository cateRepo;
	
	@Override
	public Iterable<Category> findAll() {
		// TODO Auto-generated method stub
		return cateRepo.findAll();
	}

}
