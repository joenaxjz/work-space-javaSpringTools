package com.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
