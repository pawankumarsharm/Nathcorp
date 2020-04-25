<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="info" class="com.nathcorp.webpro.dto.User" scope="session"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="bootstrap.css" type="text/css" rel="stylesheet">

</head>
<body bgcolor="skyblue">

<form action='./home'>
<a style="float:right;" href='./logout'>Logout</a>

<h1>WELCOME To MYSTORE</h1>



<a href='./search.html'>Search</a>
<a href='./changepassword.jsp'>Change Password</a>
<fieldset align="center">
<legend>CATAGORIES</legend>
<table>
<tr>
<td> <a href='./categories.html'>category</a></td>
</tr>

</table>
</fieldset>
<fieldset align="center">
<legend>PRODUCTS</legend>
<table>
<tr>
<td> <a href='./products.jsp'>products</a></td>
</tr>

</table>
</fieldset>
</form>
</body>
</html>