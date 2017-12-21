package com.cg.laps.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.laps.dto.CustomerDetails;
import com.cg.laps.dto.LoanApplication;
import com.cg.laps.dto.LoanProgramsOffered;
import com.cg.laps.exception.LoanException;

public interface LoanService {
	public int addCustomerDetails(CustomerDetails customerDTO)
			throws LoanException;

	public List<LoanProgramsOffered> viewLoanProgramsOffered()
			throws LoanException;

	public LoanApplication viewLoanById(int applicationId) throws LoanException;

	public int addLoanApplicationDetails(LoanApplication loanDTO)
			throws LoanException;

	public CustomerDetails viewCustomerById(int applicationId)
			throws LoanException;

	public boolean loginService(String uname, String pass, String role)
			throws LoanException;

	public List<LoanApplication> viewApplicationsByName(String activity)
			throws LoanException;

	public boolean updateStatus(int appId, String decision)
			throws LoanException;

	public LocalDate getDateOfInterview(int applicationId) throws LoanException;

}
