package com.tj.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tj.erp.dao.DeskDao;
import com.tj.erp.model.Desk;
import com.tj.erp.service.DeskService;

@Service
public class DeskServiceImpl implements DeskService {
	
	private DeskDao deskDao;
	
	
	
	@Autowired
	public DeskServiceImpl(DeskDao theDeskDao) {
		deskDao = theDeskDao;
	}

	@Override
	@Transactional
	public List<Desk> findAll() {
		
		return deskDao.findAll();
	}

	@Override
	@Transactional
	public Desk findBYID(int theId) {
		
		return deskDao.findBYID(theId);
	}

	@Override
	@Transactional
	public void save(Desk theDesk) {
		deskDao.save(theDesk);

	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		deskDao.deleteById(theId);

	}

}
