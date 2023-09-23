package com.demo.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.entities.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Override
	public Product find() {
		// TODO Auto-generated method stub
		return new Product(1, "product 1", "pic1.jpg", 5.6, new Date());
	}

	@Override
	public List<Product> findAll() {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(1, "product 1", "pic1.jpg", 5.6, new Date()));
		products.add(new Product(2, "product 2", "pic2.jpg", 5.6, new Date()));
		products.add(new Product(3, "product 3", "pic3.jpg", 5.6, new Date()));
		products.add(new Product(4, "product 4", "pic3.jpg", 5.6, new Date()));
		return products;
	}

	@Override
	public Product findById(int id) {
		List<Product> products = findAll();
		for (Product product : products) {
			if(product.getId() == id) {
				return product;
			}
		}
		return null;
	}

}
