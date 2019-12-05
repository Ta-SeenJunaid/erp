package com.tj.erp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "projectId",
		  scope = Project.class)

@Entity
public class Project {

	@Id
	@GeneratedValue
	private int projectId;
	
	private String projectName;
	
	private String projectStatus;
	
	@OneToMany(mappedBy="project")
	private List<EmployeeProject> employeeProject; 

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public List<EmployeeProject> getEmployeeProject() {
		return employeeProject;
	}

	public void setEmployeeProject(List<EmployeeProject> employeeProject) {
		this.employeeProject = employeeProject;
	}
	
	
	
}
