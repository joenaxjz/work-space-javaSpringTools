package com.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

	@Query("from Product  where status = :status")
	public List<Product> findByStatus(@Param("status") boolean status);
	
	
	@Query("from Product  where price >= :min and price <= :max")
	public List<Product> findByPrice(@Param("min") double min, @Param("max") double max);
	
	@Query("from Product where name  like %:keyword% ")
	public List<Product> findByKeyword(@Param("keyword") String name);
}
