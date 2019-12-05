package com.tj.erp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "deskId",
		  scope = Desk.class)

@Entity
public class Desk {
	
	@Id
	@GeneratedValue
	private int deskId;
	
	private String deskInfo;
	
	@ManyToMany
	private List<Employee> employee;

	public int getDeskId() {
		return deskId;
	}

	public void setDeskId(int deskId) {
		this.deskId = deskId;
	}

	public String getDeskInfo() {
		return deskInfo;
	}

	public void setDeskInfo(String deskInfo) {
		this.deskInfo = deskInfo;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
		

}
