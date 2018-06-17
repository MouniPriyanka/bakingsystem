package com.Dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.Model.*;


public class changepassworddao {

	static Connection currentCon = null;
	 static ResultSet rs,rs1 = null;  
    static int i,j;  
    public static int changepassword(CustomerBean bean) {
	
       //preparing some objects for connection 
       Statement stmt = null;    
	
       int customerid =Integer.parseInt( bean.getCustomerId());    
       String oldpassword = bean.getoldpassword();   
	    String newpassword=bean.getnewPassword() ;        
       String searchQuery ="UPDATE CustomerCredentials SET password='"
	            +newpassword
       		+"' WHERE customer_id="
       		+customerid
       		+" and password='"
       		+oldpassword
       		+"'";             
	    
    // "System.out.println" prints in the console; Normally used to trace the process
   // System.out.println("Your customerid is " + customerid);          
   // System.out.println("Your oldpassword is " + oldpassword);         
   //System.out.println("Your newpassword is " + newpassword);
   // System.out.println("Query: "+searchQuery);
	    
    try 
    {
       //connect to DB 
       currentCon = DbHelperS.getConnection();
       stmt=currentCon.createStatement();
        i = stmt.executeUpdate(searchQuery);	        
        System.out.println(" res value in try:"+i);
        if(i==0){
        	bean.setValid(false);
        }
        else{
        	bean.setValid(true);
        }
    } 

    catch (Exception ex) 
    {
       System.out.println("Log In failed: An Exception has occurred! " + ex);
    } 
	    
    //some exception handling
    finally 
    {
  
       if (stmt!= null) {
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
    return i;
    }

}
