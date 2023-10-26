package com.demo.reponsitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Category;

@Repository
// T: là kiểu dữ liệu muốn thao tác
//ID: là kiểu dữ liệu của khóa chính
public interface CategoryRepository extends CrudRepository<Category, Integer> {
	// khi kế thừa CrudRepository là đã có sẵn 5 hàm trong crudreposity đã có sắn
	
	
}
