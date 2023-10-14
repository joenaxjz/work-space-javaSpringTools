package com.demo.services;

import java.util.List;

import com.demo.entities.Account;
import com.demo.entities.Role;

public interface RoleService {
	public Iterable<Role> findAll();
	public  boolean save(Role role);
	
	public  boolean delete(int id);
	public  Role find(int  id);
}
