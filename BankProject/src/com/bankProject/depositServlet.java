package com.bankProject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class depositServlet
 */
public class depositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public depositServlet() {
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
		
		Connection con=DbConnection.connect();
		try
		{
			int obalance,nbalance;
			int Accno=Integer.parseInt(request.getParameter("Accno"));
			int Amount=Integer.parseInt(request.getParameter("Amount"));
			System.out.println(Accno);
			System.out.println(Amount);
			PreparedStatement pstmt=con.prepareStatement("Select * from user where Accno=?");
			pstmt.setInt(1,Accno);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				obalance=rs.getInt(4);
				nbalance=obalance+Amount;
				
				PreparedStatement pstmt2=con.prepareStatement("update user set Balance=? where Accno=?");
				pstmt2.setInt(1,nbalance);
				pstmt2.setInt(2,Accno);
				int i=pstmt2.executeUpdate();
				if(i>0)
				{
					response.sendRedirect("dashboard.html");
				}
				else
				{
					response.sendRedirect("deposit.html");
				}
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
