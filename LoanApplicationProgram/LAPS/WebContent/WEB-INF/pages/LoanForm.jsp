<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function updateTextInput(val) {
    document.getElementById('textInput').value="Rs "+val; 
  }
  
 function proofs(){
	 var str="";
	 var a=false;
	 var b=false;
	 var c=false;
	 var d=false;
	 if(document.getElementById("cb1").checked){
		 str+=document.getElementById("cb1").value;
		 str+=" ";
		  a=true;
	 }
	 if(document.getElementById("cb2").checked){
		 str+=document.getElementById("cb2").value;
		 str+=" ";
		 b=true;
	 }
	 str+=" ";
	 if(document.getElementById("cb3").checked){
		 str+=document.getElementById("cb3").value;
		 str+=" ";
		 c=true;
	 }
	 if(document.getElementById("cb4").checked){
		 str+=document.getElementById("cb4").value;
		 str+=" ";
		 d=true;
	 }
	 if(((a || b) || (c || d))){
		 alert("Docs are "+str+" Please Bring these documents when you get your Interview date.");
		 document.getElementById('docs').value=str;
		 return true;
	 }
	 else{
		 alert("Please Select the proofs available");
		 document.getElementById("myForm").reset();
		 return false;
	 }
	 
 }
</script>
</head>
<body>
	<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="s"%>
	<form action="LoanForm2" id="myForm">
	<h1 align="center">Loan Details Form</h1>
	<table border="1" align="center">
		<tr>
			<td><b>Application ID</b></td>
			<td><b>${CustomerBean.applicationId}</b>
			<input type="hidden" name="id" value="${CustomerBean.applicationId}" required>
			</td>
		</tr>
		<tr>
			<td><b>Loan Program</b></td>
			<td><b>${action1}</b><input type="hidden" value="${action1} " name="progName" required ></td>
		</tr>
		<tr>
		<td><b>Amount of Loan(In Lakhs)</b></td>
			<td><input type="range" style="float: left" name="amountOfLoan" min="${minimum }" max="${maximum }"  onchange="updateTextInput(this.value);" required>
			<input type="text" id="textInput" value="">
			</td>
		</tr>
		
		<td><b>Annual Family Income</b></td>
			<td><input type="number" style="float: left" name="familyIncome" min="100000" required></td>
		</tr>
		
		<tr>
			<td><b>Address of Property</b></td>
			<td><textarea name="address" rows='3' multiple size='3' required></textarea></td>
		</tr>

		<tr>
			<td><b>Document Proof Available</b></td>
			<td><input type="checkbox" name= "check" id="cb1" value="Aadhar">Aadhar
			<input type="checkbox" name= "check" id="cb2" value="Pan Card">Pan Card
			<input type="checkbox" name= "check" id="cb3" value="Voter Id">Voter Id
			<input type="checkbox" name= "check" id="cb4" value="Passport">Passport</td>
		</tr>
		
	</table>
	<input type="hidden" id="docs" name="myDocs" value="">
	<table align="center">
	<tr><td>
	<button type="submit" value="save" onclick="proofs()">Save</button></td></tr>
	</table>
	
	</form>

</body>
</html>