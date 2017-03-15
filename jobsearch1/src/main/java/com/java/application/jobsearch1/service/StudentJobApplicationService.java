package com.java.application.jobsearch1.service;

import java.util.List;

import com.java.application.jobsearch1.dto.StudentDetails;

public interface StudentJobApplicationService {
	public List<StudentDetails> getAllProfiles();
	public StudentDetails getProfileById(int profileId);
	public void createProfile(StudentDetails profile);
	
}
