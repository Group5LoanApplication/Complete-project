package com.cg.laps.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.laps.dao.LoanDAO;
import com.cg.laps.dao.LoanDAOImpl;
import com.cg.laps.dto.CustomerDetails;
import com.cg.laps.dto.LoanApplication;
import com.cg.laps.dto.LoanProgramsOffered;
import com.cg.laps.exception.LoanException;

public class LoanServiceImpl implements LoanService {
	LoanDAO Dao = null;

	public LoanServiceImpl() {
		Dao = new LoanDAOImpl();
	}

	@Override
	public int addCustomerDetails(CustomerDetails customerDTO)
			throws LoanException {
		return Dao.addCustomerDetails(customerDTO);
	}

	@Override
	public List<LoanProgramsOffered> viewLoanProgramsOffered()
			throws LoanException {

		return Dao.viewLoanProgramsOffered();
	}

	@Override
	public LoanApplication viewLoanById(int applicationId) throws LoanException {

		return Dao.viewLoanById(applicationId);
	}

	@Override
	public int addLoanApplicationDetails(LoanApplication loanDTO)
			throws LoanException {
		return Dao.addLoanApplicationDetails(loanDTO);
	}

	@Override
	public CustomerDetails viewCustomerById(int applicationId)
			throws LoanException {

		return Dao.viewCustomerById(applicationId);
	}

	@Override
	public boolean loginService(String uname, String pass, String role)
			throws LoanException {
		return Dao.loginService(uname, pass, role);
	}

	@Override
	public List<LoanApplication> viewApplicationsByName(String activity)
			throws LoanException {
		return Dao.viewApplicationsByName(activity);
	}

	@Override
	public boolean updateStatus(int appId, String decision)
			throws LoanException {
		return Dao.updateStatus(appId, decision);

	}

	@Override
	public LocalDate getDateOfInterview(int applicationId) throws LoanException {
		// TODO Auto-generated method stub
		return Dao.getDateOfInterview(applicationId);
	}

}
