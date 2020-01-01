package com.tj.erp.dao;

import java.util.List;

import com.tj.erp.model.Desk;

public interface DeskDao {
	
	public List<Desk> findAll();
	
	public Desk findBYID(int theId);
	
	public void save(Desk theDesk);
	
	public void deleteById(int theId);

}
