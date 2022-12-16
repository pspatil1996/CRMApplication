package com.marketingapp.services;

import java.util.List;

import com.marketingapp.entities.Lead;

public interface LeadService {
	public void saveLead(Lead lead);
	public List<Lead> listAll();
	public void deleteLeadById(long id);
	public Lead findOneLeadById(long id);

}
