package com.java.application.jobsearch1.service;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.application.jobsearch1.GenericDAOService;
import com.java.application.jobsearch1.dto.StudentDetails;
@Service
public class StudentJobApplicationServiceImpl implements StudentJobApplicationService {
	@Autowired
	private GenericDAOService genericDAOService;
	public GenericDAOService getGenericDAOService() {
		return genericDAOService;
	}

	public void setGenericDAOService(GenericDAOService genericDAOService) {
		this.genericDAOService = genericDAOService;
	}

	@Override
	public List<StudentDetails> getAllProfiles() {
		List<StudentDetails> studentList = (List<StudentDetails>) genericDAOService.get(StudentDetails.class);
		return studentList;
	}

	@Override
	public StudentDetails getProfileById(int profileId) {
		StudentDetails newStudent = (StudentDetails) genericDAOService.get(StudentDetails.class, profileId);
		return newStudent;
	}

	@Override
	public void createProfile(StudentDetails profile) {
		
			genericDAOService.save(profile);
			
	}

}
