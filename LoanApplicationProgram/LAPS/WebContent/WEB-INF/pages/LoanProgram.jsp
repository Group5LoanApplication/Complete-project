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
	<h2 align="center">
		<pre>
			<u>Please Select Program</u>   </pre>
	</h2>

	<c:forEach var="programs" items="${program}">
		<table border="0" cellspacing="10">
			<tr>
				<caption>
					<h3>Program Name: ${programs.programName}</h3>
				</caption>
			</tr>
			</h3>
			<tr>
				<th>Description:</th>
				<th>Interest Rate:</th>
				<th>Duration In Years:</th>
				<th>Type Of Loan:</th>
				<th>Minimum Loan Amount:</th>
				<th>Maximum Loan Amount:</th>
				<th>Proofs Required:</th>
			</tr>
			<tr>
				<td>${programs.description}</td>
				<td>${programs.rateOfInterest}</td>
				<td>${programs.durationInYears}</td>
				<td>${programs.type}</td>
				<td>${programs.minLoanAmount}</td>
				<td>${programs.maxLoanAmount}</td>
				<td>${programs.proofsRequired}</td>
				<br>
			</tr>
			<tr>
				<td colspan="7" align="center"><a
					href="formAction?action=${programs.programName}&mini=${programs.minLoanAmount}&maxi=${programs.maxLoanAmount}">Apply
						for Loan</a></td>
			</tr>

		</table>
		<hr>
		<br>
	</c:forEach>

</body>
</html>