package com.subodh.callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		try {
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl","mydb11","subodh");
			CallableStatement cs=con.prepareCall("{call  management3 (?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			System.out.println("....callable statement prepared....");
			Scanner sc=new Scanner(System.in);
			System.out.println("enter the name of the employee");
			String ename=sc.nextLine();
			System.out.println("enter the employee id:");
			String eid=sc.nextLine();
			System.out.println("enter the yoe:");
			int yoe=Integer.parseInt(sc.nextLine());
			System.out.println("enter the subject taught by:"+ename);
			String subject=sc.nextLine();
			//course part........................(p_cname,p_duration,p_fee,p_faculty)
			System.out.println("enter the course");
			String course=sc.nextLine();
			System.out.println("enter the duration:");
			int duration =Integer.parseInt(sc.nextLine());
			System.out.println("enter the course fee:");
			int fee=Integer.parseInt(sc.nextLine());
			System.out.println("enter the faculty assigned:"+course);
			String faculty=sc.nextLine();
			//student part............(p_sname,p_age,p_sid,p_cname,p_sfee,p_batch).........
			System.out.println("enter the student name:");
			String sname=sc.nextLine();
			System.out.println("enter the age of the student:");
			int age=Integer.parseInt(sc.nextLine());
			System.out.println("enter id of the student");
			String sid=sc.nextLine();
			System.out.println("enter the course name optioned by "+sname);
			String scourse=sc.nextLine();
			System.out.println("enter the fee for:"+scourse);
			int sfee=Integer.parseInt(sc.nextLine());
			System.out.println("enter the batch code by:"+sname);
			String batch=sc.nextLine();
			
			cs.setString(1, ename);
			cs.setString(2,eid);
			cs.setInt(3, yoe);
			cs.setString(4, subject);
			//..............................
			cs.setString(5, course);
			cs.setInt(6,duration);
			cs.setInt(7, fee);
			cs.setString(8, faculty);
			//...................................
			cs.setString(9, sname);
			cs.setInt(10, age);
			cs.setString(11, sid);
			cs.setString(12, scourse);
			cs.setInt(13, sfee);
			cs.setString(14, batch);
			//......................................
			int result=cs.executeUpdate();
			if(result>0) {
				System.out.println("...entered successfully...");
			}else {
					System.out.println("check your data...");
				}
			
			
			
			cs.close();
			sc.close();
			con.close();






			
			
			
			
			
		}
		catch(Exception e){
			
		}

	}

}
