package program;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Scanner;
//
//public class StudentManagement {
//	String studentId;
//	String studentName;
//	String course;
//	int semester;
//	String email;
//	String phoneNumber;
//	public StudentManagement(String studentId, String studentName, String course, int semester, String email,
//			String phoneNumber) {
//		super();
//		this.studentId = studentId;
//		this.studentName = studentName;
//		this.course = course;
//		this.semester = semester;
//		this.email = email;
//		this.phoneNumber = phoneNumber;
//	}
//	public void insertStudent(Student student) {
//		try {
//			Connection con = DriverManager.getConnection
//	                ("jdbc:oracle:thin:@//localhost:1522/orcl","mydb11", "subodh");
//			PreparedStatement ps=con.prepareStatement("insert into Studentmg1 values(?,?,?,?,?,?)");
//			
//			
//		}
//		catch(Exception e){
//			
//		}
//		
//		
//	}
//	public void fetchAllStudents() {
//		Scanner sc=new Scanner(System.in);
//		System.out.println("enter sid");
//		int sid=Integer.parseInt(sc.nextLine());
//		System.out.println("enter student name");
//		String sname=sc.nextLine();
//		System.out.println("enter student couse");
//		int course=Integer.parseInt(sc.nextLine());
//		System.out.println("enter semester");
//		int semester=Integer.parseInt(sc.nextLine());
//		System.out.println("enter email");
//		String email=sc.nextLine();
//		System.out.println("enter phone number");
//		long phno=sc.nextLong();
//		PreparedStatement ps=null;
//		int upd = 0;
//		try {
//			upd = ps.executeUpdate("insert into customer_data values('"+sid+"','"+sname+"','"+course+"','"+semester+"','"+email+"','"+phno+"')");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if(upd>0) {
//			System.out.println("entered successfully");
//		}
//		
//		
//	}
//	public void fetchStudentById(String studentId) {
//		Connection con = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//
//        try {
//            // Establish database connection
//           // con = DriverManager.getConnection(
//                //"jdbc:oracle:thin:@//localhost:1522/orcl", "mydb11", "subodh");
//
//            // Prepare SQL query
//            //String query = "SELECT ID, NAME, AGE FROM STUDENT WHERE ID = ?";
//            ps = con.prepareStatement("SELECT count(*) FROM Studentmg1  WHERE ID = ?");
//            ps.setString(1, studentId);
//            rs=ps.executeQuery();
//            int choice = 0;
//            switch(choice) {
//            case 1:
//            
//            if (rs.next()) {
//                String sid = rs.getString("ID");
//                int res=ps.executeUpdate();
//                ResultSet  res1=ps.executeQuery();
//				while(rs.next())
//				{
//					System.out.println(rs.getInt(1)+"\t"+
//				                       rs.getString(2)+"\t"+
//							           rs.getInt(3)+"\t"+
//				                       rs.getString(4)+"\t"+
//							           rs.getString(5)+"\t"+
//				                       rs.getString(6)+"\t"+
//							           rs.getString(7));
//				}
//                
//               
//
//                System.out.println("Student Found:");
//                System.out.println("ID: " + sid);
//             
//            } else {
//                System.out.println("No student found with ID: " + studentId);
//            }
//
//            }
//        }
//        catch(Exception e){
//        	
//        }
//		
//		
//	}
//	public void updateStudentEmail(String studentId, String newEmail) {
//		
//		
//	}
//	public void deleteStudentById(String studentId) {
//		
//	}
//	public static void main (String []args) {
//		try {
//		Connection con = DriverManager.getConnection
//                ("jdbc:oracle:thin:@//localhost:1522/orcl","mydb11", "subodh");
//		PreparedStatement ps=null;
//		Scanner sc =new Scanner(System.in);
//		int choice=Integer.parseInt(sc.nextLine());
//		//String choice= sc.nextLine();
//		//int choice=sc.nextInt();
//		switch(choice) {
//		case 1:
//			
//		}
//		
//		//StudentManagement sm=new StudentManagement(, course, course, semester, course, course);
//		
//		}
//		catch(Exception e){
//			
//		}
//		
//	}
//
//
//}
  

import java.sql.*;

public class StudentManagement {
    String studentId;
    String studentName;
    String course;
    int semester;
    String email;
    String phoneNumber;

    public StudentManagement(String studentId, String studentName, String course, int semester, String email, String phoneNumber) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.course = course;
        this.semester = semester;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void insertStudent() {
        try {
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl", "mydb11", "subodh");
            String sql = "INSERT INTO StudentTable VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, studentId);
            ps.setString(2, studentName);
            ps.setString(3, course);
            ps.setInt(4, semester);
            ps.setString(5, email);
            ps.setString(6, phoneNumber);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Student inserted successfully." : "Insert failed.");
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error inserting student: " + e.getMessage());
        }
    }

    public static void fetchAllStudents() {
        try {
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl", "mydb11", "subodh");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM StudentTable");
            while (rs.next()) {
                System.out.printf("ID: %s, Name: %s, Course: %s, Semester: %d, Email: %s, Phone: %s%n",
                        rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getString(5), rs.getString(6));
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error fetching students: " + e.getMessage());
        }
    }

    public static void fetchStudentById(String id) {
        try {
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl", "mydb11", "subodh");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM StudentTable WHERE studentId = ?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.printf("ID: %s, Name: %s, Course: %s, Semester: %d, Email: %s, Phone: %s%n",
                        rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getInt(4), rs.getString(5), rs.getString(6));
            } else {
                System.out.println("Student not found.");
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error fetching student: " + e.getMessage());
        }
    }

    public static void updateStudentEmail(String id, String newEmail) {
        try {
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl", "mydb11", "subodh");
            PreparedStatement ps = con.prepareStatement("UPDATE StudentTable SET email = ? WHERE studentId = ?");
            ps.setString(1, newEmail);
            ps.setString(2, id);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Email updated successfully." : "Update failed.");
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error updating email: " + e.getMessage());
        }
    }

    public static void deleteStudentById(String id) {
        try {
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl", "mydb11", "subodh");
            PreparedStatement ps = con.prepareStatement("DELETE FROM StudentTable WHERE studentId = ?");
            ps.setString(1, id);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Student deleted successfully." : "Delete failed.");
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }
}
