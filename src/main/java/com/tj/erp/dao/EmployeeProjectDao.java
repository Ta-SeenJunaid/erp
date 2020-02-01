package com.tj.erp.dao;

import java.util.List;

import com.tj.erp.model.EmployeeProject;

public interface EmployeeProjectDao {
	
	public List<EmployeeProject> findAll();
	
	public EmployeeProject findBYID(int theId);
	
	public void save(EmployeeProject theEmployeeProject);
	
	public void deleteById(int theId);

}
