package com.tj.erp.service;

import java.util.List;

import com.tj.erp.model.EmployeeProject;

public interface EmployeeProjectService {
	
	public List<EmployeeProject> findAll();
	
	public EmployeeProject findBYID(int theId);
	
	public void save(EmployeeProject theEmployeeProject);
	
	public void deleteById(int theId);


}
