<%@ page import="java.util.*, com.marianna.web.jdbc.*"%>
<!DOCTYPE html>
<html>
<head>
<title>homepage</title>
</head>
<body>
	<h2>Welocme to Vivaldi's village of classic music</h2>
	<h5>The page is under construction...</h5>
	
	<form action="AccountLoginServlet" method="post">
	Please log in with your account:
	<br><br>
	
	Enter your name: <input type="text" name="user"/><br><br>
	Enter your password: <input type="password" name="pass"/><br><br>
	
	<input type="submit" value="Log in" />
	<br><br><br>
	Don't have an account? <a href="newaccount.jsp"> click here </a> to create a new account.
	</form>


</body>
</html>