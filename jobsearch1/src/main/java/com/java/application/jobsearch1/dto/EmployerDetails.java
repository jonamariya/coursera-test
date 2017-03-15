package com.java.application.jobsearch1.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="EMPLOYER_DETAILS")
public class EmployerDetails {
	private int employerId;
	@Size(min=1, max=40)
	@NotNull
	private String firstName;
	@Size(min=1, max=40)
	@NotNull
	private String lastName;
	@Size(min=1, max=78)
	@NotNull
	private String busniessName;
	@Size(min=3, max=78)
	@NotNull
	private String emailId;
	@Size(min=6, max=30)
	@NotNull
	private String phone;
	
	private Collection<JobDetails> jobList = new ArrayList<JobDetails>();
	@Column(name="FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column(name="LAST_NAME")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Column(name="BUSINESS_NAME")
	public String getBusniessName() {
		return busniessName;
	}
	public void setBusniessName(String busniessName) {
		this.busniessName = busniessName;
	}
	@Column(name="EMAIL_ID")
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Column(name="PHONE")
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public EmployerDetails(){}
	@Override
	public String toString() {
		return "EmployerDetails [firstName=" + firstName + ", lastName=" + lastName + ", busniessName=" + busniessName
				+ ", emailId=" + emailId + ", phone=" + phone + "]";
	}
	@Id 
	@Column(name="EMPLOYER_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getEmployerId() {
		return employerId;
	}
	public void setEmployerId(int employerId) {
		this.employerId = employerId;
	}
	@OneToMany(mappedBy="employerDtl",cascade=CascadeType.ALL,fetch=FetchType.LAZY,targetEntity=com.java.application.jobsearch1.dto.JobDetails.class)
	public Collection<JobDetails> getJobList() {
		return jobList;
	}
	public void setJobList(List<JobDetails> jobList) {
		this.jobList = jobList;
	}
	
	
}
