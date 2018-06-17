package editCustomer;
import java.sql.*;

import userLoginPkg.ConnectionManager;

public class EditCustomerDao 	
{
 static Connection currentCon = null;
 static ResultSet rs = null;  
	
	
	
 public static EditCustomerBean fillform(String ssn) {
	
    //preparing some objects for connection 
    Statement stmt = null;      
    EditCustomerBean bean=new EditCustomerBean();
    String searchQuery =
          "select * from CustomerProfile where ssn='"+ ssn+ "'";
	    
 // "System.out.println" prints in the console; Normally used to trace the process
 System.out.println("Your ssn is " + ssn);          

 System.out.println("Query: "+searchQuery);
	    
 try 
 {
    //connect to DB 
    currentCon = ConnectionManager.getConnection();
   
    stmt=currentCon.createStatement();
    rs = stmt.executeQuery(searchQuery);	        
    while(rs.next()){
    	bean.setCustomerID(rs.getInt("CustomerID"));
    	String d=rs.getString("DOB");
    	bean.setDOB(d);
    	System.out.println("DOB:- " +bean.getDOB());
    	bean.setEmail(rs.getString("Email"));
    	bean.setGender(rs.getString("Gender"));
    	bean.setName(rs.getString("Name"));
    	bean.setPhonenumber(rs.getInt("PhoneNumber"));
    	bean.setResidence(rs.getString("Residence"));
    	bean.setSSN(rs.getString("SSN"));
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

return bean;
	
 }	
}


