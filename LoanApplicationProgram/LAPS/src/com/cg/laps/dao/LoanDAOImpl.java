package com.cg.laps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.laps.dto.CustomerDetails;
import com.cg.laps.dto.LoanApplication;
import com.cg.laps.dto.LoanProgramsOffered;
import com.cg.laps.dto.Login;
import com.cg.laps.exception.LoanException;
import com.cg.laps.util.DBUtil;

public class LoanDAOImpl implements LoanDAO {
	Connection con;

	Logger logger = Logger.getRootLogger();

	public LoanDAOImpl() {
		con = DBUtil.getConnection();
		PropertyConfigurator.configure("resources/log4j.properties");
	}

	public int generateId() throws LoanException {
		int id = 0;
		String query = "SELECT seq_applicationId.nextval from dual";

		Statement stmt;
		try {
			logger.warn("Connecting to database to generate applicant Id");
			stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(query);
			if (result.next()) {
				id = result.getInt(1);
			}
		} catch (SQLException e) {
			logger.error("Unable to connect to database");
			e.printStackTrace();
		}

		return id;

	}

	@Override
	public int addCustomerDetails(CustomerDetails customerDTO)
			throws LoanException {

		String sql = "INSERT into customerDetails values(?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		boolean flag = false;
		int applicationId = generateId();
		System.out.println("app id =" + applicationId);
		try {
			logger.warn("Connecting to database to insert applicant details");
			preparedStatement = con.prepareStatement(sql);
			con.setAutoCommit(false);
			preparedStatement.setInt(1, applicationId);
			preparedStatement.setString(2, customerDTO.getApplicantName());
			LocalDate newDate = customerDTO.getDob();
			preparedStatement.setDate(3, java.sql.Date.valueOf(newDate));
			preparedStatement.setString(4, customerDTO.getMaritalStatus());
			preparedStatement.setLong(5, customerDTO.getPhoneNumber());
			preparedStatement.setLong(6, customerDTO.getMobileNumber());
			preparedStatement.setInt(7, customerDTO.getCountOfDepandants());
			preparedStatement.setString(8, customerDTO.getEmailId());
			result = preparedStatement.executeQuery();
			if (result != null) {
				flag = true;
				logger.info("Data Inserted in customer Detail table successfully.");
			} else {
				logger.error("Insertion failed");
			}
			con.commit();
		} catch (SQLException e) {
			logger.error("Unable to connect");
			e.printStackTrace();
			throw new LoanException("Unable to insert customer details");
		}
		return applicationId;
	}

	@Override
	public int addLoanApplicationDetails(LoanApplication loanDTO)
			throws LoanException {

		String sql = "INSERT into loanapplication (applicationId,application_date,loan_program,amountOfLoan,addressOfProperty,AnnualFamilyIncome,documentProofsAvailable,status) values(?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		boolean flag = false;
		try {
			logger.warn("Connecting to database to insert loan details");
			preparedStatement = con.prepareStatement(sql);
			con.setAutoCommit(false);
			preparedStatement.setInt(1, loanDTO.getApplicationId());
			preparedStatement.setDate(2,
					java.sql.Date.valueOf(loanDTO.getApplicationDate()));
			preparedStatement.setString(3, loanDTO.getLoanProgram());
			preparedStatement.setFloat(4, loanDTO.getAmountOfLoan());
			preparedStatement.setString(5, loanDTO.getAddressOfProperty());
			preparedStatement.setFloat(6, loanDTO.getAnnualFamilyIncome());
			preparedStatement.setString(7, loanDTO.getDocumentProofs());
			preparedStatement.setString(8, loanDTO.getStatus());
			result = preparedStatement.executeQuery();
			if (result != null) {
				flag = true;
				logger.info("Loan Details Added Succesfully.");
			} else {
				logger.info("Insertion failed");
			}
			con.commit();
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			throw new LoanException("Unable to insert loanapplication details");
		}
		return 1;
	}

	@Override
	public List<LoanProgramsOffered> viewLoanProgramsOffered()
			throws LoanException {
		List<LoanProgramsOffered> list = new ArrayList<LoanProgramsOffered>();
		String query = "select * from LoanProgramsOffered";
		try {
			logger.warn("Connecting to database to view loan programs offered");
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				LoanProgramsOffered bean = new LoanProgramsOffered();
				bean.setProgramName(resultSet.getString("programName"));
				bean.setDescription(resultSet.getString("description"));
				bean.setType(resultSet.getString("types"));
				bean.setDurationInYears(resultSet.getInt("durationInYears"));
				bean.setMinLoanAmount(resultSet.getFloat("minLoanAmount"));
				bean.setMaxLoanAmount(resultSet.getFloat("maxLoanAmount"));
				bean.setRateOfInterest(resultSet.getFloat("rateOfInterest"));
				bean.setProofsRequired(resultSet.getString("proofs_Required"));
				list.add(bean);
				logger.info("Loan details added successfully");
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			throw new LoanException("Unable to display Loan Programs Offered");
		}

		return list;
	}

