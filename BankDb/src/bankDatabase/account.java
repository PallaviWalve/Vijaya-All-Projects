package bankDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class account 
{
	String name,address,email;
	int accno,balance,mobile;
	void createAccount()
	{
		try{
			
			Connection con=DbConnection.connect();
			Scanner s=new Scanner(System.in);
			System.out.println("Enter account no=");
			accno=s.nextInt();
			System.out.println("Enter name=");
			name=s.next();
			System.out.println("Enter mobile=");
			mobile=s.nextInt();
			System.out.println("Enter address=");
			address=s.next();
			System.out.println("Enter initial amount to open account=");
			balance=s.nextInt();
			
			PreparedStatement pstmt=con.prepareStatement("insert into employee values(?,?,?,?,?)");
			pstmt.setInt(1,accno);
			pstmt.setString(2,name);
			pstmt.setInt(3,mobile);
			pstmt.setString(4,address);
			pstmt.setInt(5,balance);
			
			int i=pstmt.executeUpdate();
			if(i>0)
			{
				System.out.println("Account Created Successfully!!!");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
