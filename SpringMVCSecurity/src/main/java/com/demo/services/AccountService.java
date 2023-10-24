package com.demo.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.demo.entities.Account;
import com.demo.entities.Category;

public interface AccountService extends UserDetailsService {
public Iterable<Account> findAll();
	
	public  boolean save(Account account);
	public Account login(String username, String password);
	public  boolean delete(int id);
	public  Account find(int  id);
	public Account findByUsername(String username);
	public Account findByEmail(String email);

}
