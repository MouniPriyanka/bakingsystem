package eligibilityCheckpkg;
import java.sql.*;

import userLoginPkg.ConnectionManager;
public class EligibilityDao {
	
	   static Connection currentCon = null;
	   static ResultSet rs = null;  
		
		
		
	   public static EligibilityBean Check(EligibilityBean bean) {
		
	      //preparing some objects for connection 
	      Statement stmt = null;    
		
	      String ssn = bean.getssn();    
	        
		    
	      String searchQuery =
	            "select * from EligibleSSN where ssn='"
	                     + ssn
	                     + "'";
		    
	   // "System.out.println" prints in the console; Normally used to trace the process
	   System.out.println("Your ssn is " + ssn);          
	   System.out.println("Query: "+searchQuery);
		    
	   try 
	   {
	      //connect to DB 
	      currentCon = ConnectionManager.getConnection();
	      stmt=currentCon.createStatement();
	      rs = stmt.executeQuery(searchQuery);
	      //System.out.println("rs:- " + rs.getString("ssn"));
	     	      boolean more = rs.next();
	     	     //System.out.println("rs:- " + rs.getString("ssn"));

		   //System.out.println("MOre: - " + more);    
	      // if user does not exist set the isValid variable to false
	      if (!more) 
	      {
	         System.out.println("Sorry, you are not an Eligible user!");
	         bean.setEligible(false);
	      } 
		        
	      //if user exists set the isValid variable to true
	      else if (more) 
	      {  	
	         System.out.println("Eligible  " ); //+ firstName);
	     
	         bean.setEligible(true);
	      }
	   } 

	   catch (Exception ex) 
	   {
	      System.out.println("Eligibility Check failed: An Exception has occurred! " + ex);
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
