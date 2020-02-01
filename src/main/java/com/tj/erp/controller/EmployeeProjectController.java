package com.tj.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tj.erp.model.EmployeeProject;
import com.tj.erp.service.EmployeeProjectService;


@RestController
@RequestMapping("/api")
public class EmployeeProjectController {
	
	private EmployeeProjectService employeeProjectService;

	@Autowired
	public EmployeeProjectController(EmployeeProjectService theEmployeeProjectService) {
		employeeProjectService = theEmployeeProjectService;
	}
	
	@GetMapping("/employeeProjects")
	public List<EmployeeProject> findAll(){
		return employeeProjectService.findAll();
	}
	
	@GetMapping("/employeeProjects/{employeeProjectId}")
	public EmployeeProject getEmployeeProject(@PathVariable int employeeProjectId) {
		
		EmployeeProject theemployeeProject = employeeProjectService.findBYID(employeeProjectId);
		
		if(theemployeeProject == null) {
			throw new RuntimeException("EmployeeProject id not found - " + employeeProjectId);
		}
		
		return theemployeeProject;
	}
	
	@PostMapping("/employeeProjects")
	public EmployeeProject addEmployeeProject(@RequestBody EmployeeProject theEmployeeProject) {
		
		theEmployeeProject.setEmployeeProjectId(0); 
		
		employeeProjectService.save(theEmployeeProject);
		
		return theEmployeeProject;
	}
	
	@PutMapping("/employeeProjects")
	public EmployeeProject updateEmployeeProject(@RequestBody EmployeeProject theEmployeeProject) {
		
		employeeProjectService.save(theEmployeeProject);
		
		return theEmployeeProject;
	}
	
	@DeleteMapping("/employeeProjects/{employeeProjectId}")
	public String deleteEmployeeProject(@PathVariable int employeeProjectId) {
		EmployeeProject theemployeeProject = employeeProjectService.findBYID(employeeProjectId);
		
		if (theemployeeProject == null) {
			throw new RuntimeException("employeeProjectProject id not found - "+ employeeProjectId);
		}
		
		employeeProjectService.deleteById(employeeProjectId);
		
		return "Deleted employeeProject id - " + employeeProjectId;
		
	}

}
