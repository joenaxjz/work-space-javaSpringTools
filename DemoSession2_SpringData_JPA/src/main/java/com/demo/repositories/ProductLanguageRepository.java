package com.demo.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entities.Category;
import com.demo.entities.Language;
import com.demo.entities.ProductLanguage;

@Repository
public interface ProductLanguageRepository extends CrudRepository<ProductLanguage, Integer> {

	@Query("from ProductLanguage where product.id =:productId and language.id =:languageId")
	public ProductLanguage find(@Param("productId") int productId, @Param("languageId") int languageId);
	
}
