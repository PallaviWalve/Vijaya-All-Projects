<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>
<%@ page import="com.bankProject.DbConnection" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>check balance</title>
</head>
<body>
<%
	try{
		Connection con=DbConnection.connect();
		int accno=Integer.parseInt(request.getParameter("accno"));
		PreparedStatement pstmt=con.prepareStatement("select balance from user where accno=?");
		pstmt.setInt(1,accno);
		ResultSet rs=pstmt.executeQuery();
		
		int balance=rs.getInt(4);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
%>
</body>
</html>