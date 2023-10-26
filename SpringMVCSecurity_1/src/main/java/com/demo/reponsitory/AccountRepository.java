package com.demo.reponsitory;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entities.Account;

@Repository
// T: là kiểu dữ liệu muốn thao tác
//ID: là kiểu dữ liệu của khóa chính
public interface AccountRepository extends CrudRepository<Account, Integer> {
	@Query("from Account where username = :username and password = :password")
	public Account login(@Param("username") String username, @Param("password") String password);
	
	@Query("from Account where username = :username")
	public Account findByUsername(@Param("username") String username);
	
	
	@Query("from Account where email = :email")
	public Account findByEmail(@Param("email") String email);
}
