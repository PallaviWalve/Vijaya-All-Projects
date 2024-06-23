package bankDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class transfer 
{
	int accno,balance,dbalance,nbalance,newbalance;
	void transfer()
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
			dbalance=s.nextInt();
			
			if(balance>dbalance)
			{
			nbalance=balance-dbalance;
			
			PreparedStatement pstmt2=con.prepareStatement("update employee set balance=? where accno=?");
			pstmt2.setInt(1,dbalance);
			pstmt2.setInt(2,accno);
			int i=pstmt2.executeUpdate();
			System.out.println("Balance after withdraw="+nbalance);
			
			
			System.out.println("Enter account number where amount to deposit=");
			accno=s.nextInt();
			PreparedStatement pstmt1=con.prepareStatement("select * from employee where accno=?");
			pstmt1.setInt(1,accno);
			ResultSet rs1=pstmt.executeQuery();
			while(rs1.next())
			{
				balance=rs.getInt(5);
				System.out.println("Current Balance="+balance);
			}
			
			newbalance=balance+dbalance;
			
			PreparedStatement pstmt3=con.prepareStatement("update employee set balance=? where accno=?");
			pstmt3.setInt(1,dbalance);
			pstmt3.setInt(2,accno);
			int rs2=pstmt2.executeUpdate();
			System.out.println("Balance after deposit="+newbalance);
			}
			else
			{
				System.out.println("You have insufficient balance to deposit!!!");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
