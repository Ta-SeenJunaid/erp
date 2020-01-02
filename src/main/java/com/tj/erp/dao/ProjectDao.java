package com.tj.erp.dao;

import java.util.List;

import com.tj.erp.model.Project;



public interface ProjectDao {
	
	public List<Project> findAll();
	
	public Project findBYID(int theId);
	
	public void save(Project theProject);
	
	public void deleteByProjectId(int theId);

}
