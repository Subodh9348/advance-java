package com.subodh.methhodprogram;



import java.sql.*;
import java.util.*;

public class TestEmployeeDB 
{
	public static void main(String [] args)
	{
		try
		{
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl", "mydb11" ,"subodh");
			PreparedStatement pstmt = con.prepareStatement("insert into EmployeeDB values(?,?,?)");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter a choice : ");
			int choise = sc.nextInt();
			
			switch(choise)
			{
			case 1:
				System.out.println("How many time itterate : ");
				int iterate = sc.nextInt();
				for(int i =0;i<=iterate;i++)
				{
					System.out.println("Enter e id : ");
					String eid = sc.nextLine();
					eid = sc.nextLine();
					System.out.println("Enter name :"   );
					String name = sc.nextLine();
					System.out.println("Enter salary : ");
					int sal = sc.nextInt();
					
					pstmt.setString(1,eid);
					pstmt.setString(2,name );
					pstmt.setInt(3,sal );
				}
					
					int result = pstmt.executeUpdate();
					
					if(result>0)
					{
						System.out.println("Sucessfully inserted ");
					}
					else
					{
						System.out.println("Please contact Admin!!!");
					}
					
					break;
			case 2:
				ResultSet rSet = pstmt.executeQuery("select * from EmployeeDB");
				while(rSet.next())
				{
					System.out.println("EID "+rSet.getString(1)+"\t name "+rSet.getString(2)+"\t salary "+rSet.getInt(3));
				}
				break;
				
			case 3:
				rSet= pstmt.executeQuery("select * from EmployeeDB where salary>34000");
				while(rSet.next())
				{
					System.out.println("EID "+rSet.getString(1)+"\t name "+rSet.getString(2)+"\t salary "+rSet.getInt(3));
				}
				break;
				
			default:
				System.out.println("Invalid 2");
			}
			
	}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

}