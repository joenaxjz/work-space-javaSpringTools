package com.demo.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.demo.entities.Employee;

@Component
public class employeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.equals(Employee.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Employee employee = (Employee) target;
		if(employee.getUsername().equals("abc"))
		{
		errors.rejectValue("username", "Exists");
	}
	}
}
