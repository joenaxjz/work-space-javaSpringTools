package com.demo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entities.Account;
import com.demo.entities.Product;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {

	@Query("from Account  where username = :username and password = :password and status = :status")
	public Account login(@Param("username") String username, @Param("password") String password, @Param("status") boolean status);
	
	@Query("from Account  where username = :username")
	public Account findByUsername(@Param("username") String username);
}




