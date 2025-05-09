package com.subodh.methhodprogram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Employee {

	String id;
	String name;
	int salary;
	public void addEmployee(String id,String name,int salary){
		try {
			Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl","mydb11","subodh");
			PreparedStatement psmt=cn.prepareStatement("insert into EmployeeDB values(?,?,?)");
			psmt.setString(1, id);
			psmt.setString(2, name);
			psmt.setInt(3, salary);
		int rowInsert=psmt.executeUpdate();
		if(rowInsert>0) {
			System.out.println("update successfully");
		}else {
			System.out.println("could not insert record");
		}
	}
		catch(Exception e){
			System.out.println(e.toString());
			
		}
	}
}
