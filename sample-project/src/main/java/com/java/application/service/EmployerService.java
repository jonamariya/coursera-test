package com.java.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.application.dao.GenericDAOService;
import com.java.application.model.Employer;
@Service
public class EmployerService {
	@Autowired
	private GenericDAOService genericDAOService;

	public GenericDAOService getGenericDAOService() {
		return genericDAOService;
	}

	public void setGenericDAOService(GenericDAOService genericDAOService) {
		this.genericDAOService = genericDAOService;
	}
	
	public void createEmployer(Employer emp){
		genericDAOService.save(emp);
	}
	 
 
}
