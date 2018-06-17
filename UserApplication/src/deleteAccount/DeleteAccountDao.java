package deleteAccount;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import userLoginPkg.ConnectionManager;

public class DeleteAccountDao {

	
	
	static Connection currentCon = null;
	static int closed;
	 public static DeleteAccountBean closeAccount(DeleteAccountBean bean){
	
		 int accountnumber,c_id,count=0,balance=0;
		
		 accountnumber=bean.getAccountNumber();
		 c_id=bean.getCustomer_id();
		 Statement stmt = null; 
		  ResultSet r=null,rs=null;
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		 Date date = new Date();
		 String sql="select balance from accountdata where account_number=" + accountnumber;
		 
		 String closeAccount= "UPDATE ACCOUNTDATA SET ST= 'Closed', BALANCE = 0, DATE_CLOSED= TO_DATE('" +dateFormat.format(date)+ "','yyyy/MM/dd') WHERE ACCOUNT_NUMBER="+ accountnumber;
		 String countQuery=   "SELECT count(Account_Number) as count  FROM accountdata " + 
				   "where customer_id="+c_id +" and st='active'" ;

		 try{
			  currentCon = ConnectionManager.getConnection();
			  currentCon.setAutoCommit(false);
		      stmt=currentCon.createStatement();
		       r = stmt.executeQuery(sql);
				while (r.next()) {
					balance=r.getInt("balance");
				}
				r.close();
		 }
		 catch(SQLException se){
		    	System.out.println("Sorry something went wrong!");
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
			      if (r != null)	{
			          try {
			             r.close();
			          } catch (Exception e) {}
			             r = null;
			          }
			 	
			       if (stmt != null) {
			          try {
			             stmt.close();
			          } catch (Exception e) {}
			             stmt = null;
			          }
			 	
				
			     
			}
		 
		 
		 if(balance==0){ 
		 
		 try{
		    	
	    	  currentCon = ConnectionManager.getConnection();
	    	  currentCon.setAutoCommit(false);
		      stmt=currentCon.createStatement();
		      closed=stmt.executeUpdate(closeAccount);
				 if (closed==0) 
			      {
			         System.out.println("Sorry,Account Closing Unsuccessfull !");
			         bean.setClosed(false);
			      } 
				    
			      else 
			      {  	
			         System.out.println("Customer Account Successfully Closed  " ); 
			         
			         bean.setClosed(true);
			      } 
		      System.out.println( "Count query is  : - "+ countQuery);
		      rs=stmt.executeQuery(countQuery);
		      currentCon.commit();
		      
		      while(rs.next()){
		    	  System.out.println("In while ");
		    	  count=rs.getInt("count");
		    	  System.out.println( "Count = " + count);
		    	  if(count==0){
		    		  count=stmt.executeUpdate("Update CustomerProfile SET status='Closed' where Customerid ="+ c_id);
		    		  System.out.print("Customer Profile Updated - " + count + " rows modified ");
		    	  }
		      }
		      
		      
		   }
	      catch(SQLException se){
	    	System.out.println("Account could not be closed!");
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
		 
		 
		 
	 }
		 else 
		 {
			 String popup="Cannot close the account! Please ask the Customer to empty the balance.";
				bean.setpopup(popup);
				System.out.println(popup);
		 }

		 
		 //trigger function
		 
		
		 
		
		 return bean;
	 }
}



