package com.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entities.Nhanvien;

@Repository
public interface AccountRepository extends CrudRepository<Nhanvien, String> {

	@Query("from Nhanvien  where username = :username and password = :password")
	public Nhanvien login(@Param("username") String username, @Param("password") String password);
	
	@Query("from Nhanvien  where username = :username")
	public Nhanvien findByUsername(@Param("username") String username);
	
	@Query("from Nhanvien where quyen.marole =:maquyen")
	public List<Nhanvien> findSupportEmp(@Param("maquyen") int maquyen);
	
}




