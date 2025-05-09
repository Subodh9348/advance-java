package student_info;

import java.sql.*;

public class Student1 {
    String studentId;
    String studentName;
    String course;
    int semester;
    String email;
    String phoneNumber;

    public Student1(String studentId, String studentName, String course, int semester, String email, String phoneNumber) {
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
                System.out.println("id:"+rs.getString(1)+"\tname:"+rs.getString(2)+"\tcourse:\t"+rs.getString(3)+"\tsemester:"+rs.getInt(4)+"\temail"+rs.getString(5)+"\tphone"+rs.getString(6));
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
            	System.out.println("id:"+rs.getString(1)+"\tname:"+rs.getString(2)+"\tcourse:\t"+rs.getString(3)+"\tsemester:"+rs.getInt(4)+"\temail"+rs.getString(5)+"\tphone"+rs.getString(6));
            
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
