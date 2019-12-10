package com.tj.erp.dao;

import java.util.List;

import com.tj.erp.model.Employee;


public interface EmployeeDao {
	
	public List<Employee> findAll();
	
	public Employee findBYID(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);

}
