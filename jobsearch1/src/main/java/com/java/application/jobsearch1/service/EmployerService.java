package com.java.application.jobsearch1.service;

import java.util.List;

import com.java.application.jobsearch1.dto.EmployerDetails;


public interface EmployerService {
	public List<EmployerDetails> getAllProfiles();
	public EmployerDetails getProfileById(int profileId);
	public void createProfile(EmployerDetails profile);
}
