package com.java.application.jobsearch1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.application.jobsearch1.GenericDAOService;
import com.java.application.jobsearch1.dto.EmployerDetails;
import com.java.application.jobsearch1.dto.EmployerDetails;
@Service
public class EmployerServiceImpl implements EmployerService {
	@Autowired
	private GenericDAOService genericDAOService;
	public GenericDAOService getGenericDAOService() {
		return genericDAOService;
	}

	public void setGenericDAOService(GenericDAOService genericDAOService) {
		this.genericDAOService = genericDAOService;
	}

	@Override
	public List<EmployerDetails> getAllProfiles() {
		List<EmployerDetails> empList = (List<EmployerDetails>) genericDAOService.get(EmployerDetails.class);
		return empList;
	}

	@Override
	public EmployerDetails getProfileById(int profileId) {
		EmployerDetails newEmp = (EmployerDetails) genericDAOService.get(EmployerDetails.class, profileId);
		return newEmp;
	}

	@Override
	public void createProfile(EmployerDetails profile) {
		
			genericDAOService.save(profile);
			
	}


}
