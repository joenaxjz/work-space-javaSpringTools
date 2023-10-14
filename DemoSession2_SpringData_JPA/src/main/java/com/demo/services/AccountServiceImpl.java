package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Account;
import com.demo.repositories.AccountRepository;
import com.demo.repositories.ProductRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public Iterable<Account> findAll() {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}

	@Override
	public boolean save(Account account) {
		try {
			accountRepository.save(account);
			return true;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		try {
			accountRepository.delete(find(id));
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Account find(int id) {
		// TODO Auto-generated method stub
		return accountRepository.findById(id).get();
	}

	@Override
	public Account login(String username, String password) {
		// TODO Auto-generated method stub
		return accountRepository.login(username, password, true);
	}

	@Override
	public Account findByUsername(String username) {
		// TODO Auto-generated method stub
		return accountRepository.findByUsername(username);
	}

}
