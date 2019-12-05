package com.tj.erp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.List;

@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id",
		  scope = Employee.class)

@Entity
public class Employee {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	private String info;
	
	@OneToMany(mappedBy="employee")
	private List<EmployeeProject> employeeProject; 
	
	@ManyToMany(mappedBy="employee")
	private List<Desk> desk;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public List<EmployeeProject> getEmployeeProject() {
		return employeeProject;
	}

	public void setEmployeeProject(List<EmployeeProject> employeeProject) {
		this.employeeProject = employeeProject;
	}

	public List<Desk> getDesk() {
		return desk;
	}

	public void setDesk(List<Desk> desk) {
		this.desk = desk;
	}
	
	

}
