package com.demo.services;

import java.util.List;

import org.modelmapper.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dtos.CategoryDTO;
import com.demo.entities.Category;
import com.demo.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public CategoryDTO find(int id) {
		
		return modelMapper.map(categoryRepository.findById(id).get(), CategoryDTO.class);
	}


	@Override
	public List<CategoryDTO> findAll() {
		// TODO Auto-generated method stub
		return modelMapper.map(categoryRepository.findAll(), new TypeToken<List<CategoryDTO>>(){}.getType());
	}


	@Override
	public List<CategoryDTO> findByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return modelMapper.map(categoryRepository.findByKeyword(keyword), new TypeToken<List<CategoryDTO>>(){}.getType());
	}


	@Override
	public boolean save(CategoryDTO categoryDTO) {
		try {
			Category category = modelMapper.map(categoryDTO, Category.class);
			categoryRepository.save(category);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}


	@Override
	public boolean delete(int id) {
		try {
			categoryRepository.delete(categoryRepository.findById(id).get());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
		
	}
	
	

}
