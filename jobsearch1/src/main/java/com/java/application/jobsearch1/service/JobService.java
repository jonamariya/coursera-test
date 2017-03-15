package com.java.application.jobsearch1.service;

import java.util.List;

import com.java.application.jobsearch1.dto.JobDetails;

public interface JobService {
	public List<JobDetails> getAllJobs(int empId);
	public JobDetails getJobById(int empId,int jobId);
	public void createJob(int empId,JobDetails profile);
}
