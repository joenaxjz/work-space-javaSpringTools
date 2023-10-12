package com.demo.services;

import com.demo.entities.Account;
import com.demo.entities.Category;

public interface AccountService {
public Iterable<Account> findAll();
	
	public  boolean save(Account account);
	
	public  boolean delete(int id);
	public  Account find(int  id);
}
