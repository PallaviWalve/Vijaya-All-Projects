package com.bankProject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
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
		
		try{
		int i=0;
		Connection con=DbConnection.connect();
		String Username=request.getParameter("Username");
		String Password=request.getParameter("Password");
		System.out.println("Username"+Username);
		System.out.println("Password"+Password);
		PreparedStatement pstmt=con.prepareStatement("Select * from user where Username=? and Password=?");
		pstmt.setString(1,Username);
		pstmt.setString(2,Password);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			int accno=rs.getInt(1);
			checkbalance.setAccno(accno);
			i=1;
			if(i>0)
			{
				response.sendRedirect("dashboard.html");
			}
			else
			{
				response.sendRedirect("index.html");
			}
		}
	}catch(SQLException e)
	{
		e.printStackTrace();
	}
  }
}

