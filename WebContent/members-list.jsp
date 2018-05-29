<%@page import="com.marianna.web.bean.Member"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="WebContent/css/style.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<title>De Paul orchestra members</title>
</head>

<body>
	<%
	response.setHeader("Cache-Control", "no-cashe, no-store, must-revalidate");
	if (session.getAttribute("mySessionUser") == null) {
		//response.sendRedirect("index.jsp");
	}
%>

	welcome ${mySessionUser}


	<div class="container bg-secondary"
		style="padding-top: 20px; padding-buttom: 20px;">

		<h2>De Paul orchestra members</h2>

		<div class="row">

			<div class="col-sm-8" style="padding-left: 70px">

				<table class="table table-hover">
					<tr>
						<th>Full Name</th>
						<th>Email</th>
						<th>Title</th>
						<th>Nationality</th>
						<th>Settings</th>
					</tr>

					<%-- In this forEach loop MEMBER_LIST is the same 
				attribute name that we set by Servlet in MemberController.java class --%>
					<c:forEach var="tempMembers" items="${MEMBER_LIST}">
					
					<c:url var="tempLink" value="MemberController">
						<c:param name="command" value="LOAD" />
						<c:param  name="memberId" value="${tempMembers.id}"/>
					</c:url>
					
					
					<c:url var="deleteLink" value="MemberController">
						<c:param name="command" value="DELETE" />
						<c:param  name="memberId" value="${tempMembers.id}"/>
					</c:url>
					
					
						<tr>
							<td>${tempMembers.fullName}</td>
							<td>${tempMembers.email}</td>
							<td>${tempMembers.title}</td>
							<td>${tempMembers.nationality}</td>
							<td><a href="${tempLink}">UPDATE</a></td>
							<td><a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to remove this member?'))) return false">DELETE</a></td>
							<td>
							  <a href="${pageContext.request.contextPath}/MemberController?command=DELETE&memberId=${tempMembers.id}" 
                               onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">
								</a>
							</td>
						</tr>

					</c:forEach>
				</table>
			</div>
			
		</div>
		
		<div>
		<input type="button" value="Add new member" onclick="window.location.href='new-member-form.jsp'" />
		</div>

	
		<br>

		<form action="index.jsp" method="post">
			<input class="bg-danger" type="submit" value="Log out" />
			<%
				session.removeAttribute("mySessionUser");
				session.invalidate();
			%>
		</form>
	</div>

</body>
</html>
