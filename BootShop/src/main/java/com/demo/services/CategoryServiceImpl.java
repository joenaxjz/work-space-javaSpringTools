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

	@Override
	public boolean save(Category category) {
		try {
			cateRepo.save(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		try {
			cateRepo.delete(find(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Category find(int id) {
		// TODO Auto-generated method stub
		return cateRepo.findById(id).get();
	}

}
