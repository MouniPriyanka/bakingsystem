package userLoginPkg;

import java.sql.*;
//import java.util.*;


public class ConnectionManager {

   static Connection con;
   static String url;
         
   public static Connection getConnection()
   {
     
      try
      {
         String url = "jdbc:oracle:thin:@localhost:1521:XE"; 
         // assuming "DataSource" is your DataSource name

         Class.forName("oracle.jdbc.driver.OracleDriver");
         
         try
         {            	
            con = DriverManager.getConnection(url,"team4","team4");              
         }
         
         catch (SQLException ex)
         {
            ex.printStackTrace();
         }
      }

      catch(ClassNotFoundException e)
      {
         System.out.println(e);
         e.printStackTrace();
      }

   return con;
}
}