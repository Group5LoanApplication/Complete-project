package com.cg.laps.test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.cg.laps.dao.LoanDAO;
import com.cg.laps.dao.LoanDAOImpl;
import com.cg.laps.dto.CustomerDetails;
import com.cg.laps.dto.LoanApplication;
import com.cg.laps.dto.LoanProgramsOffered;
import com.cg.laps.exception.LoanException;

public class LoanDAOTest {

	static LoanDAO dao;
	static CustomerDetails customer;
	static LoanApplication loan;
	static LoanProgramsOffered programs;
	 

	@BeforeClass
	public static void initialize() {
		System.out.println("in before class");
		dao = new LoanDAOImpl();
		customer = new CustomerDetails();
		loan = new LoanApplication();
		programs = new LoanProgramsOffered();
	}

	/************************************
	 * Test case for addCustomerDetails()
	 * 
	 ************************************/
	@Test
	public void testAddCustomerDetails() throws LoanException {
		
		try {
			InitialContext context = new InitialContext();
			DataSource source = (DataSource) context.lookup("java:/OracleDs");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		LocalDate newDate = LocalDate.of(1999, 12, 11);	
		customer.setApplicantName("Himanshu Kemwal");
		customer.setDob(newDate);
		customer.setCountOfDepandants(5);
		customer.setEmailId("abc@gmail.com");
		customer.setMaritalStatus("Single");
		customer.setMobileNumber(9874563210L);
		customer.setPhoneNumber(89652310L);
		assertTrue("Data Inserted successfully",
				 dao.addCustomerDetails(customer) > 1000);
		
		 

	}

	/************************************
	 * Test case for addLoanApplicationDetails()
	 * 
	 ************************************/
	@Ignore
	public void testAddLoanApplicationDetails() throws LoanException {

		assertNotNull(dao.addLoanApplicationDetails(loan));

	}

	/********************************************
	 * Test case for viewLoanProgramsOffered()
	 ************************************************/
	@Ignore
	public void testviewLoanProgramsOffered() throws LoanException {
		assertNotNull(dao.viewLoanProgramsOffered());
	}

	/****************************************************
	 * Test case for viewLoanById()
	 ******************************************************/

	@Ignore
	public void testViewLoanById() throws LoanException {
		assertNotNull(dao.viewLoanById(1073));
	}

	/****************************************************
	 * Test case for viewCustomerById()
	 ******************************************************/

	@Ignore
	public void testViewCustomerById() throws LoanException {
		assertNotNull(dao.viewCustomerById(1073));
	}

	/****************************************************
	 * Test case for loginService()
	 ******************************************************/

	@Ignore
	public void testLoginService() throws LoanException {
		assertNotNull(dao.loginService("lad", "lad123", "Lad"));
	}

	/****************************************************
	 * Test case for viewApplicationsByName()
	 ******************************************************/

	@Ignore
	public void testViewApplicationsByName() throws LoanException {
		assertNotNull(dao.viewApplicationsByName("HL01"));
	}

	/****************************************************
	 * Test case for updateStatus()
	 ******************************************************/

	@Ignore
	public void testUpdateStatus() throws LoanException {
		assertNotNull(dao.updateStatus(1073, "ACCEPTED"));
	}

	/****************************************************
	 * Test case for getDateOfInterview()
	 ******************************************************/

	@Ignore
	public void testGetDateOfInterview() throws LoanException {
		assertNotNull(dao.getDateOfInterview(1073));
	}

}
