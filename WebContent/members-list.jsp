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
	

	<div id="container">
		<div id="main">
			<table>
				<td>
				<th>Full Name</th>
				<th>Email</th>
				<th>Title</th>
				<th>Nationality</th>
				</td>

				<%
					for (Member temp : myMembers) {
				%>
				<td><%=temp.getFullName()%></td>
				<td><%=temp.getEmail()%></td>
				<td><%=temp.getNationality()%></td>
				<td><%=temp.getTitle()%></td>
				<%
					}
				%>
			</table>

		</div>

	</div>


</body>
</html>
