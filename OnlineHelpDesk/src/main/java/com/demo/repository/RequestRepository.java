package com.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entities.Nhanvien;
import com.demo.entities.Yeucau;

@Repository
public interface RequestRepository extends CrudRepository<Yeucau, Integer> {

	@Query("from Yeucau  where nhanvienByManvXuly.username = :username or nhanvienByManvGui.username = :username")
	public List<Yeucau> findByUsername(@Param("username") String username);
	
	@Query("from Yeucau  where nhanvienByManvGui.username = :username")
	public List<Yeucau> findByNvgui(@Param("username") String username);
	
	@Query("from Yeucau  where nhanvienByManvXuly.username = :username")
	public List<Yeucau> findByNvXuly(@Param("username") String username);
	
	@Query("from Yeucau  where douutien.madouutien = :madouutien")
	public List<Yeucau> findByDouutien(@Param("madouutien") int madouutien);
	
	@Query("from Yeucau  where ngaygui >= :from and ngaygui <= :to")
	public List<Yeucau> findByDates(@Param("from") Date from, @Param("to") Date to);

	@Query("from Yeucau  where mayeucau = :mayeucau")
	public Yeucau findById(@Param("mayeucau") int mayeucau);
	
}




