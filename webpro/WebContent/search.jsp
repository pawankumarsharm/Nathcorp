<%@page import="com.nathcorp.webpro.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
User info=(User)request.getAttribute("info");

%>

<body>
<a href='./home'>Home</a>
<a style='float:right' href='./logout'>Logout</a>
<%if(info!=null){ %>
<fieldset>
<legend>Employee Info</legend>
<table align='center'>
<tr>

<th>Name</th>
<th>Email</th>
<th>Address</th>
<th>Phone</th>
</tr>
<tr>

<td><%=info.getName() %></td>
<td><%=info.getEmail() %></td>
<td><%=info.getAddress() %></td>
<td><%=info.getPhone() %></td>
</tr>
</table>
</fieldset>
<%}else{ %>
<h1>No Data Found</h1>
<%} %>
</body>
</html>
