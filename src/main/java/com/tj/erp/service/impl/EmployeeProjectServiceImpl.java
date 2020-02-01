package com.tj.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj.erp.dao.EmployeeProjectDao;
import com.tj.erp.model.EmployeeProject;
import com.tj.erp.service.EmployeeProjectService;

@Service
public class EmployeeProjectServiceImpl implements EmployeeProjectService {
	
	private EmployeeProjectDao employeeProjectDao;
	
	@Autowired
	public EmployeeProjectServiceImpl(EmployeeProjectDao theEmployeeProjectDao) {
		employeeProjectDao = theEmployeeProjectDao;
	}

	@Override
	@Transactional
	public List<EmployeeProject> findAll() {
		
		return employeeProjectDao.findAll();
	}

	@Override
	@Transactional
	public EmployeeProject findBYID(int theId) {
		
		return employeeProjectDao.findBYID(theId);
	}

	@Override
	@Transactional
	public void save(EmployeeProject theEmployeeProject) {
		employeeProjectDao.save(theEmployeeProject);

	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeProjectDao.deleteById(theId);

	}

}
