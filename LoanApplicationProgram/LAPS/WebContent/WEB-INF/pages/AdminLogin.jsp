<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="/action_page.php">

		<div class="container">
			<label><b>Username</b></label> <input type="text"
				placeholder="Enter Username" name="uname" required> <br>
			<br> <label><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="psw" required> <br>
			<hr>
			<input type="hidden" name="role" value="Admin">
			<button type="submit">Login</button>
			<br> <br>
		</div>

		</div>
	</form>
</body>
</html>