package student_info;

//import java.sql.*;
////import java.sql.DriverManager;
////import java.sql.PreparedStatement;
////import java.sql.ResultSet;
////import java.sql.Statement;
//import java.util.Scanner;
//
//public class Student {
//	public static void main(String[]args) {
//	
//		try {
//	    	System.out.println("----------------");
//	        Connection con = DriverManager.getConnection
//	                ("jdbc:oracle:thin:@//localhost:1522/orcl"
//	,"mydb11", "subodh");
//	         Statement stmt = con.createStatement();
//	         Scanner sc=new Scanner(System.in);
//	         ResultSet rSet = stmt.executeQuery("SELECT * FROM STUDENTINFO");
//	         System.out.println("Details of STUDENT: ");
//	         while(rSet.next()) {
//	         System.out.println("ROLLNO: "+rSet.getInt(1)
//	         +"\tNAME: "+rSet.getString(2)+"\tPERCENTAGE"+rSet.getDouble(3)
//	         +"\tFNAME: "+rSet.getString(4)+"\tLNAME: "+rSet.getString(5)+"\tMAILID: "+rSet.getString(6)+"\tphno:"+rSet.getLong(7));    
//	         }
//	         System.out.println("enter the number 1:login 2:register");
//	         System.out.println("select yor option");
//	         int option=Integer.parseInt(sc.nextLine());
//	         
//	         
//	        // int choice=sc.nextInt();
//	         switch(option) {
//	         case 1:
//	        	 System.out.println("u are going for registration.");
//	        	 System.out.println("enter your rollno");
//	        	 int rollno=Integer.parseInt(sc.nextLine());
//	        	 System.out.println("enter your name");
//	        	 String name=sc.nextLine();
//	        	 System.out.println("enter your percentage");
//	        	 double percentage=sc.nextDouble();
//	        	 System.out.println("enter your ");
//	        	 PreparedStatement ps=con.prepareStatement("insert into studentinfo values(?,?,?,?,?,?,?)");
//	        	 	ps.setInt(1, rollno);
//	        	 
//	        	 break;
//	         case 2:
//	        	 System.out.println(" you are going for login");
//	        	 System.out.println("enter your roll no");
//	        	 rollno=Integer.parseInt(sc.nextLine());
//	        	 System.out.println("enter your name");
//	        	 name=sc.nextLine();
//	        	 
//	        	 break;
//	         }
//	         rSet.close();
//	         stmt.close();
//	         con.close();  
//	         
//	         //System.out.println("Hello");
//	    }
//	    catch(Exception e) {
//	       System.out.println(e.getMessage());
//	    }
//
//}
//}
//..................................................................................................................................

import java.sql.*;
import java.util.Scanner;
public class Student
{

