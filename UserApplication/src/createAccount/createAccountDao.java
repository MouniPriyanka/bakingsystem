package createAccount;
import java.util.Date;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import userLoginPkg.ConnectionManager;
public class createAccountDao {
	

	
	   static Connection currentCon = null;
	   static int exists;
	 
	   public static createAccountBean addAccount(createAccountBean bean) {
		  
		   
	      String AccountType,BranchCode,OverDraft;
	      int Balance,Customerid;
	      int val = 0;
	      int type=0,flag=0;
	      int typeflag=0,existsflag=0,minbalflag=0;
	      
	      Statement stmt = null; 
	      PreparedStatement preparedStatement = null;
	     		                
	      AccountType=bean.getAccountType();
	      BranchCode=bean.getBranchCode();
	      OverDraft=bean.getOverDraft();
	      Balance=bean.getBalance();
	      Customerid=bean.getCustomerID();
	      
	      
	      if(Balance <5000)
	    	  minbalflag=1;
	      
	      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	      Date date = new Date();
	      
	      System.out.println(" date : - " + dateFormat.format(date));	      
	      String fetch ="select * from CustomerProfile where customerid="+Customerid;
	      try{
	    	
	    	  currentCon = ConnectionManager.getConnection();
		      stmt=currentCon.createStatement();
		      exists=stmt.executeUpdate(fetch);
		      if(exists==0)
		    	  existsflag=1;
		      
		    
	      }
	      catch(SQLException se){
	    	  //existsflag=1;
	    	bean.setPopupmsg("Customer does not exist!");
	    	System.out.println("Customer does not exist!");
	    	se.printStackTrace();
	    	//flag=0;
	    	
	      }
	      String fetch1=
	    		  "select * from accountdata where customer_id="
	    				  +Customerid+" and account_type='"+AccountType+"'";
	      System.out.println("Fetch1= " + fetch1);
		  try{
			    	
		    	  currentCon = ConnectionManager.getConnection();
			      stmt=currentCon.createStatement();
			      type=stmt.executeUpdate(fetch1);
			    	System.out.println("AccountType" + AccountType);
			    	System.out.println("type" + type);
			    	if(type>=5)
			    		typeflag=1;
			    
		 }
		  catch(SQLException se){
		    	  bean.setPopupmsg("Customer Already has "+ type + " " + AccountType + "Accounts! ");
		    	  
		    	System.out.println("AccountType" + AccountType);
		    	System.out.println("type" + type);
		    	se.printStackTrace();
		    	//flag=0;
		    	
		  }	  
		      
	      if(exists>0 && Balance>=5000 && type<=4)
	      {
	    	  
			String insertAccountData = "INSERT INTO ACCOUNTDATA"
					+ "(account_number,customer_id,account_type,date_opened,branch_code,balance,od,st) VALUES"
					+ "(pcpseq.nextval,"+Customerid+",?,TO_DATE('" +dateFormat.format(date)+ "','yyyy/MM/dd'),?,?,?,?)"; 
			try{
					currentCon=ConnectionManager.getConnection();
					preparedStatement = currentCon.prepareStatement(insertAccountData);
								
					preparedStatement.setString(1,AccountType);
					preparedStatement.setString(2,BranchCode);
					preparedStatement.setInt(3,Balance);
					preparedStatement.setString(4,OverDraft);
					preparedStatement.setString(5,"active");
					
				 	System.out.println("executing update ps. ");
				 	val=preparedStatement.executeUpdate();
				 	currentCon.commit();
				 	flag=1;
				 	System.out.println("Rows updated in AccountData Table  : - " + val);
			}
			catch(SQLException se){
				try{
					if(currentCon!=null){
						currentCon.rollback();
					}
				}
				catch(SQLException seq){}
				System.out.println("sql Exception occured while executing preparedStatement ");
				se.printStackTrace();
			} 
			catch (Exception e){
					System.out.println("Exception occured while executing preparedStatement ");
					e.printStackTrace();
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
				
			      if (preparedStatement != null) {
						try {
							preparedStatement.close();
						}
						catch (Exception e){
							e.printStackTrace();
						}
					}
			}
		  if (val==0) 
	      {
	         System.out.println("Sorry,Account Creation unsuccessfull !");
	         bean.setAdded(false);
	      } 
		        
	      //if user exists set the isValid variable to true
	      else 
	      {  	
	         System.out.println("Customer Account Successfully Created  " ); //+ firstName);
	         bean.setPopupmsg("Customer Account Successfully Created  " );
	         bean.setAdded(true);
	      } 
		  //return bean;
		
	   }
	   else
	   {
		  // System.out.println(AccountType);
		  // System.out.println(type);
		   System.out.println("Customer does not exist!");
		   System.out.println(" Or Balance should be minimum 5000");
		   System.out.println("Or Customer cannot have more than 5 accounts of "+ AccountType+" type");
		   System.out.println("Please Check!");
		   bean.setAdded(false);
		  // return bean;
	   }
	      
	      if(minbalflag==1)
	    	  bean.setPopupmsg("Minimum balance should be $5000 !");
	      if(typeflag==1)
	    	  bean.setPopupmsg("Customer Already has "+ type + " " + AccountType + "Accounts! ");
	      if(existsflag==1)
	    	  bean.setPopupmsg("Customer does not exist!");
	      if(flag==1)
	    	  bean.setPopupmsg("Account Successfully Added!");
	    return bean;  
	   
	    
	}


	

}
