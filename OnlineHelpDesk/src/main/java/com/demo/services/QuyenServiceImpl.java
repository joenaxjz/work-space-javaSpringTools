package com.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.entities.Quyen;
import com.demo.repository.RoleRepository;

@Service
public class QuyenServiceImpl implements QuyenService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Iterable<Quyen> findAll() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

	@Override
	public boolean save(Quyen role) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Quyen find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
