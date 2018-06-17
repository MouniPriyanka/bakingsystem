package registerCustomerPkg;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import userLoginPkg.ConnectionManager;

public class RegisterconfirmDao {
	
	static Connection currentCon = null;
	   static ResultSet rs = null;

	    
	   public static RegisterconfirmBean confirm(RegisterconfirmBean bean){
		   
		   int val=0,c_id=0;
		   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		   Date date = new Date();
		   System.out.println(" date //registerConfirmDao : - " + dateFormat.format(date));
		   
		   c_id=bean.getC_id();
		   Statement stmt = null; 
		   System.out.println("C_ID IS :_ "+c_id );
		   
		   String insertQuery1 = "insert into CustomerProfile(CustomerID,Name,Gender,DOB,Residence,SSN,PhoneNumber,Email,Status)"
		   		+ "select '"+c_id+"',Name,Gender,DOB,Residence,SSN,PhoneNumber,Email,'active' "
		   		+ "from Temp_CustomerProfile "
		   		+ "where CustomerID='"+c_id+"' and ssn in (select ssn from eligiblessn)";
		   //rs=stmt.executeQuery("select CustomerID from Temp_CustomerProfile where SSN='"+SSN+"'");
		   //String RetrieveQuery1="select CustomerID from Temp_CustomerProfile where SSN='"+SSN+"'"";
		   //String RetrieveQuery2="";
		   
		   String insertQuery2 = "insert into AccountData(Account_Number,Customer_ID,Account_Type,Date_Opened,Date_Closed,Branch_Code,Balance,OD,ST)"
		   		+ "select  pcpseq.nextval,Customer_ID,Account_Type,Date_Opened,TO_DATE('"+dateFormat.format(date)+ "','yyyy/mm/dd')"+",Branch_Code,Balance,OD,'active'"
		   		+ "from Temp_AccountData4 "
		   		+ "where Customer_ID=" + c_id;
		   
		   
		   String deleteQuery1 = "delete from Temp_CustomerProfile where ssn in (select ssn from eligiblessn)";
		   String deleteQuery2 = "delete from Temp_AccountData4 where Customer_ID="+c_id;
		   
		   try 
		   {
			
		      //connect to DB 
		      currentCon = ConnectionManager.getConnection();
		      //currentCon.setAutoCommit(false);
		      stmt=currentCon.createStatement();
		      val = stmt.executeUpdate(insertQuery1);
		      //currentCon.commit();
		      System.out.println("insertQuery1 executed + val= "+ val);
		      val = stmt.executeUpdate(insertQuery2);
		      currentCon.commit();
		      System.out.println("insertQuery2 executed");
		      val = stmt.executeUpdate(deleteQuery2);
		      //currentCon.commit();
		      System.out.println("deleteQuery2 executed");
		      
		      val = stmt.executeUpdate(deleteQuery1);
		      //currentCon.commit();
		      System.out.println("deleteQuery2 executed");  
			       
		      // if user does not exist set the isValid variable to false
		      if (val==0) 
		      {
		         System.out.println("Sorry, you are not a registered user! Please sign up first");
		         bean.setConfirmstatus(false);
		      } 
			        
		      //if user exists set the isValid variable to true
		      else 
		      {  	
		         System.out.println("Welcome " ); //+ firstName);
		     
		         bean.setConfirmstatus(true);
		      } 
		   } 

		   catch (Exception ex) 
		   {
			   
			   if (currentCon != null) {
			         try {
			        	 //currentCon.setAutoCommit(true);
			            currentCon.close();
			         } catch (Exception e) {
			         }
			         currentCon = null;
			   }
		      System.out.println("Log In failed: An Exception has occurred! " + ex);
		      ex.printStackTrace();
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

		   
		   
		
		return bean;
	}

}
