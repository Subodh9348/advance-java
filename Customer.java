package program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Customer {
	String customerId;
	String customerName;
	String email;
	String phoneNumber;
	String address;
	String city;
	int pincode;
	public void insertCustomer(String customerId,String customerName,String email,String phoneNumber,String address,String city,int pincode) {
		//super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
	}
	public static void main (String[]args){
	try {
		
		Connection con = DriverManager.getConnection
                ("jdbc:oracle:thin:@//localhost:1522/orcl","mydb11", "subodh");
		PreparedStatement ps=con.prepareStatement("insert into customer_data values(?,?,?,?,?,?,?)");
		Scanner sc=new Scanner(System.in);
		System.out.println("enter cid");
		int cid=Integer.parseInt(sc.nextLine());
		System.out.println("enter customer name");
		String cname=sc.nextLine();
		System.out.println("enter email id");
		String email=sc.nextLine();
		System.out.println("enter phone number");
		long phno=sc.nextLong();
		System.out.println("enter address");
		String address=sc.nextLine();
		sc.next();
		System.out.println("enter the city");
		String city=sc.nextLine();
		sc.next();
		System.out.println("enter the pincode");
		long pincode=sc.nextLong();
		int upd=ps.executeUpdate("insert into customer_data values('"+cid+"','"+cname+"','"+email+"','"+phno+"','"+address+"','"+city+"','"+pincode+"')");
		if(upd>0) {
			System.out.println("entered successfully");
		}
		Customer c1=new Customer();
		Customer c2=new Customer();
		Customer c3=new Customer();
		c1.insertCustomer(city, cname, email, email, address, city, upd);
		
		
	}
	catch(Exception e){
		
	}
	}

}
