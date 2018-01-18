<%@ page import="java.util.*, com.marianna.web.jdbc.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<title>new account</title>
</head>
<body>
	<h2>Welocme to Vivaldi's village of classical music</h2>
	<h5>The page is under construction...</h5>
	<br><br><br>
	
	<form action="MemberControllerServlet">
	Please fill in with the required information:
	<br><br>
	Enter a new name: <input type="text" name="user"/><br><br>
	Enter a new password: <input type="password" name="pass"/><br><br>
	Confirm new password: <input type="password" name="confpass"/><br><br>
	<input type="submit" value="Sign up" />
	<br><br><br>
	</form>


</body>
</html>