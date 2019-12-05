package com.tj.erp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "employeeProjectId",
          scope = EmployeeProject.class)

@Entity
public class EmployeeProject {
	
	@Id
	@GeneratedValue
	private int employeeProjectId;
	
	private String employeeProjectStatus;
	
	@ManyToOne
	private Employee employee;
	
	@ManyToOne
	private Project project;

	public int getEmployeeProjectId() {
		return employeeProjectId;
	}

	public void setEmployeeProjectId(int employeeProjectId) {
		this.employeeProjectId = employeeProjectId;
	}

	public String getEmployeeProjectStatus() {
		return employeeProjectStatus;
	}

	public void setEmployeeProjectStatus(String employeeProjectStatus) {
		this.employeeProjectStatus = employeeProjectStatus;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	
	
	


}
