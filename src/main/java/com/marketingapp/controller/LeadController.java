package com.marketingapp.controller;

import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp.dto.LeadData;
import com.marketingapp.entities.Lead;
import com.marketingapp.services.LeadService;

@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadService;
	
	@RequestMapping("/createLead")
	public String viewCreateLeadPage() {
		return"create_new_laed";
	}
	@RequestMapping("/saveLead")
	public String saveOneLead(@ModelAttribute("lead")Lead lead, ModelMap model) {
	 leadService.saveLead(lead);
	 model.addAttribute("saveMsg", "Record is saved!");
	   return"create_new_laed";
	}
    @RequestMapping("/listleads")
	public String getAllLeads(ModelMap model) {
	List<Lead> leads = leadService.listAll();
	model.addAttribute("leads", leads);
	return"search_result";
	}
    
    @RequestMapping("/delete")
    public String deleteOneLead(@RequestParam("id") long id,ModelMap model) {
    	leadService.deleteLeadById(id);
    	
    	List<Lead> leads = leadService.listAll();
    	model.addAttribute("leads", leads);
    	return"search_result";
    	
    }
    
    @RequestMapping("/update")
    public String updateOneLead(@RequestParam("id") long id,ModelMap model) {
    	Lead lead = leadService.findOneLeadById(id);
    	if(lead!=null) {
    		model.addAttribute("lead", lead);
    		return "update_lead";
    	}else {
    		model.addAttribute("error","No record found");
    		return"error_page";
    	}
    	
    	
    }
    @RequestMapping("/updateLead")
    public String updateLead(LeadData data, ModelMap model) {
    	Lead l = new Lead();
    	l.setId(data.getId());
    	l.setFirstName(data.getFirstName());
		l.setLastName(data.getLastName());
		l.setEmail(data.getEmail());
		l.setMobile(data.getMobile());
		 leadService.saveLead(l);
		
		List<Lead> leads = leadService.listAll();
    	model.addAttribute("leads", leads);
    	return"search_result";
    	
    }
	
//	@RequestMapping("/saveLead")
//	public String saveOneLead(LeadData data) {
//		System.out.println(data.getFirstName());
//		System.out.println(data.getLastName());
//		System.out.println(data.getEmail());
//		System.out.println(data.getMobile());
//	   return"create_new_laed";
//	} 
// this method used when entity class not there .... create LeadData class and use ref variable	
//and data required in backend not in database..
	// for to save database below
	
//	@RequestMapping("/saveLead")
//	public String saveOneLead(LeadData data) {
//		Lead l = new Lead();
//		l.setFirstName(data.getFirstName());
//		l.setLastName(data.getLastName());
//		l.setEmail(data.getEmail());
//		l.setMobile(data.getMobile());
//		 leadService.saveLead(l);
//	   return"create_new_laed";
//	} 
//	
//	@RequestMapping("/saveLead")
//	public String saveOneLead(@RequestParam("firstName") String fname,@RequestParam("lastName") String lname,@RequestParam("email") String emailid,@RequestParam("mobile") long mobile) {
//		Lead l = new Lead();
//		l.setFirstName(fname);
//		l.setLastName(lname);
//		l.setEmail(emailid);
//		l.setMobile(mobile);
//		 leadService.saveLead(l);
//	   return"create_new_laed";
//	} 
	
}
