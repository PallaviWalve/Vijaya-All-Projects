package bankDatabase;

import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class deposit 
{

	int dmoney,balance=0,dbalance,accno;
	void Deposit()
	{
		try
		{
			Connection con=DbConnection.connect();
			Scanner s=new Scanner(System.in);
			
			System.out.println("Enter account number=");
			accno=s.nextInt();
			PreparedStatement pstmt=con.prepareStatement("select * from employee where accno=?");
			pstmt.setInt(1,accno);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				balance=rs.getInt(5);
				System.out.println("Current Balance="+balance);
			}
			
			System.out.println("Enter amount to deposit=");
			dmoney=s.nextInt();
			
			dbalance=balance+dmoney;
			
			PreparedStatement pstmt2=con.prepareStatement("update employee set balance=? where accno=?");
			pstmt2.setInt(1,dbalance);
			pstmt2.setInt(2,accno);
			int i=pstmt2.executeUpdate();
			System.out.println("Balance after deposit="+dbalance);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
