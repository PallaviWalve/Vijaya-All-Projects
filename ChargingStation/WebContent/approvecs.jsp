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
<table>
<% try
		{
			int i=0;
			Connection con=DbConnection.connect();
			int cid=Integer.parseInt(request.getParameter("cid"));
			System.out.println("cid"+cid);
			PreparedStatement pstmt=con.prepareStatement("update chargingstation set status=? where cid=?");
			pstmt.setString(1,("approve"));
			pstmt.setInt(2,cid);
			i=pstmt.executeUpdate();
			if(i>0)
			{
				i=1;
			response.sendRedirect("approve.jsp");
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}%>
	</table>
</body>
</html>