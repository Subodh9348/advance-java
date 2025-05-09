package com.subodh.bankaccount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class BankApplication {

	public static void main(String[] args) {
		try {
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localdisk:1522:orcl","mydb11","subodh");
			Scanner sc=new Scanner(System.in);
			System.out.println("Transactions are autocommit: "+con.getAutoCommit());
	        con.setAutoCommit(false);//auto-commit is disabled
	        System.out.println("Transactions are autocommit: "+con.getAutoCommit());
			PreparedStatement ps1=con.prepareStatement("select * from bankaccount where accno =?");
			PreparedStatement ps2=con.prepareStatement("update bankaccount set balance =balance+?where accno=?");
			System.out.println("...enter the source account number...");
			long accno=Long.parseLong(sc.nextLine());
			ps1.setLong(1, accno);
			ResultSet rs1=ps1.executeQuery();
			if(rs1.next()) {
				double balance=rs1.getDouble(4);
				System.out.println("balance in your account is:"+balance);
				System.out.println("enter the receiver account no:");
				long receiverAccno=Long.parseLong(sc.nextLine());
				ps1.setLong(1, receiverAccno);
				ResultSet rs2=ps1.executeQuery();
				con.commit();
				if(rs2.next()) {
					System.out.println("enter the amount to transfer:");
					double transferamount=Double.parseDouble(sc.nextLine());
					
					if(balance>=transferamount){
						ps2.setDouble(1, -transferamount);
						ps2.setLong(2,accno);
						int i=ps2.executeUpdate();
						ps2.setDouble(1, +transferamount);
						ps2.setLong(2,accno);
						int j=ps2.executeUpdate();
						
						con.commit();
					}else {
						System.out.println("...insuficient balance....");
					}
				}
				
				else {
					System.out.println("...invalid amount...!!please enter valid amount..");
				}
				
			}else {
				System.out.println("...invalid receiver account number!! try again....");
			}
			
		}
		catch(Exception e){
			e.getStackTrace();
		}

	}

}
