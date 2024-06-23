<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>
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
<title>Approved</title>
</head>
<body>
<h1><center>Charging Station</center></h1><br>
	<table style="width:100%">
	<tr>
		<th>cid</th>
		<th>stationname</th>
		<th>address</th>
		<th>city</th>
		<th>taluka</th>
		<th>district</th>
		<th>opentime</th>
		<th>closetime</th>
		<th>mobile</th>
		<th>latitude</th>
		<th>longitude</th>
		<th>power</th>
		<th>status</th>
		<th>approve</th>
	</tr>
	
	<% try
		{
			Connection con=DbConnection.connect();
			PreparedStatement pstmt=con.prepareStatement("select * from chargingstation where status=?");
			pstmt.setString(1,("not approve"));
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{%>
				<tr>
					<td><%=rs.getInt(1)%></td>
					<td><%=rs.getString(2)%></td>
					<td><%=rs.getString(3)%></td>
					<td><%=rs.getString(4)%></td>
					<td><%=rs.getString(5)%></td>
					<td><%=rs.getString(6)%></td>
					<td><%=rs.getString(7)%></td>
					<td><%=rs.getString(8)%></td>
					<td><%=rs.getInt(9)%></td>
					<td><%=rs.getString(10)%></td>
					<td><%=rs.getString(11)%></td>
					<td><%=rs.getInt(12)%></td>
					<td><%=rs.getString(14)%></td>
					<td><a href="approvecs.jsp?cid=<%=rs.getInt(1)%>">approve</a></td>
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
</body>
</html>