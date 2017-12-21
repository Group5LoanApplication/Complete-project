package com.cg.laps.dto;

import java.time.LocalDate;

public class CustomerDetails {

	private int applicationId;
	private String applicantName;
	private LocalDate dob;
	private String maritalStatus;
	private long phoneNumber;
	private long mobileNumber;
	private int countOfDepandants;
	private String emailId;

	public CustomerDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerDetails(int applicationId, String applicantName,
			LocalDate dob, String maritalStatus, long phoneNumber,
			long mobileNumber, int countOfDepandants, String emailId) {
		super();
		this.applicationId = applicationId;
		this.applicantName = applicantName;
		this.dob = dob;
		this.maritalStatus = maritalStatus;
		this.phoneNumber = phoneNumber;
		this.mobileNumber = mobileNumber;
		this.countOfDepandants = countOfDepandants;
		this.emailId = emailId;
	}

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getCountOfDepandants() {
		return countOfDepandants;
	}

	public void setCountOfDepandants(int countOfDepandants) {
		this.countOfDepandants = countOfDepandants;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
