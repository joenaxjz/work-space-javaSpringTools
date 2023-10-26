package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Role;
import com.demo.reponsitory.CategoryRepository;
import com.demo.reponsitory.RoleReponsitory;
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleReponsitory roleReponsitory;
	@Override
	public Iterable<Role> findAll() {
		// không cần viết câu truy vấn, kế thừa xong lấy qua dùng thôi :))))
		return roleReponsitory.findAll();
	}
	
}
