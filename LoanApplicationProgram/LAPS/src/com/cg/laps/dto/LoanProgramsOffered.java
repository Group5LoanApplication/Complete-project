package com.cg.laps.dto;

public class LoanProgramsOffered {
	private String programName;
	private String description;
	private String type;
	private int durationInYears;
	private float minLoanAmount;
	private float maxLoanAmount;
	private float rateOfInterest;
	private String proofsRequired;

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDurationInYears() {
		return durationInYears;
	}

	public void setDurationInYears(int durationInYears) {
		this.durationInYears = durationInYears;
	}

	public float getMinLoanAmount() {
		return minLoanAmount;
	}

	public void setMinLoanAmount(float minLoanAmount) {
		this.minLoanAmount = minLoanAmount;
	}

	public float getMaxLoanAmount() {
		return maxLoanAmount;
	}

	public void setMaxLoanAmount(float maxLoanAmount) {
		this.maxLoanAmount = maxLoanAmount;
	}

	public float getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(float rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public String getProofsRequired() {
		return proofsRequired;
	}

	public void setProofsRequired(String proofsRequired) {
		this.proofsRequired = proofsRequired;
	}

}
