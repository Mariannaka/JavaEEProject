<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>
</script>
    </head>
    <body>
All Employees: <br> 

<div class="row">

			<div class="col-sm-8" style="padding-left: 70px">

				<table class="table table-hover">
					<tr>
						<th>Id</th>
						<th>Name</th>
					</tr>

					<%-- In this forEach loop accountList is the same 
				attribute name that we set by Servlet in NewAccountController.java class --%>
					<c:forEach var="tempAccount" items="${accountList}">
					
						<tr>
							<td>${tempAccount.userId}</td>
							<td>${tempAccount.userName}</td>
						</tr>

					</c:forEach>
				</table>
			</div>
			
		</div>


    </body>
</html>