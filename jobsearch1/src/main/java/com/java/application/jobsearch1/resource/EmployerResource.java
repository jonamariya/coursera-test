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
import org.springframework.stereotype.Controller;

import com.java.application.jobsearch1.dto.EmployerDetails;
import com.java.application.jobsearch1.service.EmployerServiceImpl;
import com.java.application.jobsearch1.service.StudentJobApplicationServiceImpl;

@Path("/employers")
public class EmployerResource {

	@Autowired
	private EmployerServiceImpl employerServiceImpl;
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllEmployers() {
		List<EmployerDetails> empList = employerServiceImpl.getAllProfiles();
		return (Response.status(Status.OK).entity(new GenericEntity<List<EmployerDetails>>(empList) {
		}).header("access-control-allow-origin", "*").build());
	}

	@GET
	@Path("/{empId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployerbyId(@PathParam(value = "empId") int empId) {
		EmployerDetails newEmp = (EmployerDetails) employerServiceImpl.getProfileById( empId);
		return (Response.status(Status.OK).entity(newEmp).header("access-control-allow-origin", "*").build());
	}

	@SuppressWarnings("unchecked")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response createEmployer(EmployerDetails student) {
		try{
			employerServiceImpl.createProfile(student);
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
	public Response updateStudent(EmployerDetails emp, @PathParam(value = "empId") int empId) {
		// dao.save();
		// save use case
		EmployerDetails empdto = new EmployerDetails();
		empdto.setFirstName(emp.getFirstName());
		//dao.save(empdto);
		// need to code
		return (Response.status(Status.CREATED).header("access-control-allow-origin", "*").build());
	}
	
	@Path("/{empId}/jobs")
	public JobResource getJobResource() {
		return new JobResource();
	}
}
