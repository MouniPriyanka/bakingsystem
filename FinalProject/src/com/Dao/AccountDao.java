package com.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Model.Account;

public class AccountDao {
	static Connection currentCon = null;
    static ResultSet rs = null;  
    static int i;
    public static List<Account> showAll(String id) {
    	Statement stmt = null; 
    	List<Account> accountsList = new ArrayList<Account>();
    	
    	System.out.println(id);
        String searchQuery = "select * from accountdata where customer_id="+id;
 	     System.out.println("Query: "+searchQuery);
 	    
     try 
     {
     	 System.out.println("entered try");
  	    
        currentCon = DbHelperS.getConnection();
        System.out.println("entered conn");
 	    
         stmt=currentCon.createStatement();
         rs = stmt.executeQuery(searchQuery);	        
         while(rs.next()) {
        	String customerid  = rs.getString("customer_id");
            int accountnumber = rs.getInt("account_number");
            String accountype  = rs.getString("account_type");
            int balance = rs.getInt("balance");
            Account account = new Account();
            account.setCustomerId((customerid));
            account.setAccountNumber(accountnumber);
            account.setAccountType(accountype);
            account.setBalance(balance);
            accountsList.add(account);
             //Display values
            System.out.print("customerid" + customerid);
            System.out.print(", accountnumber: " + accountnumber);
            System.out.print(", accountype: " + accountype);
            System.out.println(", balance " + balance);
            
         }
        rs.close();      
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

 return accountsList;
}
}