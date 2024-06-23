package com.bankProject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registrationservlet
 */
public class regServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regServlet() {
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
		int Accno=Integer.parseInt(request.getParameter("Accno"));
		String Username=request.getParameter("Username");
		String Password=request.getParameter("Password");
		int Balance=Integer.parseInt(request.getParameter("Balance"));
		System.out.println(Accno);
		System.out.println(Username);
		System.out.println(Password);
		System.out.println(Balance);
		PreparedStatement pstmt=con.prepareStatement("insert into user values(?,?,?,?)");
		pstmt.setInt(1,Accno);
		pstmt.setString(2,Username);
		pstmt.setString(3,Password);
		pstmt.setInt(4,Balance);
		int i=pstmt.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("index.html");
			}
			else
			{
				response.sendRedirect("registration.html");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
