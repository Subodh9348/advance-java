package com.subodh.procedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SetData {

	public static void main(String[] args) {
		
		
		try {
			Scanner sc=new Scanner(System.in);
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl","mydb11","subodh");
			CallableStatement cs=null;
			System.out.println("....callstatement started....");
			System.out.println("1:data inserted..\n2:retrive the data...");
			int ch=Integer.parseInt(sc.nextLine());
			switch(ch) {
			case 1:
				cs=con.prepareCall("{call  INSERTDATA (?,?,?,?,?,?)}");
				System.out.println("enter the customer accno");
				int accno=Integer.parseInt(sc.nextLine());
				System.out.println("enter the name of the customer:");
				String name=sc.nextLine();
				System.out.println("enter the acctype of the customer: ");
				String acctype=sc.nextLine();
				System.out.println("enter the state of the customer:");
				String state=sc.nextLine();
				System.out.println("enter the city of the customer:");
				String city=sc.nextLine();
				System.out.println("enter the pincode:");
				int pincode=Integer.parseInt(sc.nextLine());
				cs.setInt(1, accno);
				cs.setString(2, name);
				cs.setString(3, acctype);
				cs.setString(4, state);
				cs.setString(5, city);
				cs.setInt(6, pincode);
				int result=cs.executeUpdate();
				if(result>0) {
					System.out.println("...entered successfully...");
				}else {
						System.out.println("check your data...");
					}
				//sc.close();
				con.close();
				cs.close();
				break;
			case 2:
				//cs=con.prepareCall("{call  FETCH_DATA (?,?,?,?,?,?)}");
				System.out.println("Enter account no of the customer:");
				int accno1=Integer.parseInt(sc.nextLine());
				//cs.setInt(1, accno1);
				cs = con.prepareCall("{call FETCHDATADB(?, ?, ?, ?, ?, ?)}");
				cs.setInt(1, accno1); // IN parameter
				cs.registerOutParameter(2, java.sql.Types.VARCHAR); // name
				cs.registerOutParameter(3, java.sql.Types.VARCHAR); // acctype
				cs.registerOutParameter(4, java.sql.Types.VARCHAR); // state
				cs.registerOutParameter(5, java.sql.Types.VARCHAR); // city
				cs.registerOutParameter(6, java.sql.Types.INTEGER); // pincode

				cs.execute();//............execute method............

				System.out.println("Name: " + cs.getString(2));
				System.out.println("Acc Type: " + cs.getString(3));
				System.out.println("State: " + cs.getString(4));
				System.out.println("City: " + cs.getString(5));
				System.out.println("Pincode: " + cs.getInt(6));

				
				cs.close();
				con.close();
				break;
				
			}
			
				
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		

	}

}
