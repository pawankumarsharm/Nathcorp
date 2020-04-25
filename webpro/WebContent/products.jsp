<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%

String catagory=request.getParameter("catagory");
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
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:useBean id="msg" class="java.lang.String" scope="request"/>

<body>
<h4><%=msg %></h4>
<a href='./home.jsp'>home</a>
	<a style="float:right;" href='./logout'>Logout</a>

<h1>ADD PRODUCTS </h1>
	
	<form action='./products' method='post'>
	<table>
	<tr>
	<td>Name:</td>
	<td> <input name='pname' type='text' ></td>
	</tr>
	

<tr>
 
         	<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from catagories";

resultSet = statement.executeQuery(sql);
%>
<td>Category
   <select name="catagory"> 
<%while(resultSet.next()){
%>

<option value="<%=resultSet.getString("catagory") %>"><%=resultSet.getString("catagory") %></option>
<%} %>
</select>
</td>
<%


connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
<tr>
	<td>Seller:</td>
	<td><input type='text' name='seller' ></td>
	</tr>
	<tr>
	<td>Price:</td>
	<td><input type='text' name ='price'></td>
	</tr>
	<tr>
	<td>Discount:</td>
	<td><input type='text' name ='discount'></td>
	</tr>
	<tr>
	<td>Images:</td>
	<td><input type='text' name='images'></td>
	</tr>
	<td><input type='submit' name='ADD' value ='ADD'></td><br>
		</table>
	</form>
	<table border="2">
<tr>
<td>NAME</td>
<td>CATEGORY</td>
<td>SELLER</td>
<td>PRICE</td>
<td>DISCOUNT</td>
<td>IMAGES</td>
</tr>
<%
try
{
	Class.forName("com.mysql.jdbc.Driver");
	String url="jdbc:mysql://localhost:3306/product";
	String username="root";
	String password1="root";
	String query="select * from products";
	Connection conn=DriverManager.getConnection(url,username,password1);
	Statement stmt=conn.createStatement();
	ResultSet rs=stmt.executeQuery(query);
	
	String pname = request.getParameter("pname");
	//String catagory2=request.getParameter("catagory");
	String seller=request.getParameter("seller");
	String price=request.getParameter("price");
	String discount=request.getParameter("discount");
	String images=request.getParameter("images");

while(rs.next())
{

%>
   
    <tr><td><%=rs.getString("pname") %></td>
    <td><%=rs.getString("catagory") %></td>
     <td><%=rs.getString("seller")%></td>
      <td><%=rs.getInt("price")%></td>
         <td><%=rs.getInt("discount")%></td>
           <td><%=rs.getString("images") %></td></tr>
        <%

}
%>
   
    <%
    rs.close();
    stmt.close();
    conn.close();
    }
catch(Exception e)
{
    e.printStackTrace();
    }




%>
 </table>
</body>
</html>