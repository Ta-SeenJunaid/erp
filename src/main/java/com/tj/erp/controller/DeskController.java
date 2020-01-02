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

import com.tj.erp.model.Desk;
import com.tj.erp.service.DeskService;

@RestController
@RequestMapping("/api")
public class DeskController {

	private DeskService deskService;

	@Autowired
	public DeskController(DeskService theDeskService) {
		deskService = theDeskService;
	}
	
	@GetMapping("/desks")
	public List<Desk> findAll(){
		return deskService.findAll();
	}
	
	@GetMapping("/desks/{deskId}")
	public Desk getDesk(@PathVariable int deskId) {
		
		Desk thedesk = deskService.findBYID(deskId);
		
		if(thedesk == null) {
			throw new RuntimeException("Desk id not found - " + deskId);
		}
		
		return thedesk;
	}
	
	@PostMapping("/desks")
	public Desk addDesk(@RequestBody Desk theDesk) {
		
		theDesk.setDeskId(0);;
		
		deskService.save(theDesk);
		
		return theDesk;
	}
	
	@PutMapping("/desks")
	public Desk updateDesk(@RequestBody Desk theDesk) {
		
		deskService.save(theDesk);
		
		return theDesk;
	}
	
	@DeleteMapping("/desks/{deskId}")
	public String deleteDesk(@PathVariable int deskId) {
		Desk thedesk = deskService.findBYID(deskId);
		
		if (thedesk == null) {
			throw new RuntimeException("Desk id not found - "+ deskId);
		}
		
		deskService.deleteById(deskId);
		
		return "Deleted desk id - " + deskId;
		
	}
	

	

}
