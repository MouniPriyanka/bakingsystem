package com.Dao;
import com.Model.*;
import com.Dao.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class CustomerLoginDao {
	static Connection currentCon = null;
    static ResultSet rs = null;  
	
	
	
    public static CustomerLoginBean login(CustomerLoginBean customer) {
	
       //preparing some objects for connection 
       Statement stmt = null;    
	
       int customerid = customer.getCustomerId();  
       String password = customer.getPassword();   
	    
       String loginQuery =
             "select * from CustomerCredentials where customer_id="
                      + customerid
                      + " AND password='"
                      + password
                      + "'";
      // String searchQuery="select name from CustomerProfile where customer_id="+customerid;
	    
    // "System.out.println" prints in the console; Normally used to trace the process
    System.out.println("Your user name is " + customerid);          
    System.out.println("Your password is " + password);
    System.out.println("Query: "+loginQuery);
	    
    try 
    {
    	 System.out.println("entered try");
 	    
       //connect to DB 
    
       currentCon = DbHelperS.getConnection();
       System.out.println("entered conn");
	    
       stmt=currentCon.createStatement();
       rs = stmt.executeQuery(loginQuery);	        
       boolean more = rs.next();
       
	       
       // if user does not exist set the isValid variable to false
       if (!more) 
       {
          System.out.println("Sorry, you are not a registered user! Please sign up first");
          customer.setValid(false);
       } 
	        
       //if user exists set the isValid variable to true
       else if (more) 
       {
         // String name = rs.getString("name");
               	
          System.out.println("Welcome ");
          customer.setValid(true);
       }
    } 

    catch (Exception ex) 
    {
       System.out.println("Log In failed: An Exception has occurred! " + ex);
    } 
	    
    //some exception handling
    finally 
    {
       if (rs != null)	{
          try {
             rs.close();
          } catch (Exception e) {}
             rs = null;
          }
	
       if (stmt != null) {
          try {
             stmt.close();
          } catch (Exception e) {}
             stmt = null;
          }
	
       if (currentCon != null) {
          try {
             currentCon.close();
          } catch (Exception e) {
          }

          currentCon = null;
       }
    }

return customer;
    }
}
