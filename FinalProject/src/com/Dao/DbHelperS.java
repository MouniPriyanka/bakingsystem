package com.Dao;
import java.sql.*;
import java.util.*;

public  class DbHelperS {
	 

	      static Connection con;
	      static String url;
	            
	      public static Connection getConnection()
	      {
	        
	         try
	         {
	            String url = "jdbc:oracle:thin:@192.168.0.7:1521:xe"; 
	            // assuming "DataSource" is your DataSource name

	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            
	            try
	            {            	
	               con = DriverManager.getConnection(url,"team4","team4"); 
	                								
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




