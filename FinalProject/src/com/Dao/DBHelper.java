package com.Dao;
import java.sql.*;
import java.util.*;

public  class DBHelper {
	 

	      static Connection con;
	      static String url;
	            
	      public static Connection getConnection()
	      {
	        
	         try
	         {
	            String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
	            // assuming "DataSource" is your DataSource name

	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            
	            try
	            {            	
	               con = DriverManager.getConnection(url,"bank","bank"); 
	                								
	            // assuming your SQL Server's	username is "username"               
	            // and password is "password"
	                 
	            }
	            
	            catch (SQLException ex)
	            {
	               ex.printStackTrace();
	            }
	         }

	         catch(ClassNotFoundException e)
	         {
	            System.out.println(e);
	         }

	      return con;
	}
	   }
