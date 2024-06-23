package bankDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class withdraw 
{
	int accno,balance,wmoney,wbalance;
	void withdraw()
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
			
			System.out.println("Enter amount to withdraw=");
			wmoney=s.nextInt();
			
			wbalance=balance-wmoney;
			
			PreparedStatement pstmt2=con.prepareStatement("update employee set balance=? where accno=?");
			pstmt2.setInt(1,wbalance);
			pstmt2.setInt(2,accno);
			int i=pstmt2.executeUpdate();
			System.out.println("Balance after deposit="+wbalance);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
