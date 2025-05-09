package com.subodh.callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Function {
	public static void main(String[]args) {
		try {
			Scanner sc=new Scanner(System.in);
			Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl","mydb11","subodh");
			CallableStatement cs=null;
			System.out.println(".....callable statement started.....");
			System.out.println("1:Data inserted..\n2:Data Retrieved..");
			int number=Integer.parseInt(sc.nextLine());
			switch(number) {
			case 1:
				cs=cn.prepareCall("{call insertcardata (?,?,?)}");
				System.out.println("enter the brand name of the car:");
				String brand=sc.nextLine();
				System.out.println("enter the carnumber :");
				String carno=sc.nextLine();
				System.out.println("enter the price of the car...");
				int price=Integer.parseInt(sc.nextLine());
				cs.setString(1, brand);
				cs.setString(2, carno);
				cs.setInt(3, price);
				int result=cs.executeUpdate();
				if(result>0) {
					System.out.println("...enter successfully...");
				}else {
						System.out.println("...check your data...");
					}
				cn.close();
				cs.close();
				break;
			case 2:
				System.out.println("enter the carnumber....");
				String carno1=sc.nextLine();
				cs=cn.prepareCall("{?= call cardetails (?)}");
				cs.setString(2,carno1);
				cs.registerOutParameter(1, java.sql.Types.VARCHAR);
				//cs.registerOutParameter(3, java.sql.Types.INTEGER);
				//System.out.println("...............................");
				cs.execute();
				System.out.println("brand name:\t"+cs.getString(1));
				//System.out.println("price of the car"+cs.getInt(3));
				cs.close();
				break;
			}
			
			
		}
		catch(Exception e){
			e.getStackTrace();
		}
	}
	
}
