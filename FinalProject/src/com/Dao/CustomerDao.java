package com.Dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Model.*;

public class CustomerDao {
	 static Connection currentCon = null;
	 static ResultSet rs,rs1 = null;  
     static int i,j;  
     public static int changepwd(CustomerBean bean) {
	
        //preparing some objects for connection 
        Statement stmt = null;    
	
        String customerid = bean.getCustomerId();    
        String oldpassword = bean.getoldpassword();   
	    String newpassword=bean.getnewPassword() ;        
        String searchQuery ="UPDATE changepass SET customerpass='"
	            +newpassword
        		+"' WHERE customerid='"
        		+customerid
        		+"' and customerpass='"
        		+oldpassword
        		+"'";             
	    
     // "System.out.println" prints in the console; Normally used to trace the process
     System.out.println("Your customerid is " + customerid);          
     System.out.println("Your oldpassword is " + oldpassword);         
     System.out.println("Your newpassword is " + newpassword);
     System.out.println("Query: "+searchQuery);
	    
     try 
     {
        //connect to DB 
        currentCon = DBHelperV.getConnection();
        stmt=currentCon.createStatement();
         i = stmt.executeUpdate(searchQuery);	        
         System.out.println(" res value in try:"+i);
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
System.out.println(" res value:"+i);
return i;
	
     }	
     public static List<GeneratestmtBean> genstatement(GeneratestmtBean bean) {
    		
         //preparing some objects for connection 
         Statement stmt = null;    
         List<GeneratestmtBean> stmtList = new ArrayList<GeneratestmtBean>();
         String accountno=bean.getAccountno();
         String fromdate= bean.getfromdate();    
         String todate= bean.gettodate();  
         String lasttrans=bean.getlasttrans();
         System.out.println(lasttrans);
         String searchQuery = null;
         if(lasttrans==null){
        	 searchQuery = "select * from transactions where fromaccount=" +accountno+
     				
     				" and datefield between TO_DATE ('" + fromdate+"','yyyy-mm-dd')"   +  " AND TO_DATE ('" + todate+"','yyyy-mm-dd')";   
      System.out.println("Query: "+searchQuery);
         }
         else{
        	 searchQuery="select * from(select * from transactions where fromaccount="
        	 		+ accountno
        			+"order by datefield desc) where rownum<="
        			  +lasttrans;
        	 System.out.println("Query: "+searchQuery);
         }
      try 
      {
         //connect to DB 
         currentCon = DBHelperV.getConnection();
         stmt=currentCon.createStatement();
          rs= stmt.executeQuery(searchQuery);	        
          System.out.println(" rs");
          while(rs.next())
	       
          // if user does not exist set the isValid variable to fals
        	{
             String date = rs.getString("datefield");
             String narration = rs.getString("narration");
             String checkno = rs.getString("transid");
             String type= rs.getString("type");
             String amount = rs.getString("amount");
             String toaccount=rs.getString("toaccount");
             GeneratestmtBean beanList=new GeneratestmtBean ();
             beanList.setdate(date);
             beanList.setnarration(narration);
             beanList.setcheckno(checkno);
             beanList.settype(type);
             beanList.setamount(amount);
             beanList.setToaccount(toaccount);
             beanList.setValid(true);
             stmtList.add(beanList);
          }
         rs.close();
      } 

      catch (Exception ex) 
      {
         System.out.println("error in dao method " + ex);
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
 System.out.println(rs+"down");
 return stmtList;  
 
 	
      }
	public static int fundtransfer(FundtransBean bean) throws ClassNotFoundException,
    UnsufficientFundException, SQLException {
		  Statement statement = null;
		  String fromaccount= bean.getfromaccountno();    
	         String toaccount= bean.gettoaccountno();
	         int amount=Integer.parseInt(bean.getamount());
	        
	         try {
	        	  currentCon = DbHelperS.getConnection();
	        	  currentCon.setAutoCommit(false);

	            statement =currentCon.createStatement();
	            rs1 = statement.executeQuery("SELECT balance FROM accountdata" 
	                  + " WHERE account_number =" + fromaccount);
	            rs1.next();
	            int balance1 = rs1.getInt(1)- amount;
	            if (balance1 < 0)
	               throw new UnsufficientFundException("Unsufficient Fund.");
	            rs1.close();
	            rs1= statement.executeQuery("SELECT balance FROM accountdata"
	                  +" WHERE account_number =" + toaccount);
	            rs1.next();
	            int balance2 = rs1.getInt(1);
	            statement.executeUpdate(
	               "UPDATE accountdata SET balance=" + (balance1)
	               + " WHERE account_number=" + fromaccount);
	           j= statement.executeUpdate(
	               "UPDATE accountdata SET balance="
	               + (balance2 + amount)
	               + " WHERE account_number=" + toaccount);
	            currentCon.commit();
	         }catch(SQLException ex){
	        	 currentCon.rollback();
	            throw ex;
	         }finally{
	            if (rs1!= null)
	               rs1.close();
	            if (statement != null)
	               statement.close();
	            currentCon.close();
	         }
		return j;
	}	
	 	   
}
