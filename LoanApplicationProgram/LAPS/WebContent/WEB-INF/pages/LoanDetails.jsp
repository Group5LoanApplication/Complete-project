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
			<th>Program Name:</th>
			<th>Amount of Loan:</th>
			<th>Annual Family Income:</th>
			<th>Documents Proof Available:</th>
			<th>Accept</th>
			<th>Reject</th>
		</tr>
		<c:forEach var="loanList" items="${loanDetails}">
			<tr>
				<td>${loanList.applicationId }</td>
				<td>${loanList.loanProgram}</td>
				<td>${loanList.amountOfLoan}</td>
				<td>${loanList.annualFamilyIncome}</td>
				<td>${loanList.documentProofs}</td>
				<td><a
					href="Result?appId=${loanList.applicationId }&decision=ACCEPT">Accept</a></td>
				<td><a
					href="Result?appId=${loanList.applicationId }&decision=REJECT">Reject</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>