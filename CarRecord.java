package com.subodh.methhodprogram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//public class CarRecord {
//public static void main(String[] args) {
////    try {
////    	System.out.println("----------------");
////        Connection con = DriverManager.getConnection
////                ("jdbc:oracle:thin:@//localhost:1522/orcl"
////,"mydb11", "subodh");
////         Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
////         
////         ResultSet rSet = stmt.executeQuery("select * from CAR");
////         System.out.println("Details of cars: ");
////         rSet.last();
////         //while(rSet.next()) {
////         System.out.println("Brand Name: "+rSet.getString(1)
////         +"\tModel: "+rSet.getString(2)+"\tYOM: "+rSet.getInt(3)
////         +"\tType: "+rSet.getString(4)+"\tMileage: "+rSet.getInt(5));    
////        // }
////         rSet.close();
////         stmt.close();
////         con.close();  
////         
////         //System.out.println("Hello");
////    }
////    catch(Exception e) {
////       System.out.println(e.getMessage());
////    }
//}
//}


//dispaly the brand name start with T....


public class CarRecord {
public static void main(String[] args) {
//  try {
//  	System.out.println("----------------");
//      Connection con = DriverManager.getConnection
//              ("jdbc:oracle:thin:@//localhost:1522/orcl"
//,"mydb11", "subodh");
//       Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
//       
//       ResultSet rSet = stmt.executeQuery("select * from CAR ");
//      // PreparedStatement ps=con.prepareStatement("select * from car where brandname like ");
//       System.out.println("Details of cars: ");
//       rSet.first();
//       System.out.println("\t name starts with T.....................");
//       while(rSet.next()) {
//    	   String brandname=rSet.getString(1);
//    	   if(brandname.startsWith("T")) {
//    		   System.out.println("Brand Name: "+rSet.getString(1)
//    	       +"\tModel: "+rSet.getString(2)+"\tYOM: "+rSet.getInt(3)
//    	       +"\tType: "+rSet.getString(4)+"\tMileage: "+rSet.getInt(5));  
//    		   
//    	   }
//       }
//       
//       
//       System.out.println("............car details...................");
//       rSet.first();
//       while(rSet.next()) {
//       System.out.println("Brand Name: "+rSet.getString(1)
//       +"\tModel: "+rSet.getString(2)+"\tYOM: "+rSet.getInt(3)
//       +"\tType: "+rSet.getString(4)+"\tMileage: "+rSet.getInt(5));    
//        }
//       rSet.close();
//       stmt.close();
//       con.close();  
//       
//       //System.out.println("Hello");
//  }
//  catch(Exception e) {
//     System.out.println(e.getMessage());
//  }
	
	
	try {
	  	System.out.println("----------------");
	      Connection con = DriverManager.getConnection
	              ("jdbc:oracle:thin:@//localhost:1522/orcl"
	,"mydb11", "subodh");
	       Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	       
	       ResultSet rSet = stmt.executeQuery("select * from CAR ");
	      // PreparedStatement ps=con.prepareStatement("select * from car where brandname like ");
	       System.out.println("Details of cars: ");
	       rSet.first();
	       int rowCount=0;
	       
	       while(rSet.next()) {
	    	   rowCount++;
	    	   if (rowCount%2==0) {
	    		   
	    		   continue;
	    		   
	    		   
	    	   }else {
	    		   System.out.println("Brand Name: "+rSet.getString(1)
	    	       +"\tModel: "+rSet.getString(2)+"\tYOM: "+rSet.getInt(3)
	    	       +"\tType: "+rSet.getString(4)+"\tMileage: "+rSet.getInt(5));    
	    	   }
	    	   
	    	   
	       }
	       
	       
	       System.out.println("............car details...................");
	       rSet.first();
	       while(rSet.next()) {
	       System.out.println("Brand Name: "+rSet.getString(1)
	       +"\tModel: "+rSet.getString(2)+"\tYOM: "+rSet.getInt(3)
	       +"\tType: "+rSet.getString(4)+"\tMileage: "+rSet.getInt(5));    
	        }
	       rSet.close();
	       stmt.close();
	       con.close();  
	       
	       //System.out.println("Hello");
	  }
	  catch(Exception e) {
	     System.out.println(e.getMessage());
	  }

}


}







