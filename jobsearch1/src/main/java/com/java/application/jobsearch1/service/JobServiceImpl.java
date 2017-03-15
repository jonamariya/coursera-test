package com.java.application.jobsearch1.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.application.jobsearch1.GenericDAOService;
import com.java.application.jobsearch1.dto.EmployerDetails;
import com.java.application.jobsearch1.dto.JobDetails;
@Service
public class JobServiceImpl implements JobService{
	@Autowired
	private GenericDAOService genericDAOService;
	public GenericDAOService getGenericDAOService() {
		return genericDAOService;
	}

	public void setGenericDAOService(GenericDAOService genericDAOService) {
		this.genericDAOService = genericDAOService;
	}

	@Override
	public List<JobDetails> getAllJobs(int empId) {
		EmployerDetails emp=(EmployerDetails) genericDAOService.get(EmployerDetails.class, empId);
		List<JobDetails> jobList = (List<JobDetails>) emp.getJobList();
		return jobList;
	}

	@Override
	public JobDetails getJobById(int empId, int jobId) {
		EmployerDetails emp=(EmployerDetails) genericDAOService.get(EmployerDetails.class, empId);
		List<JobDetails> jobList = (List<JobDetails>) emp.getJobList();
		JobDetails newJob =  (JobDetails) jobList.get(jobId);
		return newJob;
	}

	@Override
	public void createJob(int empId,JobDetails job) {
		EmployerDetails emp=(EmployerDetails) genericDAOService.get(EmployerDetails.class, empId);
		List<JobDetails> jobList = (List<JobDetails>) emp.getJobList();
		jobList.add(job);
		emp.setJobList(jobList);
		genericDAOService.save(emp);
			
	}
}
