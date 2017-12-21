package com.cg.laps.dto;

import java.time.LocalDate;

public class LoanApplication {
	private int applicationId;
	private LocalDate applicationDate;
	private String loanProgram;
	private float amountOfLoan;
	private String addressOfProperty;
	private float annualFamilyIncome;
	private String documentProofs;
	private String status;
	private LocalDate dateOfInterview;

	public LoanApplication() {
		status = "APPLIED";
	}

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public LocalDate getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getLoanProgram() {
		return loanProgram;
	}

	public void setLoanProgram(String loanProgram) {
		this.loanProgram = loanProgram;
	}

	public float getAmountOfLoan() {
		return amountOfLoan;
	}

	public void setAmountOfLoan(float amountOfLoan) {
		this.amountOfLoan = amountOfLoan;
	}

	public String getAddressOfProperty() {
		return addressOfProperty;
	}

	public void setAddressOfProperty(String addressOfProperty) {
		this.addressOfProperty = addressOfProperty;
	}

	public float getAnnualFamilyIncome() {
		return annualFamilyIncome;
	}

	public void setAnnualFamilyIncome(float annualFamilyIncome) {
		this.annualFamilyIncome = annualFamilyIncome;
	}

	public String getDocumentProofs() {
		return documentProofs;
	}

	public void setDocumentProofs(String documentProofs) {
		this.documentProofs = documentProofs;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDateOfInterview() {
		return dateOfInterview;
	}

	public void setDateOfInterview(LocalDate dateOfInterview) {
		this.dateOfInterview = dateOfInterview;
	}

}
