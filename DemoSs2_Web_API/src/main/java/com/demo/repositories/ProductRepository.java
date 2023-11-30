package com.demo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entities.Category;
import com.demo.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

	// liệt kê n sản phẩm
	@Query(value = " select * from Product order by id desc limit :n ", nativeQuery = true)
	public List<Product> lastestNewProduct(@Param("n") int n);
	
	// liệt kê sản phẩm theo khoảng giá min, max
	@Query("from Product  where price >= :min and price <= :max")
	public List<Product> priceRanges(@Param("min") double min, @Param("max") double max);
	
	@Query("from Product where created >= :startDate and created <= :endDate")
	// liệt kê danh sách sản phẩm trong khoảng thời gian
	public List<Product> findByDates(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
	@Query("from Product where created = :created")
	// liệt kê danh sách sản phẩm trong 1 ngày
	public List<Product> findByDate(@Param("created") Date created);
	
	@Query("select sum(price) from Product where category.id = :categoryId")
	public long sumCategory(@Param("categoryId") int categoryId);
}
