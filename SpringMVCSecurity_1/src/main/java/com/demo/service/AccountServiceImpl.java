package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.entities.Account;
import com.demo.entities.Category;
import com.demo.entities.Role;
import com.demo.reponsitory.AccountRepository;
import com.demo.reponsitory.CategoryRepository;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public boolean save(Account account) {
		try {

			accountRepository.save(account);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Account login(String username, String password) {
	    try {
	        return accountRepository.login(username, password);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null; // Trả về null nếu xảy ra lỗi hoặc không tìm thấy tài khoản.
	    }
	}

	@Override
	public Account findByUsername(String username) {
		return accountRepository.findByUsername(username);
	}

	@Override
	public Account findByEmail(String email) {
		return accountRepository.findByEmail(email);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.findByUsername(username);
		if(account == null) {
			throw new UsernameNotFoundException("Username Not Found");
		}else {
			List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
			for(Role role : account.getRoles()) {
				roles.add(new SimpleGrantedAuthority(role.getName()));
			}
			return new User(username, account.getPassword(), roles);
		}
	}

	

}
