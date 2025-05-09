package program;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Car {
public static void main(String[] args) {
    try {
    	System.out.println("----------------");
        Connection con = DriverManager.getConnection
                ("jdbc:oracle:thin:@//localhost:1522/orcl"
,"mydb11", "subodh");
         Statement stmt = con.createStatement();
         ResultSet rSet = stmt.executeQuery("select * from CAR");
         System.out.println("Details of cars: ");
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