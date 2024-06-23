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
<title>Delete Station</title>
</head>
<body>
<table>
<% try
		{
			
			Connection con=DbConnection.connect();
			String cid=request.getParameter("cid");
			System.out.println("cid"+cid);
			PreparedStatement pstmt=con.prepareStatement("delete from chargingstation where cid=?");
			pstmt.setString(1,cid);
			int i=pstmt.executeUpdate();
			if(i>0)
			{
				i=1;
				response.sendRedirect("deletestation.jsp");
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}%>
	</table>
</body>
</html>