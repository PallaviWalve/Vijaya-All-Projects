package com.chargingstation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class csregistration
 */
@WebServlet("/csregistration")
public class csregistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public csregistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		try
		{
			Connection con=DbConnection.connect();
			String stationname=request.getParameter("stationname");
			String address=request.getParameter("address");
			String city=request.getParameter("city");
			String taluka=request.getParameter("taluka");
			String district=request.getParameter("district");
			String opentime=request.getParameter("opentime");
			String closetime=request.getParameter("closetime");
			int mobile=Integer.parseInt(request.getParameter("mobile"));
			String latitude=request.getParameter("latitude");
			String longitude=request.getParameter("longitude");
			int power=Integer.parseInt(request.getParameter("power"));
			String password=request.getParameter("password");
			String status=request.getParameter("status");
		
			int i=0;
			PreparedStatement pstmt=con.prepareStatement("insert into chargingstation values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1,0);
			pstmt.setString(2,stationname);
			pstmt.setString(3,address);
			pstmt.setString(4,city);
			pstmt.setString(5,taluka);
			pstmt.setString(6,district);
			pstmt.setString(7,opentime);
			pstmt.setString(8,closetime);
			pstmt.setInt(9,mobile);
			pstmt.setString(10,latitude);
			pstmt.setString(11,longitude);
			pstmt.setInt(12,power);
			pstmt.setString(13,password);
			pstmt.setString(14,status);
			i=pstmt.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("csdashboard.html");
			}
			else
			{
				response.sendRedirect("cslogin.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
