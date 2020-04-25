<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:useBean id="msg" class="java.lang.String" scope="request"></jsp:useBean>
<body bgcolor="red">
<h4><%=msg %></h4>
	<fieldset align="center">
		<legend>Change Password</legend>
		<form action="./changepassword" method="post">
			<table>
				<tr>
					<td>New Password:</td>
					<td><input name="password" type="password"></td>
				</tr>
				<tr>
					<td>confirm Password:</td>
					<td><input name="confirmPassword" type="password"></td>
				</tr>
				<tr>
					<td><input type="reset" value="reset"></td>
					<td><input type="submit" value="change password"></td>
				</tr>
				<tr>
					<td><a href="./home">Home</a></td>
					<td><a href="./logout">Logout</a></td>
				</tr>




			</table>


		</form>
	</fieldset>
</body>
</html>