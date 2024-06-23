<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>
<%@ page import="com.bankProject.DbConnection" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Table</title>
</head>
<style>
table,th,td
{
boarder:1px solid black;
}
</style>
<body>
<table style="width:100%">
<tr>
<th>Accno</th>
<th>Username</th>
<th>Password</th>
<th>Balance</th>
</tr>
<%
 	try
	{
 		Connection con=DbConnection.connect();
 		PreparedStatement pstmt=con.prepareStatement("select * from user");
 		ResultSet rs=pstmt.executeQuery();
 		while(rs.next())
 		{%>
 		
 		<tr>
 		<td><%=rs.getInt(1)%></td>
 		<td><%=rs.getString(2)%></td>
 		<td><%=rs.getString(3)%></td>
 		<td><%=rs.getInt(4)%></td>
 		</tr>	
 	
 	<%}
 		
 	}
	catch(SQLException e)
		{
			e.printStackTrace();
		}
%>
</body>
</html>