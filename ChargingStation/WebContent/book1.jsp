<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*"%>
<%@ page import="com.chargingstation.DbConnection" %>
<%@ page import="com.chargingstation.getset" %>
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
<title>Visitors an Admin Panel Category Bootstrap Responsive Website Template | Home :: w3layouts</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Visitors Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstrap-css -->
<link rel="stylesheet" href="css/bootstrap.min.css" >
<!-- //bootstrap-css -->
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/style-responsive.css" rel="stylesheet"/>
<!-- font CSS -->
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<!-- font-awesome icons -->
<link rel="stylesheet" href="css/font.css" type="text/css"/>
<link href="css/font-awesome.css" rel="stylesheet"> 
<link rel="stylesheet" href="css/morris.css" type="text/css"/>
<!-- calendar -->
<link rel="stylesheet" href="css/monthly.css">
<!-- //calendar -->
<!-- //font-awesome icons -->
<script src="js/jquery2.0.3.min.js"></script>
<script src="js/raphael-min.js"></script>
<script src="js/morris.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking</title>
</head>
<body>
<div class="top-nav clearfix">
    <!--search & user info start-->
     <form action="search.jsp">
    <ul class="nav pull-right top-menu">
        <li>
            <input type="text" name="city" class="form-control search" placeholder="Enter city">
         </li>
         <li> <input type="submit" value="Filter" name="Filter">
          <li><a href="index.html">Logout</a></li>
         </li>
    </ul>
     </form>
    <!--search & user info end-->
</div>

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
		<th>password</th>
		<th>status</th>
		<th>booking</th>
	</tr>
	
	<% try
		{
			Connection con=DbConnection.connect();
			PreparedStatement pstmt=con.prepareStatement("select * from chargingstation");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{   
				int cid=rs.getInt(1);
				getset.setCid(cid);
			%>
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
					<td><%=rs.getString(13)%></td>
					<td><%=rs.getString(14)%></td>
					<td><button><a href="book.jsp?cid=<%=rs.getInt(1)%>">Book</a></button></td>
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