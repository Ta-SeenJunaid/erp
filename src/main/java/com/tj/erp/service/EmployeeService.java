package com.tj.erp.service;

import java.util.List;

import com.tj.erp.model.Employee;


public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findBYID(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);

}
