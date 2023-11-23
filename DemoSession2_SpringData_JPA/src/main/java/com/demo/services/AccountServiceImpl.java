package com.demo.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

	@Override
	public Account findByEmail(String email) {
		return accountRepository.findByEmail(email);
	}

	@Override
	public boolean login2(String username, String password) {
		return username.equals("abc") && password.equals("123");
	}

	@Override
	public List<Account> findByDob() {
		Date today = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH) + 1;
		return accountRepository.findByMonthAndDay(day, month);
	}

}
