package com.chargingstation;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class userregistration
 */
@WebServlet("/userregistration")
public class userregistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userregistration() {
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
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			int mobile=Integer.parseInt(request.getParameter("mobile"));
			String password=request.getParameter("password");
			String city=request.getParameter("city");
		
			int i=0;
			PreparedStatement pstmt=con.prepareStatement("insert into user values(?,?,?,?,?,?)");
			pstmt.setInt(1,0);
			pstmt.setString(2,name);
			pstmt.setString(3,email);
			pstmt.setInt(4,mobile);
			pstmt.setString(5,password);
			pstmt.setString(6,city);
			i=pstmt.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("userdashboard.html");
			}
			else
			{
				response.sendRedirect("userlogin.html");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
