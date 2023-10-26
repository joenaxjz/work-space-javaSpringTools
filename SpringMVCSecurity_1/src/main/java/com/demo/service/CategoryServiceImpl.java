package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Category;
import com.demo.reponsitory.CategoryRepository;
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public Iterable<Category> findAll() {
		// không cần viết câu truy vấn, kế thừa xong lấy qua dùng thôi :))))
		return categoryRepository.findAll();
	}
	@Override
	public boolean save(Category category) {
		try {
			
			categoryRepository.save(category);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean delete(int id) {
		try {
			categoryRepository.delete(find(id));
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public Category find(int id) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id).get();
	}

}
