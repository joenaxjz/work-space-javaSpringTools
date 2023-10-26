package com.demo.reponsitory;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	// tu viet ham => use JPAQL
	@Query("from Product  where status = :status")
	public List<Product> findByStatus(@Param("status") boolean status);
	
	@Query("from Product  where name like %:keyword%")
	public List<Product> findBykeyword(@Param("keyword") String keyword);
	
	@Query("from Product  where year(created) = :year")
	public List<Product> findByYear(@Param("year") int year);
	
	@Query("from Product  where year(created) = :year and month(created) = :month")
	public List<Product> findByYearAndMonth(@Param("year") int year, @Param("month") int month);
	
	
	@Query("from Product where created >= :startDate and created <= :endDate")
	public List<Product> findByDates(@Param("startDate") Date startDate,
			@Param("endDate") Date endDate);
	
	@Query("from Product order by price desc")
	public List<Product> Sort1();
	
	@Query("from Product where status = :status order by price desc")
	public List<Product> Sort2(@Param("status") boolean status);
	
	
	@Query(value ="select * from Product order by price desc limit :n", nativeQuery = true)
	public List<Product> Limit1(@Param("n") int n);
	
	@Query(value ="select * from Product limit :start, :end", nativeQuery = true)
	public List<Product> Limit2(@Param("start") int start, @Param("end") int end);
	
	
	@Query("select count(id) from Product where status = :status")
	public long count2(@Param("status") boolean status);
	
	
	@Query("select sum(quantity) from Product")
	public long sum1();
	
	@Query("select sum(price * quantity) from Product")
	public double sum2();
	
	@Query("select max(price) from Product")
	public double max();
	
	@Query("select min(price) from Product")
	public double min();
	
	@Query("select avg(price) from Product")
	public double avg();
}
