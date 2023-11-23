package com.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.entities.Nhanvien;
import com.demo.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Iterable<Nhanvien> findAll() {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}

	@Override
	public boolean save(Nhanvien nhanvien) {
		try {
			accountRepository.save(nhanvien);
			return true;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Nhanvien login(String username, String password) {
		// TODO Auto-generated method stub
		return accountRepository.login(username, password);
	}

	@Override
	public boolean delete(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Nhanvien findByUsername(String username) {
		// TODO Auto-generated method stub
		return accountRepository.findByUsername(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Nhanvien account = accountRepository.findByUsername(username);
		if(account == null) {
			throw new UsernameNotFoundException("Username Not Found");
		} else {
			List<GrantedAuthority> role = new ArrayList<GrantedAuthority>();
			role.add(new SimpleGrantedAuthority(account.getQuyen().getTenrole()));
			return new User(username, account.getPassword(), role);
		}
	}
	
	@Override
	public List<Nhanvien> findSupportEmp() {
		return accountRepository.findSupportEmp(2);
	}


}
