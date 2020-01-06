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

import com.tj.erp.model.Project;
import com.tj.erp.service.ProjectService;


@RestController
@RequestMapping("/api")
public class ProjectController {
	
	private ProjectService projectService;

	@Autowired
	public ProjectController(ProjectService theProjectService) {
		projectService = theProjectService;
	}
	
	@GetMapping("/projects")
	public List<Project> findAll(){
		return projectService.findAll();
	}
	
	@GetMapping("/projects/{projectId}")
	public Project getProject(@PathVariable int projectId) {
		
		Project theproject = projectService.findBYID(projectId);
		
		if(theproject == null) {
			throw new RuntimeException("Project id not found - " + projectId);
		}
		
		return theproject;
	}
	
	@PostMapping("/projects")
	public Project addProject(@RequestBody Project theProject) {
		
		theProject.setProjectId(0);  
		
		projectService.save(theProject);
		
		return theProject;
	}
	
	@PutMapping("/projects")
	public Project updateProject(@RequestBody Project theProject) {
		
		projectService.save(theProject);
		
		return theProject;
	}
	
	@DeleteMapping("/projects/{projectId}")
	public String deleteProject(@PathVariable int projectId) {
		Project theproject = projectService.findBYID(projectId);
		
		if (theproject == null) {
			throw new RuntimeException("Project id not found - "+ projectId);
		}
		
		projectService.deleteById(projectId);
		
		return "Deleted project id - " + projectId;
		
	}
	


}
