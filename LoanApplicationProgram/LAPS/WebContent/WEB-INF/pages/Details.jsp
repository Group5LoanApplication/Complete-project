<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Application ID :</th>
			<td>${viewLoan.applicationId }</td>
		</tr>
		<tr>
			<th>Applicant Name:</th>
			<td>${viewCustomer.applicantName}</td>
		</tr>
		<tr>
			<th>Program Name:</th>
			<td>${viewLoan.loanProgram}</td>
		</tr>
		<tr>
			<th>Mobile Number:</th>
			<td>${viewCustomer.mobileNumber}</td>
		</tr>

		<tr>
			<th>Status:</th>
			<td>${viewLoan.status}</td>
		</tr>
		<c:set var="TR1" value="ACCEPTED" />
		<c:if test="${viewLoan.status eq TR1}">
			<p>
				Your Interview Date is:
				<c:out value="${interviewDate}" />
			<p>
			<p>Come with all the documents</p>
		</c:if>
	</table>
</body>
</html>