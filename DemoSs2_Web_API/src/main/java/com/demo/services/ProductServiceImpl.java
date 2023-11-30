package com.demo.services;

import java.util.Date;
import java.util.List;

import org.modelmapper.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dtos.CategoryDTO;
import com.demo.dtos.ProductDTO;
import com.demo.entities.Category;
import com.demo.repositories.CategoryRepository;
import com.demo.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<ProductDTO> findAll() {
		// TODO Auto-generated method stub
		return modelMapper.map(productRepository.findAll(), new TypeToken<List<ProductDTO>>(){}.getType());
	}

	@Override
	public ProductDTO find(int id) {
		// TODO Auto-generated method stub
		return modelMapper.map(productRepository.findById(id).get(), ProductDTO.class);
	}

	@Override
	//liệt kê n sản phẩm
	public List<ProductDTO> lastestNewProduct(int n) {
		// TODO Auto-generated method stub
		return modelMapper.map(productRepository.lastestNewProduct(n), new TypeToken<List<ProductDTO>>(){}.getType());
	}

	@Override
	// liệt kê sản phẩm theo khoảng giá min, max
	public List<ProductDTO> priceRanges(double min, double max) {
		// TODO Auto-generated method stub
		return modelMapper.map(productRepository.priceRanges(min, max), new TypeToken<List<ProductDTO>>(){}.getType());
	}

	@Override
	public List<ProductDTO> findByDates(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return modelMapper.map(productRepository.findByDates(startDate, endDate), new TypeToken<List<ProductDTO>>(){}.getType());
	}

	@Override
	public List<ProductDTO> findByDate(Date created) {
		// TODO Auto-generated method stub
		return  modelMapper.map(productRepository.findByDate(created), new TypeToken<List<ProductDTO>>(){}.getType());
	}

	@Override
	public double sumCategory(int categoryId) {
		// TODO Auto-generated method stub
		return modelMapper.map(productRepository.sumCategory(categoryId), new TypeToken<List<ProductDTO>>(){}.getType());
	}
	
}
