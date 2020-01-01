package com.tj.erp.service;

import java.util.List;

import com.tj.erp.model.Desk;

public interface DeskService {
	
	public List<Desk> findAll();
	
	public Desk findBYID(int theId);
	
	public void save(Desk theDesk);
	
	public void deleteById(int theId);

}
