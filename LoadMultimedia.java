package com.subodh.multimedia;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class LoadMultimedia {
	
	

	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection
	                ("jdbc:oracle:thin:@//localhost:1522/orcl"
	,"mydb11", "subodh");
			PreparedStatement ps = con.prepareStatement("insert into Media1 values(?,?)");
			Scanner sc=new Scanner(System.in);
			System.out.println("enter the id from the media ");
			String id=sc.nextLine();
			System.out.println("enter the path of media");
			String path=sc.nextLine();
			ps.setString(1, id);
			ps.setString(2, path);
			File f=new File(path);
			if(f.exists()) {
				FileInputStream fis=new FileInputStream(f);
				ps.setString(1, id);
				ps.setBinaryStream(2, fis,f.length()); 
				//System.out.println("enter successfully");
				int result=ps.executeUpdate();
				System.out.println(result+"record(s) inserted");
				
			}else {
				System.err.println("invalid path or file name entered..");
				
			}
			//int result=ps.executeUpdate();
			ps.close();
			con.close();
			sc.close();
			
		}
		catch(Exception e) {
			System.out.println(e.toString());
			
		}
	}

}
