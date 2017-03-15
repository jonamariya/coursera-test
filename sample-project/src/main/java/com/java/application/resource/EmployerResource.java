package com.java.application.resource;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.application.model.Employer;
import com.java.application.service.EmployerService;

@Controller
@Path("/employer")
public class EmployerResource {
 
	@Autowired
	private EmployerService employerService;
	
	public EmployerService getEmployerService() {
		return employerService;
	}

	public void setEmployerService(EmployerService employerService) {
		this.employerService = employerService;
	}

	@GET
	@RequestMapping(value="/employer",method=RequestMethod.GET)
	@ResponseBody
	public String getData(){
		System.out.println("Inside the method");
		Employer emp= new Employer();
		emp.setName("Jesus");
		employerService.createEmployer(emp);
		return "Jesus";
	}
}
