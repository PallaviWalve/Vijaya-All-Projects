<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*"%>
<%@ page import="com.chargingstation.DbConnection" %>
<html>
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/style-responsive.css" rel="stylesheet"/>
<style>
table,td,th
{
border:1px solid black;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View User</title>
</head>
<body>
	<h1><center>Users</center></h1>
	<table style="width:100%">
	<tr>
		<th>uid</th>
		<th>name</th>
		<th>email</th>
		<th>mobile</th>
		<th>city</th>
	</tr>
	
	<% try
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
					<td><%=rs.getString(6)%></td>
				</tr>
			<%}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}%>
	</table>
</body>
</html>