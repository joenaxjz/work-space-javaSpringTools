package com.demo.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entities.Category;
import com.demo.entities.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Integer> {

	@Query("from Language where languageId =:languageId and countryId =:countryId")
	public Language find(@Param("languageId") String languageId, @Param("countryId") String countryId);
	
}
