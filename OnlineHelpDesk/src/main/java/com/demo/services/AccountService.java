package com.demo.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.demo.entities.Nhanvien;

public interface AccountService extends UserDetailsService {
	public Iterable<Nhanvien> findAll();

	public boolean save(Nhanvien nhanvien);

	public Nhanvien login(String username, String password);

	public boolean delete(String username);
	
	public Nhanvien findByUsername(String username);
	
	public List<Nhanvien> findSupportEmp();

}
