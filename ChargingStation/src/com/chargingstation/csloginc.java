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
 * Servlet implementation class csloginc
 */
@WebServlet("/csloginc")
public class csloginc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public csloginc() {
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
			int mobile=Integer.parseInt(request.getParameter("mobile"));
			String password=request.getParameter("password");
		
			int i=0;
			PreparedStatement pstmt=con.prepareStatement("select * from chargingstation where mobile=? and password=? and status=?");
			pstmt.setInt(1,mobile);
			pstmt.setString(2,password);
			pstmt.setString(3,"approve");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				i=1;
			}
			if(i>0)
			{
				response.sendRedirect("csdashboard.html");
			}
			else
			{
				response.sendRedirect("cslogin.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
