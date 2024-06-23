package RegistrationDemo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	
	Connection con=DbConnection.connect();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String Rollno=request.getParameter("Rollno");
		int Rollno1=Integer.parseInt(Rollno);
		String Name=request.getParameter("Name");
		String Mobile=request.getParameter("Mobile");
		int Mobile1=Integer.parseInt(Mobile);
		String Username=request.getParameter("Username");
		String Password=request.getParameter("Password");
		
		try{
			PreparedStatement pstmt=con.prepareStatement("insert into student values(?,?,?,?,?)");
			pstmt.setInt(1,Rollno1);
			pstmt.setString(2,Name);
			pstmt.setInt(3,Mobile1);
			pstmt.setString(4,Username);
			pstmt.setString(5,Password);
			int i=pstmt.executeUpdate();
			if(i>0)
			{
				response.sendRedirect("login.html");
			}
			else
			{
				response.sendRedirect("index.html");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
