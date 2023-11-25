package com.demo.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.entities.Category;
import com.demo.entities.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Override
	public Product find() {
		// TODO Auto-generated method stub
		Product  product = new Product(1, "Name 1", 4.5, 16, new Date(), false, new Category(1, "category 1"));
		product.getColors().add("white");
		product.getColors().add("purple");
		product.getColors().add("red");
		product.getColors().add("blue");
		return product;
	}

	@Override
	public List<Product> findAll() {
		List<Product> products = new ArrayList<Product>();
		
		Product product1 = new Product(1, "Name 1", 4.5, 16, new Date(), false, new Category(1, "category 1"));
		product1.getColors().add("white");
		product1.getColors().add("red");
		product1.getColors().add("blue");
		products.add(product1);
		
		Product product2 = new Product(2, "Name 222222", 23, 10, new Date(), false, new Category(1, "category 1"));
		product2.getColors().add("white");
		product2.getColors().add("red");
		product2.getColors().add("blue");
		products.add(product2);
		
		Product product3 = new Product(3, "Name dsfsdf", 45, 100, new Date(), false, new Category(2, "category 2"));
		product3.getColors().add("white");
		product3.getColors().add("purple");
		product3.getColors().add("yellow");
		products.add(product3);
		
		return products;
	}

	@Override
	public boolean Create(Product product) {
		System.out.println("Product - Info - Create");
		System.out.print(product.toString());
		System.out.println("Colors");
		for (String color : product.getColors()) {
			System.out.println(color);
		}
		return true;
	}

	@Override
	public boolean update(Product product) {
		System.out.println("Product - Info - Update");
		System.out.print(product.toString());
		System.out.println("Colors");
		for (String color : product.getColors()) {
			System.out.println(color);
		}
		return true;
	}

	@Override
	public boolean delete(int id) {
		System.out.println("Id: " + id);
		return true;
	}

	
	
}
