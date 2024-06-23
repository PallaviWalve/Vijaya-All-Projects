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
 * Servlet implementation class booking
 */
@WebServlet("/booking")
public class booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public booking() {
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
			Connection con=DbConnection.connect();
			int cid=getset.getCid();
			int uid=getset.getUid();
			int power=Integer.parseInt(request.getParameter("power"));
			String timeslot=request.getParameter("timeslot");
			PreparedStatement pstmt=con.prepareStatement("insert into booking values(?,?,?,?,?)");
			pstmt.setInt(1,0);
			pstmt.setInt(2,uid);
			pstmt.setInt(3,power);
			pstmt.setInt(4,cid);
			pstmt.setString(5,timeslot);
			int i=pstmt.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("book1.jsp");
			}
		}
		catch(Exception e)
		{
			
		}
		
		
	}

}
