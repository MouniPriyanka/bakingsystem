package com.Dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.Model.*;
import com.Controller.Mailer;
import com.Dao.*;

public class OtpDao {
	 static Connection currentCon = null;
	  
	   
	  public static void otpGenerate(int customerid, int otp)
	  {
	 String email=null;
     int t=0;
     
    
     String sql = "select * from customerprofile";
     try
     {
    	 currentCon = DbHelperS.getConnection();
    	 Statement s = currentCon.createStatement();
    	 ResultSet r = s.executeQuery(sql);
    	 while(r.next())
    	 {
    		 t=r.getInt("customerid");
    		 if(customerid==t)
    		 {
    			 email = r.getString("email");
    		 }
        
    	 }
    	 System.out.println("in Dao");
         String msg = Integer.toString(otp);
         Mailer.send("wellsteam04@gmail.com", "wellsteam4", email, "OTP", msg);
        // RegisterCustomerBean bean= new RegisterCustomerBean();
      
	  }
	  catch(Exception ex)
      {
		  ex.printStackTrace();
	  }
         
	  }
}
