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
 * Servlet implementation class updateservlet
 */
@WebServlet("/updateservlet")
public class updateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateservlet() {
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
			int power1;
			Connection con=DbConnection.connect();
			int power=Integer.parseInt(request.getParameter("power"));
			String cid=request.getParameter("cid");
			System.out.println("power"+power);
			System.out.println("cid"+cid);
			PreparedStatement pstmt=con.prepareStatement("Select * from chargingstation where cid=?");
			pstmt.setString(1,cid);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
			power1=rs.getInt(12);
			int newpower=power1+power;
			PreparedStatement pstmt2=con.prepareStatement("update chargingstation set power=? where cid=?");
			pstmt2.setInt(1,newpower);
			pstmt2.setString(2,cid);
			int i=pstmt2.executeUpdate();
			if(i>0)
			{
				i=1;
			    response.sendRedirect("updatepower.jsp");
				
			}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
