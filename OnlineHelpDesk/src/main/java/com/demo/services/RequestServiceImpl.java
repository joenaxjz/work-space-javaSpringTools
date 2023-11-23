package com.demo.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.entities.Nhanvien;
import com.demo.entities.Yeucau;
import com.demo.repository.AccountRepository;
import com.demo.repository.RequestRepository;

@Service("requestService")
public class RequestServiceImpl implements RequestService {

	@Autowired
	private RequestRepository requestRepository;


	@Autowired
	private AccountRepository accountRepository;
	

	@Override
	public Iterable<Yeucau> findAll() {
		// TODO Auto-generated method stub
		return requestRepository.findAll();
	}



	@Override
	public List<Yeucau> findByUsername(String username) {
		// TODO Auto-generated method stub
		return requestRepository.findByUsername(username);
	}



	@Override
	public Yeucau findById(int mayeucau) {
		// TODO Auto-generated method stub
		return requestRepository.findById(mayeucau);
	}



	@Override
	public boolean save(Yeucau request) {
		try {
			requestRepository.save(request);
			return true;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}



	@Override
	public List<Yeucau> findByNhanvienGui(String username) {
		// TODO Auto-generated method stub
		return requestRepository.findByNvgui(username);
	}



	@Override
	public List<Yeucau> findByNhanvienXuly(String username) {
		// TODO Auto-generated method stub
		return requestRepository.findByNvXuly(username);
	}



	@Override
	public List<Yeucau> findByDouutien(int madouutien) {
		// TODO Auto-generated method stub
		return requestRepository.findByDouutien(madouutien);
	}



	@Override
	public List<Yeucau> findByDates(Date from, Date to) {
		// TODO Auto-generated method stub
		return requestRepository.findByDates(from, to);
	}



	


}
