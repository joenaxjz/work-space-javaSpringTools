package com.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.entities.Account;

@Service
public class AccountServiceImpl implements AccountService {

	private List<Account> accounts;
	
	public AccountServiceImpl() {
		accounts = new ArrayList<Account>();
		accounts.add(new Account (1, "acc1", "123123", "doan tuan anh", ""));
		accounts.add(new Account (2, "acc2", "123123", "thu phuong", ""));
		accounts.add(new Account (3, "acc3", "123123", "acc 11111", ""));
		accounts.add(new Account (4, "acc4", "123123", "tu do", ""));

	}
	
	@Override
	public boolean login(String username, String password) {
		for (Account account : accounts) {
			if(account.getUsername().equals(username) && account.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

}
