package com.demo.reponsitory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Category;
import com.demo.entities.Role;

@Repository
// T: là kiểu dữ liệu muốn thao tác
//ID: là kiểu dữ liệu của khóa chính
public interface RoleReponsitory extends CrudRepository<Role, Integer> {
	// khi kế thừa CrudRepository là đã có sẵn 5 hàm trong crudreposity đã có sắn
	
	
}
