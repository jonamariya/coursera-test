package com.java.application.jobsearch1.resource;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.application.jobsearch1.dto.JobDetails;
import com.java.application.jobsearch1.service.EmployerServiceImpl;
import com.java.application.jobsearch1.service.JobServiceImpl;

@Path("/")
public class JobResource {
	@Autowired
	private JobServiceImpl jobServiceImpl;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllJobs(@PathParam("empId") int empId) {
		List<JobDetails> jobList = jobServiceImpl.getAllJobs(empId);
		return (Response.status(Status.OK).entity(new GenericEntity<List<JobDetails>>(jobList) {
		}).header("access-control-allow-origin", "*").build());
	}

	@GET
	@Path("/{jobId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJobById(@PathParam("empId") int empId,@PathParam("jobId") int jobId) {
		JobDetails newJob = (JobDetails) jobServiceImpl.getJobById( empId,jobId);
		return (Response.status(Status.OK).entity(newJob).header("access-control-allow-origin", "*").build());
	}

	@SuppressWarnings("unchecked")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response createJob(@PathParam("empId") int empId,JobDetails job) {
		try{
			jobServiceImpl.createJob(empId,job);
			return (Response.status(Status.CREATED).header("access-control-allow-origin", "*").build());
		}catch(ConstraintViolationException cve){
			Set<ConstraintViolation<?>> violationsLst = cve.getConstraintViolations();
			StringBuilder errorStr = new StringBuilder();
			for(ConstraintViolation v : violationsLst){
				if(errorStr.length()>0)
				errorStr.append(";"+v.getMessage() + " for "+v.getPropertyPath());
				else
					errorStr.append(v.getMessage() + " for "+v.getPropertyPath());
			}
			return (Response.status(Status.BAD_REQUEST).entity(errorStr.toString()).build());
			
		}catch(Exception cve){
			return (Response.serverError().entity(cve.toString()).build());
		}
		
	}

	@SuppressWarnings("unchecked")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{empId}")
	public Response updateStudent(JobDetails emp, @PathParam(value = "empId") int empId) {
		// dao.save();
		// save use case
		JobDetails empdto = new JobDetails();
		//empdto.setFirstName(emp.getFirstName());
		//dao.save(empdto);
		// need to code
		return (Response.status(Status.CREATED).header("access-control-allow-origin", "*").build());
	}
	

}
