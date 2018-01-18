<%@ page import="java.util.*, com.marianna.web.jdbc.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<title>  De Paul orchestra members  </title>
</head>
<%
	//get the students from the request object (sent by the servlet)
	List<Member> myMembers = (List<Member>) request.getAttribute("MEMBER_LIST");
%>
<body>
	HELLO

	<%
		response.setHeader("Cache-Control", "no-cashe, no-store, must-revalidate");
		if (session.getAttribute("mySessionUser") == null) {
			response.sendRedirect("indexing.jsp");
		}
	%>

	welcome ${mySessionUser}


	<div class="container bg-info" style="padding-top: 20px; padding-buttom: 20px;">
		<h2>De Paul orchestra members</h2>

		<div class="row">
			<div class="col-sm-4">
				<h6>Add new orchestra member to the table:</h6>

				<form role="form">
					<div class="form.group">
						<label>Full Name: </label>
						<input type="text" class="form.control" name="full-name" />
					</div>

					<div class="form.group">
						<label>Email: </label>
						<input type="text" class="form.control" name="email" />
					</div>

					<div class="form.group">
						<label>Title: </label>
						<input type="text" class="form.control" name="title" />
					</div>

					<div class="form.group">
						<label>Nationality: </label>
						<input type="text" class="form.control" name="nationality" />
					</div>

					<input class="btn btn-info" type="submit" value="Add member" />
					</form>
				
			</div>
			<div class="col-sm-7" style="padding-left: 70px">
			
			<table class="table table-hover">
				<tr>
					<th>Full Name</th>
					<th>Email</th>
					<th>Title</th>
					<th>Nationality</th>
					<th>Settings</th>
				</tr>

				<% for (Member temp : myMembers) { %>
				<tr>
					<td><%=temp.getFullName()%></td>
					<td><%=temp.getEmail()%></td>
					<td><%=temp.getNationality()%></td>
					<td><%=temp.getTitle()%></td>
					<td><input type="submit" class="btn btn-success" role="button" value="Edit" /></td>
					<td><input type="submit" class="btn btn-danger" role="button" value="Delete" /></td>
				</tr>
				<% } %>
			</table>	
			
			</div>
		</div>
		<br><br>
		
			<form action="indexing.jsp" method="post">
				<input class="bg-danger" type="submit" value="Log out" />
				<% session.removeAttribute("mySessionUser");
					session.invalidate(); %>
			</form>
	</div>

</body>
</html>
