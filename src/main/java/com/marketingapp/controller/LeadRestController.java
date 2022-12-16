package com.marketingapp.controller;

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

import com.marketingapp.entities.Lead;
import com.marketingapp.services.LeadService;

@RestController
@RequestMapping("/leads")
public class LeadRestController {
	
		@Autowired	
		private LeadService leadService;
		
		@GetMapping
		public List<Lead> getAllLeads(){
			List<Lead> leads = leadService.listAll();
		return leads;
		}
		@PostMapping
		public void saveOneLead(@RequestBody Lead lead) {
			leadService.saveLead(lead);
		}
		@PutMapping
		public void updateOneLead(@RequestBody Lead lead) {
			leadService.saveLead(lead);
		}
		@DeleteMapping("/delete/{id}")
		public void deleteOneLead(@PathVariable("id")long id) {
			leadService.deleteLeadById(id);
		}
		
		//Exposing api or Developing end points
		@GetMapping("/api/get/{id}")
		public Lead getOneLead(@PathVariable("id")Long id) {
			Lead lead = leadService.findOneLeadById(id);
			return lead;
		}


}

