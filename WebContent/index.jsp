<%@ page import="java.util.*, com.marianna.web.jdbc.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<title>homepage</title>
</head>
<body>

				<h2>Welocme to Vivaldi's village of classical music</h2>
				<h5>The page is under construction...</h5>
				<br><br><br>

				<form action="AccountLoginServlet" method="post">
					<div class="modal-body">
						Please log in with your account: <br> <br>
						<form role="form">
							<div class="form-group">
								Enter your name: <input type="text" class="form-control"
									placeholder="username" name="user" />
							</div>
							<div class="form-group">
								Enter your password: <input type="password" class="form-control"
									placeholder="Password" name="pass" />
							</div>
							<div class="modal-footer">
					<input class="btn btn-primary btn-block" type="submit"
						value="Log in" />
				</div>
					</div>
				</form>
	
				<br><br><br>
				Don't have an account? <a href="newaccount.jsp"> click here </a> to create a new account.
				</form>


</body>
</html>