package com.demo.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Product;
import com.demo.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;
	
	@Override
	public Iterable<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}

	@Override
	public Product find(int id) {
		// TODO Auto-generated method stub
		return productRepo.findById(id).get();
	}

	@Override
	public boolean save(Product product) {
		try {
			productRepo.save(product);
			return true;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		try {
			productRepo.delete(find(id));
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> findByStatus(boolean status) {
		// TODO Auto-generated method stub
		return productRepo.findByStatus(status);
	}

	@Override
	public List<Product> findByPrice(double min, double max) {
		return productRepo.findByPrice(min, max);
	}

	@Override
	public List<Product> findByKeyword(String keyword) {
		return productRepo.findByKeyword(keyword);
	}

}
