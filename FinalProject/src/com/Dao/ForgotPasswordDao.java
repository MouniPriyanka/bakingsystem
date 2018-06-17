package com.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Model.ForgotPasswordBean;


public class ForgotPasswordDao {

	static Connection currentCon = null;
	   static int created;
	
	   public static ForgotPasswordBean forgotPassword(ForgotPasswordBean bean){
				
	   int customerid;
	   String password;
	   //String email = null;
	   ResultSet rs,rs1;
	   
	   customerid= bean.getCustomerId();
	   password=bean.getPassword();
	   
	   
	   Statement stmt = null; 
		  System.out.println(customerid);
	   String validate="select * from CustomerProfile where customerid="+customerid;
	   System.out.println(validate);
	   String validate1="select * from CustomerCredentials where customer_id="+customerid;
	   try{
	    	
	    	  currentCon = DbHelperS.getConnection();
		      stmt=currentCon.createStatement();
		      rs=stmt.executeQuery(validate);
		      
		    //  rs1=stmt.executeQuery(validate1);
		      // bean.setEmail(email);
		      //System.out.println(rs);
		      //System.out.println(rs.getString(1));
		      boolean x1=rs.next();
		     rs.close();
		      rs1=stmt.executeQuery(validate1);
		      boolean x2=rs1.next();
		      rs1.close();
		      System.out.println(x1+" "+x2);
		      
		      if(x1&&x2){
		    	  
		    	  System.out.println("Already Registered !");
		    	  //Update Password
		    	  System.out.println("Hi!");
		    	  String updatePassword=" Update CustomerCredentials set password='"+password+"' where customer_id="+customerid;
				   try{
				    	
				    	 created=stmt.executeUpdate(updatePassword);
					   }
				      catch(SQLException se){
				    	System.out.println("Online Account Could not be Updated!");
				    	se.printStackTrace();
				    	
				      }
				   if(created==1){
					   System.out.println("Account Updated");
				         bean.setUpdated(true);		
				   }
				   else{
					   System.out.println("Not a valid Customer! Please visit bank for profile creation.");
				         bean.setUpdated(false);	
				   }
		    	 		    	 
		    	  bean.setUpdated(true);	
		    	
				  	   
			   }
		      else if(x1 && !x2){
		    	 /* System.out.println("Hi!");
				   String register="insert into CustomerCredentials(customer_id, password) values ("+customerid+",'"+password+"')";
				   try{
				    	
				    	 created=stmt.executeUpdate(register);
					   }
				      catch(SQLException se){
				    	System.out.println("Online Account Could not be Registered!");
				    	se.printStackTrace();
				    	
				      }
				   if(created==1){
					   System.out.println("Account Registered");
				         bean.setUpdated(true);		
				   }
				   else{
					   System.out.println("Not a valid Customer! Please visit bank for profile creation.");
				         bean.setUpdated(false);	
				   }*/
		    	  System.out.println("No Online Account! Please Register first!");
			         bean.setUpdated(false);	
				   
		      }
		      
			   else{
				   System.out.println("Online Account Could not be updated!");
			         bean.setUpdated(false);	
				  
			   }
		     
		   }
	      catch(SQLException se){
	    	System.out.println("Online Account Could not be updated!");
	    	se.printStackTrace();
	    	
	      }
		 finally 
	   		{
		
			      if (currentCon != null) {
			         try {
			        	 currentCon.setAutoCommit(true);
			            currentCon.close();
			         } catch (Exception e) {
			         }

			         currentCon = null;
			      }
				
			     
			}
	  
	   
	   
	   return bean;
	   
	   }

}
