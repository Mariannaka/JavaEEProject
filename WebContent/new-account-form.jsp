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
	<h2>Welcome to Vivaldi's village of classical music</h2>
	<h5>The page is under construction...</h5>
	<br>
	<br>
	
	<form action="NewAccountController">
		Please fill in with the required information:
		<table>

			<tr>
				<td>Enter a new name:</td>
				<td><input type="text" name="user_name" /><br></td>
			</tr>

			<tr>

				<td>Enter a new password:</td>
				<td><input type="password" name="user_pass" /><br></td>
			</tr>
			
			<tr>
				<td><input type="submit" name="addAccount" value="Sign up" /></td>
			</tr>

		</table>
	</form>
	
	<br><br>
	<h3>Show all accounts:</h3>
		<form action="NewAccountController" method="POST">
            <input type="submit" name="showAccounts" value="Show" />
            <br>  
        </form>

</body>
</html>