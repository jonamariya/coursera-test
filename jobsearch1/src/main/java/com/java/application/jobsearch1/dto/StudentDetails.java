package com.java.application.jobsearch1.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="STUDENT_DETAILS")
@XmlRootElement
public class StudentDetails {
	
	private int studentId;
	
	@NotNull
	@Size(min = 1, max = 40)
	private String firstName;
	@NotNull
	@Size(min = 1, max = 40)
	private String lastName;
	@NotNull
	@Size(min = 1, max = 70)
	private String emailId;
	@NotNull
	@Size(min = 6, max = 30)
	private String phone;
	@Size(min = 6, max = 30)
	private String mobileNum;
	@Size(min = 1, max = 70)
	private String addressLn1;
	@Size(min = 1, max = 70)
	private String addressLn2;
	@Size(min = 1, max = 70)
	private String suburb;
	@Size(min = 1, max = 70)
	private String state;
	@Size(min = 4, max = 4)
	private String postcode;
	@Size(min = 1, max = 40)
	private String country;
	public StudentDetails(){}
	@Id 
	@Column(name="STUDENT_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		System.out.println("setStudentId>>>>>>>>>>>>>"+studentId);
		this.studentId = studentId;
	}
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
	@Column(name="MOBILE_NUM")
	public String getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
	@Column(name="ADDR_LN_1")
	public String getAddressLn1() {
		return addressLn1;
	}
	public void setAddressLn1(String addressLn1) {
		this.addressLn1 = addressLn1;
	}
	@Column(name="ADDR_LN_2")
	public String getAddressLn2() {
		return addressLn2;
	}
	public void setAddressLn2(String addressLn2) {
		this.addressLn2 = addressLn2;
	}
	@Column(name="SUBURB")
	public String getSuburb() {
		return suburb;
	}
	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}
	@Column(name="STATE")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Column(name="POSTCODE")
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	@Column(name="COUNTRY")
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public StudentDetails(int studentId, String firstName, String lastName, String emailId, String phone,
			String mobileNum, String addressLn1, String addressLn2, String suburb, String state, String postcode,
			String country) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phone = phone;
		this.mobileNum = mobileNum;
		this.addressLn1 = addressLn1;
		this.addressLn2 = addressLn2;
		this.suburb = suburb;
		this.state = state;
		this.postcode = postcode;
		this.country = country;
	}
	
}
