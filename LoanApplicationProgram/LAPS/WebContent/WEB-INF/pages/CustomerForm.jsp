<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function myFunction() {
	 var isvalid = false;
    var x = document.getElementById("myDate").value;
    var d= new Date(x);
    var y = d.getFullYear();
    if(y>2000){
     alert("year should be less than or equal to 2000: "+y);
     var z = document.getElementById("myDate").value="";
     return isvalid;
    }
    else
    {
   return  isvalid;
    }
}
</script>
</head>
<body>

	<form action="CustomerForm">
		<h1 align="center">Application Form</h1>
		<table border="1" align="center">
			<tr>
				<td><b>First Name</b></td>
				<td><input type="text" name="firstName"
					pattern="^[A-Z][a-z]{2,9}"
					title="First Name Should Start With Uppercase and should contain minimum of 3 Characters"
					required></td>
			</tr>
			<tr>
				<td><b>Last Name</b></td>
				<td><input type="text" name="lastName"
					pattern="^[A-Z][a-z]{2,9}"
					title="Last Name Should Start With Uppercase and should contain minimum of 3 Characters"
					required></td>
			</tr>
			<tr>
				<td><b>Date of Birth</b></td>
				<td><input type="date" id="myDate" style="float: left" name="dob" value="2014-02-09" required /></td>
			</tr>
			<tr>
			<tr>
				<td><b>Marital Status</b></td>
				<td><input type="radio" value="single" name="typeStatus"
					required>Single <input type="radio" value="married"
					name="typeStatus" required>Married <input type="radio"
					value="divorced" name="typeStatus" required>Divorced <input
					type="radio" value="widowed" name="typeStatus" required>Widowed</td>
			</tr>


			<td><b>Mobile Number</b></td>
			<td><input type="text" name="mobileNumber" required
				pattern="[7-8-9][0-9]{9}"></td>
			</tr>
			<tr>
				<td><b>Landline Number</b></td>
				<td><input type="text" name="landlineNumber"
					pattern="[2-9][0-9]{7}"></td>
			</tr>
			<tr>
				<td><b>Counts of Dependents</b></td>
				<td><select style="float: left" name="dependents" required>
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
						<option>8</option>
						<option>9</option>
						<option>10</option>
				</select></td>
			</tr>

			<tr>
				<td><b>Email</b></td>
				<td><input type="email" name="mail" required></td>
			</tr>
			<tr>
				<td><button type="submit" onclick="myFunction()">Next Page</button></td>
				<td></td>
			</tr>
		</table>

	</form>
</body>
</html>