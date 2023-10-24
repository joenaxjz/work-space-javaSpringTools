package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Category;
import com.demo.entities.Item;
import com.demo.repositories.CategoryRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CategoryRepository cateRepo;

	@Override
	public int exist(int id, List<Item> cart) {
		for ( int i = 0; i < cart.size(); i++) {
			if(cart.get(i).getProduct().getId()==id) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public double total(List<Item> cart) {
		double s = 0;
		for (Item item : cart) {
			s += item.getProduct().getPrice() * item.getQuantity();
		}
		return s;
	}

	
	
	

}
