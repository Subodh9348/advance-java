package com.subodh.multimedia;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ImageUpload {

	public static void main(String[] args) {
		try {
			
			Connection con =DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1522/orcl","mydb11","subodh");
			Scanner sc=new Scanner(System.in);
			System.out.println("Connection Established:");
			PreparedStatement ps=con.prepareStatement("select * from media1 where mid =?");
			System.out.println("Enter id to get associate media");
			String id=sc.nextLine();
			ps.setString(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				Blob b= rs.getBlob(2);
				byte arr[]=b.getBytes(1, (int)(b.length()));
				System.out.println("enter the path where you want to:");
				String path =sc.nextLine();
				File f=new File(path);
				FileOutputStream fos=new FileOutputStream(f);
				fos.write(arr);
				System.out.println("file loaded driver successfully");
				
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
	}

}
