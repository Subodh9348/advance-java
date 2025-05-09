package com.subodh.callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class EmpData {

	public static void main(String[] args) {
		try {
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl","mydb11","subodh");
			CallableStatement cs=con.prepareCall("{call tabledata (?,?,?)}");
			System.out.println("....callstatement started....");
			Scanner sc=new Scanner(System.in);
			System.out.println("enter the name of the employee");
			String ename=sc.nextLine();
			System.out.println("enter the emp id:");
			int id=Integer.parseInt(sc.nextLine());
			System.out.println("enter age of the emp");
			int age=Integer.parseInt(sc.nextLine());
			cs.setString(1, ename);
			cs.setInt(2, id);
			cs.setInt(3, age);
			
			int result=cs.executeUpdate();
			if(result>0) {
				System.out.println("...enter successfully:...");
			}
			con.close();
			cs.close();
			sc.close();
			
		}
		catch(Exception e){
			
		}

	}

}
