<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<title>Edit member</title>
</head>
<body>


	<div id="container">

		<form action="MemberController" method="GET">

			<input name="command" type="hidden" value="UPDATE" />
			<input name="memberId" type="hidden" value="${THE_MEMBER.id}" />
			

			<table>
				<tbody>
					<tr>
						<td><label>Full Name: </label></td>
						<td><input type="text" class="form.control" name="full-name" value="${THE_MEMBER.fullName}" /></td>
					</tr>

					<tr>
						<td><label>Email: </label></td>
						<td><input type="text" class="form.control" name="email" value="${THE_MEMBER.email}" /></td>
					</tr>

					<tr>
						<td><label>Title: </label></td>
						<td><input type="text" class="form.control" name="title" value="${THE_MEMBER.title}" /></td>
					</tr>

					<tr>
						<td><label>Nationality: </label></td>
						<td><input type="text" class="form.control" name="nationality" value="${THE_MEMBER.nationality}"/></td>
					</tr>

				</tbody>
			</table>

			<input class="btn btn-info" type="submit" value="Save changes" />
		</form>
	</div>



	<div>
		<a href="MemberController">Back to members list.</a>
	</div>



</body>
</html>