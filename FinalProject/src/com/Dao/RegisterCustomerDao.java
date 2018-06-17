package com.Dao;
import com.Model.*;
import com.Dao.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class RegisterCustomerDao {
	 static Connection currentCon = null;
	   static int created;
	
	   public static RegisterCustomerBean registerCustomer(RegisterCustomerBean bean){
				
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
			         bean.setRegistered(false);	
		    	
				  	   
			   }
		      else if(x1 && !x2){
		    	  System.out.println("Hi!");
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
				         bean.setRegistered(true);		
				   }
				   else{
					   System.out.println("Not a valid Customer! Please visit bank for profile creation.");
				         bean.setRegistered(false);	
				   }
				   
		      }
		      
			   else{
				   System.out.println("Online Account Could not be created!");
			         bean.setRegistered(false);	
				  
			   }
		     
		   }
	      catch(SQLException se){
	    	System.out.println("Online Account Could not be created!");
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
