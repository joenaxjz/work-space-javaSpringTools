package com.demo.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.demo.entities.Nhanvien;
import com.demo.entities.Yeucau;

public interface RequestService{
	public Iterable<Yeucau> findAll();

	public List<Yeucau> findByUsername(String username);
	public List<Yeucau> findByNhanvienGui(String username);
	
	public List<Yeucau> findByNhanvienXuly(String username);
	
	public List<Yeucau> findByDouutien(int madouutien);
	
	public List<Yeucau> findByDates(Date from, Date to);
	
	public Yeucau findById(int mayeucau);
	
	public boolean save(Yeucau request);
	
	
	
}
