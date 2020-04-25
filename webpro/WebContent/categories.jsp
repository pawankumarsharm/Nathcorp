<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String cid = request.getParameter("cid");
String catagory=request.getParameter("catagory");
String image=request.getParameter("image");
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "product";
String userid = "root";
String password = "root";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<body>
<td><a href="./home">Home</a></td>
<a style="float:right;" href='./logout'>Logout</a>
<h1>Retrieve data from database in jsp</h1>
<table border="1">
<tr>
<td>CId</td>
<td>Category</td>
<td>Image</td>
</tr>
<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from catagories";

resultSet = statement.executeQuery(sql);
int id=0;
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getString("cid") %></td>
<td><%=resultSet.getString("catagory") %></td>
<td><%=resultSet.getString("image") %></td>
</tr>
<%

}

if(resultSet.last()){
id=resultSet.getInt("cid");
}
out.println("Last inserted Id: "+id);

connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
</body>
</html>