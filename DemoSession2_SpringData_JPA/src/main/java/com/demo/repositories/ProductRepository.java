package com.demo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entities.Product;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer>, CrudRepository <Product, Integer> {

	@Query("from Product  where status = :status")
	public List<Product> findByStatus(@Param("status") boolean status);
	
	@Query("from Product  where price >= :min and price <= :max")
	public List<Product> findByPrice(@Param("min") double min, @Param("max") double max);
	
	@Query("from Product where name  like %:keyword% ")
	public List<Product> findByKeyword(@Param("keyword") String name);
	
	@Query("from Product where year(created) = :year")
	public List<Product> findByYear(@Param("year") int year);
	
	@Query("from Product where year(created) = :year and month(created) = :month")
	public List<Product> findByYearandMonth(@Param("year") int year, @Param("month") int month);
	
	@Query("from Product where created >= :startDate and created <= :endDate")
	public List<Product> findByDates(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
	@Query("from Product order by price desc")
	public List<Product> sort1();
	
	@Query("from Product where status = :status order by price desc")
	public List<Product> sort2(@Param("status") boolean status);
	
	@Query(value = " select * from Product order by id desc limit :n ", nativeQuery = true)
	public List<Product> limit1(@Param("n") int n);
	
	@Query(value = " select * from Product order by id desc limit :start, :n ", nativeQuery = true)
	public List<Product> limit2(@Param("start") int start, @Param("n") int n);
	
	@Query(value = " select * from Product where status = :status order by id desc limit :start, :n ", nativeQuery = true)
	public List<Product> limit3(@Param("start") int start, @Param("n") int n, @Param("status") boolean status);
	
	@Query("select count(id) from Product where status = :status")
	public long count2(@Param("status") boolean status);
	
	@Query("select sum(quantity) from Product")
	public long sum1();
	
	@Query("select sum(quantity) from Product where status = :status")
	public long sum2(@Param("status") boolean status);
	
	@Query("select sum(quantity*price) from Product where status = :status")
	public long sum3(@Param("status") boolean status);
	
	@Query("select max(price) from Product")
	public double maxPrice();
	
	@Query("select min(price) from Product")
	public double minPrice();
	
	@Query("select avg(price) from Product")
	public double avgPrice();
	
	@Query("select name from Product where name  like %:keyword% ")
	public List<String> findByKeywordAutoComplete(@Param("keyword") String name);
	
	
}




