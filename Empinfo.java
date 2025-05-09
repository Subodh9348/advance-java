package com.subodh.multimedia;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Empinfo {
	public static void main(String[]args) {
		try {
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl","mydb11","subodh");
		Scanner sc=new Scanner(System.in);
		PreparedStatement ps=con.prepareStatement("insert into emp_info values(?,?,?,?,?,?)");
		System.out.println("enter the empid");
		String id=sc.nextLine();
		System.out.println("enter the emp name");
		String name=sc.nextLine();
		System.out.println("enter the address:");
		String Address=sc.nextLine();
		System.out.print("enter the mail id:\n");
		String mail=sc.nextLine();
		//sc.next();
		System.out.print("enter the phone no:\n");
		long phno=sc.nextLong();
		sc.nextLine();
		System.out.println("enter the resume(pdf format)");
		String resume=sc.nextLine();
		File rsfile=new File(resume);
		FileInputStream fis=new FileInputStream(rsfile);
		
		ps.setString(1, id);
		ps.setString(2, name);
		ps.setString(3, Address);
		ps.setString(4, mail);
		ps.setLong(5, phno);
		ps.setBinaryStream(6, fis,rsfile.length()); 
		int result=ps.executeUpdate();
		if(result>0) {
			System.out.println("enter successfully:");
		}else {
			System.out.println("enter the correct data");
		}
		ps.close();
		con.close();
		sc.close();
		
		
		
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
