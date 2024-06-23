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
<title>Update Power</title>
</head>
<body>
<section id="container">
<!--header start-->
<header class="header fixed-top clearfix">
<!--logo start-->
<div class="brand">
    <a href="index.html" class="logo">
        EV STATION
    </a>
    <div class="sidebar-toggle-box">
        <div class="fa fa-bars"></div>
    </div>
</div>
<!--logo end-->

<!--sidebar start-->
<aside>
    <div id="sidebar" class="nav-collapse">
        <!-- sidebar menu start-->
        <div class="leftside-navigation">
            <ul class="sidebar-menu" id="nav-accordion">
                <li>
                    <a class="active" href="index.html">
                        <i class="fa fa-dashboard"></i>
                        <span>CHARGING STATION LOGIN</span>
                    </a>
                </li>
                <li>
                    <a href="updatepower.jsp">
                        <i class="fa fa-dashboard"></i>
                        <span>Update Power</span>
                    </a>
                </li>
                <li>
                    <a href="viewcs.jsp">
                        <i class="fa fa-th"></i>
                        <span>View Charging Station</span>
                    </a>
                </li>
             
            </ul>            </div>
        <!-- sidebar menu end-->
    </div>
</aside>
<!--sidebar end-->
<div class="log-w3">
<div class="w3layouts-main">
	<form action="updateservlet" method="post">
	<h2>Charging Station</h2>
			<input type="cid" class="ggg" name="cid" placeholder="Enter id" required="">
			<input type="power" class="ggg" name="power" placeholder="Enter power to update" required="">
			<input type="submit" value="Update" name="submit">
		</form>
	</div>
</div>
</body>
</html>