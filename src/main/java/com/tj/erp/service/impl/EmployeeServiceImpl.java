package com.tj.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj.erp.dao.EmployeeDao;
import com.tj.erp.model.Employee;
import com.tj.erp.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDao employeeDao;
	
	
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDao theEmployeeDao) {
		employeeDao = theEmployeeDao;
	}


	@Override
	@Transactional
	public List<Employee> findAll() {
		
		return employeeDao.findAll();
	}


	@Override
	@Transactional
	public Employee findBYID(int theId) {
		
		return employeeDao.findBYID(theId);
	}


	@Override
	@Transactional
	public void save(Employee theEmployee) {
		employeeDao.save(theEmployee);
		
	}


	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeDao.deleteById(theId);
		
	}

}
