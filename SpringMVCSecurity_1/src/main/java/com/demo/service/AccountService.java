package com.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.demo.entities.Account;


public interface AccountService extends UserDetailsService{
//	public Iterable<Account> findAll();
	
	public boolean save(Account account);
	
	public Account login(String username, String password);
	
	public Account findByUsername(String username);
	
	public Account findByEmail(String email);
	
//	public boolean delete(int id);
//	
//	public Category find(int id);
}
