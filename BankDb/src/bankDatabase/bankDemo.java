package bankDatabase;

import java.util.Scanner;

public class bankDemo {

	public static void main(String[] args)
	{
		account a=new account();
		deposit d=new deposit();
		withdraw w=new withdraw();
		transfer t=new transfer();
		Scanner s=new Scanner(System.in);
		int no;
		do{
			System.out.println("Enter your choice:");
			System.out.println("1.Create Account\n2.Deposit\n3.Withdraw\n4.Tranfer\n5.Exit");
			no=s.nextInt();
			switch(no)
			{
				case 1:
					a.createAccount();
					break;
				case 2:
					d.Deposit();
					break;
				case 3:
					w.withdraw();
					break;
				case 4:
					t.transfer();
					break;
				case 5:
					break;
				default:
					System.out.println("Enter correct choice..");

			}
			System.out.println("Do you want to continue\n1.Yes\n2.No");
			no=s.nextInt();
		}while(no==1);

	}

}
