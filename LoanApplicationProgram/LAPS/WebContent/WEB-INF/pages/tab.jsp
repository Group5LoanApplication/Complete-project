<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	font-family: Arial;
}

/* Style the tab */
.tab {
	overflow: hidden;
	border: 1px solid #ccc;
	background-color: #f1f1f1;
}

/* Style the buttons inside the tab */
.tab button {
	background-color: inherit;
	float: left;
	border: none;
	outline: none;
	cursor: pointer;
	padding: 14px 16px;
	transition: 0.3s;
	font-size: 17px;
}

/* Change background color of buttons on hover */
.tab button:hover {
	background-color: #ddd;
}

/* Create an active/current tablink class */
.tab button.active {
	background-color: #ccc;
}

/* Style the tab content */
.tabcontent {
	display: none;
	padding: 6px 12px;
	border: 1px solid #ccc;
	border-top: none;
}
</style>

</head>
<body>
	<p>Select the type of user:</p>

	<div class="tab">
		<button class="tablinks" onclick="openCity(event, 'Client')"
			id="defaultOpen">Client</button>
		<button class="tablinks" onclick="openCity(event, 'Validator')">Validator</button>
		<button class="tablinks" onclick="openCity(event, 'Admin')">Admin</button>
		<button class="tablinks" onclick="openCity(event, 'Check')">Check
			Status</button>
	</div>

	<div id="Client" class="tabcontent">
		<h3>Client</h3>
		<jsp:include page="index.jsp"></jsp:include>
	</div>

	<div id="Validator" class="tabcontent">
		<h3>Loan Approval Department</h3>
		<p>Login please</p>
		<jsp:include page="ValidatorLogin.jsp"></jsp:include>
	</div>

	<div id="Admin" class="tabcontent">
		<h3>Admin</h3>
		<p>Change the policies(if u want)</p>
		<jsp:include page="ValidatorLogin.jsp"></jsp:include>

	</div>
	<div id="Check" class="tabcontent">
		<h3>Check Status By Entering Your Application Id</h3>
		<jsp:include page="ViewById.jsp"></jsp:include>

	</div>
	<script>
		function openCity(evt, userType) {
			var i, tabcontent, tablinks;
			tabcontent = document.getElementsByClassName("tabcontent");
			for (i = 0; i < tabcontent.length; i++) {
				tabcontent[i].style.display = "none";
			}
			tablinks = document.getElementsByClassName("tablinks");
			for (i = 0; i < tablinks.length; i++) {
				tablinks[i].className = tablinks[i].className.replace(
						" active", "");
			}
			document.getElementById(userType).style.display = "block";
			evt.currentTarget.className += " active";
		}

		// Get the element with id="defaultOpen" and click on it
		document.getElementById("defaultOpen").click();
	</script>
</body>
</html>