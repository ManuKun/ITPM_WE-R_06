package timetablems;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
     Connection con = null;
     
     public static Connection ConnectionDB(){
         try{
             Class.forName("org.sqlite.JDBC");
             Connection con = DriverManager.getConnection("jdbc:sqlite:ttms.db");
             System.out.println("Connection Succeed");
             return con;
         }
         catch(Exception e){
             System.out.println("Connection Failed");
             return null;
         }
         
     }
}