	public static void main(String[] args) 
	{
		try 
		{
			Scanner sc=new Scanner(System.in);
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl","mydb11","subodh");
			PreparedStatement pst=null;
			
			System.out.println("1.Register \n2.logIn");
			int ch=Integer.parseInt(sc.nextLine());
			switch (ch) 
			{
			case 1: 
			    pst=con.prepareStatement("inset into student_info values(?,?,?,?,?,?,?)");
				System.out.println("Enter rollno");
				int rollno=Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter Name");
				String name=sc.nextLine();
				
				System.out.println("Enter Percentage");
				int percentage=Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter First Name");
				String fname=sc.nextLine();
				
				System.out.println("Enter Last Name");
				String lname=sc.nextLine();
				
				System.out.println("Enter Mail Id");
				String mail=sc.nextLine();
				
				System.out.println("Enter Phone Number");
				long ph=sc.nextLong();
				
				int upd=pst.executeUpdate("insert into STUDENT_INFO values('"+rollno+"','"+name+"','"+percentage+"','"+fname+"','"+lname+"','"+mail+"','"+ph+"')");
				if(upd>0)
				{
					System.out.println("Register Complete.");
				}
				break;
			case 2:
				
				pst=con.prepareStatement("select * from STUDENT_INFO where rollno=? and name=?");
				System.out.println("Enter rollno");
				int rollno1=Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter Name");
				String name2=sc.nextLine();
				pst.setInt(1, rollno1);
				pst.setString(2, name2);
				int x=pst.executeUpdate();
				if(x>0)
				{
					System.out.println("Log In successful");
					System.out.println(" 1.fetch whose Percentage>? \n 2.Whose Percentage Between ? and ? \n 3.How Many Student get Morethen Percentage > ?\n 4.Update MailId Phone Number ");
					int choice=Integer.parseInt(sc.nextLine());
					switch(choice)
					{
					case 1:
					    pst=con.prepareStatement("select * from STUDENT_INFO where percentage > ?");
						System.out.println("Enter 1st Percentage");
						int cond=Integer.parseInt(sc.nextLine());
						
						pst.setInt(1, cond);
		
						ResultSet  rs1=pst.executeQuery();
						if(rs1.next())
						{
	                        System.out.println(rs1.getInt(1)+"\t"+rs1.getString(2)+"\t"+rs1.getInt(3)+"\t"+rs1.getString(4)+"\t"+rs1.getString(5)+"\t"+rs1.getString(6)+"\t"+rs1.getString(7));
						}
						else
						{
							System.out.println("no row selected");
						}
						break;
					case 2:
						PreparedStatement pst23=con.prepareStatement("select * from STUDENT_INFO where percentage between ? and ?");
						System.out.println("Enter 1st Percentage");
						int fp=Integer.parseInt(sc.nextLine());
						
						System.out.println("Enter 2st Percentage");
						int sp1=Integer.parseInt(sc.nextLine());
						
						pst23.setInt(1, fp);
						pst23.setInt(2, sp1);
						
						int res=pst23.executeUpdate();
						if(res>0)
						{
							ResultSet  rs=pst23.executeQuery();
							while(rs.next())
							{
								System.out.println(rs.getInt(1)+"\t"+
							                       rs.getString(2)+"\t"+
										           rs.getInt(3)+"\t"+
							                       rs.getString(4)+"\t"+
										           rs.getString(5)+"\t"+
							                       rs.getString(6)+"\t"+
										           rs.getString(7));
							}
						}
						else {
							System.out.println("no row selected");
						}
						break;
					case 3:
						PreparedStatement pst3 = con.prepareStatement("SELECT COUNT(*) FROM STUDENT_INFO WHERE PERCENTAGE > ?");
						System.out.println("Enter 1st Percentage");
						int p = Integer.parseInt(sc.nextLine());

						pst3.setInt(1, p);

						ResultSet rs3 = pst3.executeQuery();

						if (rs3.next()) {
						    int count = rs3.getInt(1);
						    System.out.println("Total students who scored more than " + p + "% = " + count);
						} else {
						    System.out.println("No result found.");
						}

						
						break;
					case 4:
						PreparedStatement pst4 = con.prepareStatement("UPDATE STUDENT_INFO SET MAILID =?, PHONENO =? WHERE ROLLNO =?");
						System.out.println("Enter Mail Id");
						String mailid = sc.nextLine();

						System.out.println("Enter Phone Number");
						long phno = sc.nextLong();
						sc.nextLine(); 

						System.out.println("Enter rollno");
						int rn = Integer.parseInt(sc.nextLine());

						pst4.setString(1, mailid);
						pst4.setLong(2, phno);
						pst4.setInt(3, rn);

						int rowsAffected = pst4.executeUpdate();

						if (rowsAffected > 0) 
						{
						    System.out.println("Update successful for Roll No: " + rn);
						}
						else 
						{
						    System.out.println("No record found with Roll No: " + rn);
						}

						break;
						
					default:
						System.out.println("invalid Option choose valid option");
						
					}
				}
				else
				{
					System.out.println("Invalid Password,userid");
				}
				break;
			default:
				System.out.println("Invalid Option");
			}	
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}
}






