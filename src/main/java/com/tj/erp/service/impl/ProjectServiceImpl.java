package com.tj.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj.erp.dao.ProjectDao;
import com.tj.erp.model.Project;
import com.tj.erp.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	
	private ProjectDao projectDao;
	
	
	@Autowired
	public ProjectServiceImpl(ProjectDao theProjectDao) {
		this.projectDao = theProjectDao;
	}

	@Override
	@Transactional
	public List<Project> findAll() {
		
		return projectDao.findAll();
	}

	@Override
	@Transactional
	public Project findBYID(int theId) {
		
		return projectDao.findBYID(theId);
	}

	@Override
	@Transactional
	public void save(Project theProject) {
		projectDao.save(theProject);

	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		projectDao.deleteByProjectId(theId);

	}

}
