<%@ page import="java.util.*, com.marianna.web.jdbc.*"%>
<!DOCTYPE html>
<html>
<head>
<title>De Paul orchestra members</title>
</head>
<%
List<Member> myMembers = (List<Member>) request.getAttribute("MEMBER_LIST");
%>
<body>
	HELLO 
	welcome <% session.getAttribute("myUser"); %>
	
	<div id="header">
	<h2>De Paul orchestra members</h2>
	</div>

	<div id="container">
		<div id="main">
			<table>
				<tr>
					<th>Full Name</th>
					<th>Email</th>
					<th>Title</th>
					<th>Nationality</th>
				</tr>

				<% for (Member temp : myMembers) { %>
				<tr>
					<td><%=temp.getFullName()%></td>
					<td><%=temp.getEmail()%></td>
					<td><%=temp.getNationality()%></td>
					<td><%=temp.getTitle()%></td>
				</tr>

				<% } %>
			</table>

			<form action="indexing.jsp">
				<input type="submit" value="Log out" />
				<% session.removeAttribute("mySessionUser");
					session.invalidate(); %>
			</form>

		</div>

	</div>
	
</body>
</html>
