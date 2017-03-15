package com.java.application.jobsearch1.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="JOB_DETAILS")
public class JobDetails {
	private int jobNumber;	
	private EmployerDetails employerDtl;
	private String jobTitle;
	private int hours;
	private String wage;
	private String jobCategory;
	private String jobType;
	private String workType;
	private String positionDesc;
	private String waysToApply;
	@Temporal(value = TemporalType.DATE)
	private Date datePosted;
	@Id 
	@Column(name="JOB_NUMBER")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getJobNumber() {
		return jobNumber;
	}
	public void setJobNumber(int jobNumber) {
		this.jobNumber = jobNumber;
	}
	
	@Column(name="JOB_TITLE")
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	@Column(name="HOURS")
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	@Column(name="WAGE")
	public String getWage() {
		return wage;
	}
	public void setWage(String wage) {
		this.wage = wage;
	}
	@Column(name="JOB_CATEGORY")
	public String getJobCategory() {
		return jobCategory;
	}
	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}
	@Column(name="JOB_TYPE")
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	@Column(name="WORK_TYPE")
	public String getWorkType() {
		return workType;
	}
	public void setWorkType(String workType) {
		this.workType = workType;
	}
	@Column(name="POSITION_DESC")
	public String getPositionDesc() {
		return positionDesc;
	}
	public void setPositionDesc(String positionDesc) {
		this.positionDesc = positionDesc;
	}
	@Column(name="WAYS_TO_APPLY")
	public String getWaysToApply() {
		return waysToApply;
	}
	public void setWaysToApply(String waysToApply) {
		this.waysToApply = waysToApply;
	}
	@Column(name="DATE_POSTED")
	public Date getDatePosted() {
		return datePosted;
	}
	public void setDatePosted(Date datePosted) {
		this.datePosted = datePosted;
	}
	public JobDetails(){}
	@ManyToOne
	@JoinColumn(name="EMPLOYER_ID")
	public EmployerDetails getEmployerDtl() {
		return employerDtl;
	}
	public void setEmployerDtl(EmployerDetails employerDtl) {
		this.employerDtl = employerDtl;
	}
	
}
