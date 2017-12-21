package com.cg.laps.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.laps.dto.CustomerDetails;
import com.cg.laps.dto.LoanApplication;
import com.cg.laps.dto.LoanProgramsOffered;
import com.cg.laps.exception.LoanException;
import com.cg.laps.service.LoanService;
import com.cg.laps.service.LoanServiceImpl;

/**
 * Servlet implementation class LoanController
 */
@WebServlet(urlPatterns = { "/LoanCont1", "/formAction", "/CustomerForm",
		"/LoanForm", "/LoanForm2", "/formById", "/Login", "/ladActivity",
		"/Result" })
public class LoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	LoanService loanService;

	public LoanController() {
		super();
		loanService = new LoanServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession();
		String path = request.getServletPath();
		String url = "";
		System.out.println("idhar again");
		List<LoanProgramsOffered> programlist;
		CustomerDetails cust = new CustomerDetails();
		LoanApplication loan = new LoanApplication();
		switch (path) {
		case "/LoanCont1":
			System.out.println("LoanController");

			try {
				programlist = loanService.viewLoanProgramsOffered();
				request.setAttribute("program", programlist);
				dispatcher = request.getRequestDispatcher("LoanProgram.jsp");
				dispatcher.include(request, response);
			} catch (LoanException e) {
				e.printStackTrace();
				dispatcher = request.getRequestDispatcher("LoanError.jsp");
				request.setAttribute("exception", e);
				dispatcher.forward(request, response);
			}
			break;
		case "/formAction":
			System.out.println("formAction");

			String action = request.getParameter("action");
			String minimum = request.getParameter("mini");
			String maximum = request.getParameter("maxi");
			session.setAttribute("action1", action);
			session.setAttribute("minimum", minimum);
			session.setAttribute("maximum", maximum);
			dispatcher = request.getRequestDispatcher("CustomerForm.jsp");
			dispatcher.forward(request, response);
			break;

		case "/CustomerForm":
			System.out.println("CustomerForm");
			CustomerDetails customer = new CustomerDetails();

			try {
				String firstName = request.getParameter("firstName");
				String lastName = request.getParameter("lastName");
				String date = request.getParameter("dob");
				System.out.println("Date is : " + date);
				String status = request.getParameter("typeStatus.value");
				long mobNo = Long.parseLong(request
						.getParameter("mobileNumber"));
				long landline = Long.parseLong(request
						.getParameter("landlineNumber"));
				int dependents = Integer.parseInt(request
						.getParameter("dependents"));
				DateTimeFormatter formatter = DateTimeFormatter
						.ofPattern("yyyy-MM-dd");
				LocalDate custDob = LocalDate.parse(date, formatter);
				String email = request.getParameter("mail");
				customer.setApplicantName(firstName + " " + lastName);
				customer.setDob(custDob);
				customer.setMaritalStatus(status);
				customer.setMobileNumber(mobNo);
				customer.setPhoneNumber(landline);
				customer.setCountOfDepandants(dependents);
				customer.setEmailId(email);
				int applicationId = loanService.addCustomerDetails(customer);
				customer.setApplicationId(applicationId);
				session.setAttribute("CustomerBean", customer);
				dispatcher = request.getRequestDispatcher("LoanForm.jsp");
				dispatcher.forward(request, response);
			} catch (LoanException e) {
				e.printStackTrace();
				dispatcher = request.getRequestDispatcher("LoanError.jsp");
				request.setAttribute("exception", e);
				dispatcher.forward(request, response);
			}
			break;
		case "/LoanForm2":
			int applicationId = Integer.parseInt(request.getParameter("id"));
			String loanProgram = request.getParameter("progName");
			float amountOfLoan = Float.parseFloat(request
					.getParameter("amountOfLoan"));
			String address = request.getParameter("address");
			float annualFamilyIncome = Float.parseFloat(request
					.getParameter("familyIncome"));
			String documentProofs = request.getParameter("myDocs");

			LoanApplication loanBean = new LoanApplication();
			loanBean.setApplicationId(applicationId);
			loanBean.setApplicationDate(LocalDate.now());
			loanBean.setLoanProgram(loanProgram);
			loanBean.setAmountOfLoan(amountOfLoan);
			loanBean.setAddressOfProperty(address);
			loanBean.setAnnualFamilyIncome(annualFamilyIncome);
			loanBean.setDocumentProofs(documentProofs);
			session.setAttribute("loanApplication", loanBean);
			try {
				applicationId = loanService.addLoanApplicationDetails(loanBean);
				System.out.println("added");
				dispatcher = request.getRequestDispatcher("Success.jsp");
				dispatcher.forward(request, response);
			} catch (LoanException e) {
				e.printStackTrace();
				dispatcher = request.getRequestDispatcher("LoanError.jsp");
				request.setAttribute("exception", e);
				dispatcher.forward(request, response);
			}
			break;
		case "/formById":
			System.out.println("formById");

			applicationId = Integer.parseInt(request.getParameter("appName"));
			try {
				loan = loanService.viewLoanById(applicationId);
				cust = loanService.viewCustomerById(applicationId);
				session.setAttribute("viewLoan", loan);
				session.setAttribute("viewCustomer", cust);
				if (loan.getStatus().equals("ACCEPTED")) {
					LocalDate dateOfInter = loanService
							.getDateOfInterview(applicationId);
					session.setAttribute("interviewDate", dateOfInter);
				}
				dispatcher = request.getRequestDispatcher("Details.jsp");
				dispatcher.forward(request, response);
			} catch (LoanException e) {
				e.printStackTrace();
				dispatcher = request.getRequestDispatcher("LoanError.jsp");
				request.setAttribute("exception", e);
				dispatcher.forward(request, response);
			}
			break;
		case "/Login":
			System.out.println("Logging in");
			String uname = request.getParameter("uname");
			String pass = request.getParameter("psw");
			String role = request.getParameter("role");
			try {
				boolean res = loanService.loginService(uname, pass, role);
				session.setAttribute("credentials", res);
				programlist = loanService.viewLoanProgramsOffered();
				request.setAttribute("program", programlist);
				dispatcher = request
						.getRequestDispatcher("ApplicantDetails.jsp");
				dispatcher.forward(request, response);
			} catch (LoanException e) {
				e.printStackTrace();
				dispatcher = request.getRequestDispatcher("LoanError.jsp");
				request.setAttribute("exception", e);
				dispatcher.forward(request, response);
			}
			break;
		case "/ladActivity":
			System.out.println("Lad activity");
			List<LoanApplication> loan1;
			String activity = request.getParameter("activity");
			session.setAttribute("activity1", activity);
			try {
				loan1 = loanService.viewApplicationsByName(activity);
				session.setAttribute("loanDetails", loan1);
				dispatcher = request.getRequestDispatcher("LoanDetails.jsp");
				dispatcher.forward(request, response);
			} catch (LoanException e) {
				e.printStackTrace();
				dispatcher = request.getRequestDispatcher("LoanError.jsp");
				request.setAttribute("exception", e);
				dispatcher.forward(request, response);
			}
		case "/Result":
			System.out.println("after accept");
			String application = request.getParameter("appId");
			int appId = Integer.parseInt(application);
			String decision = request.getParameter("decision");
			request.setAttribute("ladDecision", decision);
			request.setAttribute("ladAppId", appId);
			System.out.println("appId: " + appId + " decision=" + decision);
			try {
				boolean result = loanService.updateStatus(appId, decision);
				dispatcher = request.getRequestDispatcher("Interview.jsp");
				System.out.println("hello");
				dispatcher.include(request, response);
			} catch (LoanException e) {
				e.printStackTrace();
				dispatcher = request.getRequestDispatcher("LoanError.jsp");
				request.setAttribute("exception", e);
				dispatcher.forward(request, response);
			}
			break;
		default:
			break;

		}

	}
}
