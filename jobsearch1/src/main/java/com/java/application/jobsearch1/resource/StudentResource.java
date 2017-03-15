package com.java.application.jobsearch1.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.validator.engine.ConstraintViolationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java.application.jobsearch1.GenericDAOService;
import com.java.application.jobsearch1.dto.StudentDetails;
import com.java.application.jobsearch1.service.StudentJobApplicationServiceImpl;


@Path("/students")
@Controller
public class StudentResource {
	@Autowired
	private StudentJobApplicationServiceImpl studentJobApplicationServiceImpl;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllStudents() {
		List<StudentDetails> studentList = studentJobApplicationServiceImpl.getAllProfiles();
		return (Response.status(Status.OK).entity(new GenericEntity<List<StudentDetails>>(studentList) {
		}).header("access-control-allow-origin", "*").build());
	}

	@GET
	@Path("/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudentsbyId(@PathParam(value = "studentId") int studentId) {
		StudentDetails newStudent = (StudentDetails) studentJobApplicationServiceImpl.getProfileById( studentId);
		return (Response.status(Status.OK).entity(newStudent).header("access-control-allow-origin", "*").build());
	}

	@SuppressWarnings("unchecked")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response createStudent(StudentDetails student) {
		try{
			studentJobApplicationServiceImpl.createProfile(student);
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
	@Path("/{studentId}")
	public Response updateStudent(StudentDetails student, @PathParam(value = "studentId") int studentId) {
		// dao.save();
		// save use case
		StudentDetails studentdto = new StudentDetails();
		studentdto.setFirstName(student.getFirstName());
		//dao.save(studentdto);
		// need to code
		return (Response.status(Status.CREATED).header("access-control-allow-origin", "*").build());
	}

}
