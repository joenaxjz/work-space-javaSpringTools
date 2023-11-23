package com.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Douutien;
import com.demo.entities.Quyen;
import com.demo.repository.DouutienRepository;
import com.demo.repository.RoleRepository;

@Service
public class DouutienServiceImpl implements DouutienService {

	@Autowired
	private DouutienRepository douutienRepository;
	
	@Override
	public Iterable<Douutien> findAll() {
		// TODO Auto-generated method stub
		return douutienRepository.findAll();
	}

}
