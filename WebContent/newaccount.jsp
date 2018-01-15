<%@ page import="java.util.*, com.marianna.web.jdbc.*"%>
<!DOCTYPE html>
<html>
<head>
<title>homepage</title>
</head>
<body>
	<h2>Welocme to Vivaldi's village of classic music</h2>
	<h5>The page is under construction...</h5>
	
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