	@Override
	public LoanApplication viewLoanById(int applicationId) throws LoanException {
		LoanApplication loan = new LoanApplication();
		Connection connection = DBUtil.getConnection();
		String query = "select applicationId,application_date,loan_program,amountOfLoan,"
				+ "addressOfProperty,AnnualFamilyIncome,documentProofsAvailable"
				+ ",status from loanapplication where applicationId=(?)";
		try {
			logger.warn("Connecting to database to view loan by Id");
			PreparedStatement preparedStatement = connection
					.prepareStatement(query);
			preparedStatement.setInt(1, applicationId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				loan.setApplicationId(resultSet.getInt(1));
				loan.setApplicationDate(resultSet.getDate(2).toLocalDate());
				loan.setLoanProgram(resultSet.getString(3));
				loan.setAmountOfLoan(resultSet.getFloat(4));
				loan.setAddressOfProperty(resultSet.getString(5));
				loan.setAnnualFamilyIncome(resultSet.getFloat(6));
				loan.setDocumentProofs(resultSet.getString(7));
				loan.setStatus(resultSet.getString(8));
				logger.info("Retrieving  details from loan application table");
			} else {
				logger.error("Retrieving  details failed");
				throw new LoanException(
						"Invalid application Id Please try again");
			}
			System.out.println(loan);
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new LoanException(
					"Unable to view Application Id or it doesnt exist");
		}
		return loan;
	}

	@Override
	public CustomerDetails viewCustomerById(int applicationId)
			throws LoanException {
		String qry = "Select applicant_name, mobile_number, email_id from customerdetails where applicationId=?";
		CustomerDetails cust = new CustomerDetails();
		try {
			logger.warn("Connecting to database to view customer by Id");
			PreparedStatement preparedStatement = con.prepareStatement(qry);
			preparedStatement.setInt(1, applicationId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				cust.setApplicantName(resultSet.getString(1));
				cust.setMobileNumber(resultSet.getLong(2));
				cust.setEmailId(resultSet.getString(3));
				logger.info("Retrieving details from customer table ");

			}
			logger.error("Retrieving Failed");
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			throw new LoanException("Unable to Fetch Customer Details");
		}

		return cust;
	}

	@Override
	public boolean loginService(String uname, String pass, String role)
			throws LoanException {
		Login log = new Login();
		String query = "select login_id,password,role from UserLogin where login_id=(?) "
				+ "AND password=(?) AND role=(?)";
		try {
			logger.warn("Connecting to database to login ");
			PreparedStatement pStmnt = con.prepareStatement(query);
			pStmnt.setString(1, uname);
			pStmnt.setString(2, pass);
			pStmnt.setString(3, role);
			ResultSet resultSet = pStmnt.executeQuery();
			if (resultSet.next()) {

				log.setLoginId(resultSet.getString(1));
				log.setPassword(resultSet.getString(2));
				log.setRole(resultSet.getString(3));
				logger.info("Retrieving Login credentials");
			} else {
				logger.error("Login Failed");
				throw new LoanException(
						"Unable to log in.Please check your credentials");
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new LoanException(
					"Unable to log in.Please check your credentials");
		}
		return true;
	}

	@Override
	public List<LoanApplication> viewApplicationsByName(String activity)
			throws LoanException {
		List<LoanApplication> list = new ArrayList<LoanApplication>();
		activity += " ";
		String query = "select applicationId,application_date,loan_program,amountOfLoan,addressOfProperty,AnnualFamilyIncome,documentProofsAvailable,status from loanapplication where loan_program like (?)"
				+ " AND status='APPLIED'";
		try {
			logger.warn("Connecting to database to view application by name");
			PreparedStatement pStatement = con.prepareStatement(query);
			pStatement.setString(1, activity);
			ResultSet resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				LoanApplication loan = new LoanApplication();
				loan.setApplicationId(resultSet.getInt(1));
				loan.setApplicationDate(resultSet.getDate(2).toLocalDate());
				loan.setLoanProgram(resultSet.getString(3));
				loan.setAmountOfLoan(resultSet.getFloat(4));
				loan.setAddressOfProperty(resultSet.getString(5));
				loan.setAnnualFamilyIncome(resultSet.getFloat(6));
				loan.setDocumentProofs(resultSet.getString(7));
				loan.setStatus(resultSet.getString(8));
				list.add(loan);
				logger.info("Retrieving Loan details Applied By Customer");
			}
			logger.info("Retrieving Failed");
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			throw new LoanException("Cannot fetch the loan details.");
		}
		return list;
	}

	@Override
	public boolean updateStatus(int appId, String decision)
			throws LoanException {
		String query;
		if (decision.equals("ACCEPT")) {
			query = "update loanapplication set status='ACCEPTED',dateofinterview=sysdate+3 where applicationId=(?)";
		} else {
			query = "update loanapplication set status='REJECTED' where applicationId=(?)";
		}

		try {
			logger.warn("Connecting to database to update status");
			PreparedStatement ptstmt = con.prepareStatement(query);
			ptstmt.setInt(1, appId);
			int result = ptstmt.executeUpdate();
			logger.info("Updating the status");
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			throw new LoanException(
					"Cannot Update the loan application status.");
		}

		return true;
	}

	@Override
	public LocalDate getDateOfInterview(int applicationId) throws LoanException {
		LocalDate interview = null;
		String query = "select dateofinterview from loanapplication where applicationId=?";
		try {
			logger.warn("Connecting to database to get date of interview");
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, applicationId);
			ResultSet result = statement.executeQuery();
			result.next();
			interview = result.getDate(1).toLocalDate();
			logger.info("Getting Interview Date");
		} catch (SQLException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		return interview;
	}

}
