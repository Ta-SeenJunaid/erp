package com.tj.erp.service;

import java.util.List;

import com.tj.erp.model.Project;

public interface ProjectService {
	
	public List<Project> findAll();
	
	public Project findBYID(int theId);
	
	public void save(Project theProject);
	
	public void deleteById(int theId);

}
