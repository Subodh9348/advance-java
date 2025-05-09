package student_info;

import java.util.Scanner;

public class StudentResult {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      //  System.out.println("-------------87r5e45---");
        while (true) {
            System.out.println("\n===== Student Management Menu =====");
            System.out.println("1. Insert Student");
            System.out.println("2. Fetch All Students");
            System.out.println("3. Fetch Student by ID");
            System.out.println("4. Update Student Email");
            System.out.println("5. Delete Student by ID");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();
                    System.out.print("Enter Semester: ");
                    int semester = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();
                    Student1 s = new Student1(id, name, course, semester, email, phone);
                    s.insertStudent();
                    break;
                case 2:
                    Student1.fetchAllStudents();
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    String sid = sc.nextLine();
                    Student1.fetchStudentById(sid);
                    break;
                case 4:
                    System.out.print("Enter Student ID: ");
                    String uid = sc.nextLine();
                    System.out.print("Enter New Email: ");
                    String newEmail = sc.nextLine();
                    Student1.updateStudentEmail(uid, newEmail);
                    break;
                case 5:
                    System.out.print("Enter Student ID to Delete: ");
                    String did = sc.nextLine();
                    Student1.deleteStudentById(did);
                    break;
                case 6:
                    System.out.println("Exiting application.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
