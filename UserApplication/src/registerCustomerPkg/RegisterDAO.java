package registerCustomerPkg;
import java.util.Date;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import userLoginPkg.ConnectionManager;

public class RegisterDAO {
	
	   static Connection currentCon = null;
	   static ResultSet rs = null;  
	    
	   public static RegisterCustomerBean register(RegisterCustomerBean bean) {
		  
		  String Name,Gender,Residence,Email,DOB; //s="pending";
	      int Phone,SSN=0,val1=0,val2=0;
	     
	      String AccountType,BranchCode,OverDraft;
	      int Balance,c_id=0;
	      
	      Statement stmt = null; 
	      PreparedStatement preparedStatement = null;
	      PreparedStatement preparedStatement2 = null;
	      
	      Name= bean.getName();
	      Gender=bean.getGender();
	      Residence=bean.getResidence();
	      Email=bean.getEmail();
	      DOB=bean.getDOB();
	      Phone=bean.getPhone();
	      SSN=bean.getSSN();
	      
	      AccountType=bean.getAccountType();
	      BranchCode=bean.getBranchCode();
	      OverDraft=bean.getOverDraft();
	      Balance=bean.getBalance();
	      
	      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	      Date date = new Date();
	      System.out.println(" date : - " + dateFormat.format(date));	      
	      
	 
			String insertCustomerData = "INSERT INTO Temp_CustomerProfile"
					+ "(CustomerID,Name,Gender,DOB,Residence,SSN,PhoneNumber,Email,Status) VALUES"
					+ "(newseq1.nextval,?,?,?,?,?,?,?,?)";

		   //preparedStatement1
		   try 
			{
		    	currentCon = ConnectionManager.getConnection();
		    	currentCon.setAutoCommit(false);
				preparedStatement = currentCon.prepareStatement(insertCustomerData);
				preparedStatement.setString(1,Name);
				preparedStatement.setString(2, Gender);
				preparedStatement.setString(3,DOB);
				preparedStatement.setString(4,Residence);
				preparedStatement.setInt(5,SSN);
				preparedStatement.setInt(6,Phone);
				preparedStatement.setString(7,Email);
				preparedStatement.setString(8,"pending");
				
				
				// execute insert SQL statement
				 val1=preparedStatement.executeUpdate();
				 System.out.println("Rows updated in Temp_CustomerProfile   : - " + val1);
				 currentCon.commit();
				 
				 
           }
			catch(SQLException se){
				System.out.println("sql Exception caught in preparedStatement 1 !");
				se.printStackTrace();
				try{
					if(currentCon!=null){
						currentCon.rollback();
					}
				}
				catch(SQLException seq){}
				
			}
			catch (Exception e){
							System.out.println("Exception caught in preparedStatement 1 !");
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

			//retrieve value of Customer_ID and store in C_ID 
			try {
				currentCon = ConnectionManager.getConnection();
				currentCon.setAutoCommit(false);
	    	  stmt=currentCon.createStatement();
				rs=stmt.executeQuery("select CustomerID from Temp_CustomerProfile where SSN='"+SSN+"'");
				//currentCon.commit();
				System.out.println("rs-  query executed ");
				
				while(rs.next()){
					c_id=rs.getInt("CustomerID");
				}
				bean.setC_id(c_id);
				System.out.println("c_id  retrieved = " + c_id);
				
			} 
		    catch (SQLException e1) {
		    	try{
					if(currentCon!=null){
						currentCon.rollback();
					}
				}
				catch(SQLException seq){}
				// TODO Auto-generated catch block
				System.out.println(" sql exception in query to retrieve Customer_ID "); 
				e1.printStackTrace();
			}
			catch (Exception e){
				System.out.println(" exception in query to retrieve Customer_ID ");
				e.printStackTrace();
			}
			finally 
	        {
	      		if (rs != null)	{
		         	try {
		            rs.close();
		         	} 
		         	catch (Exception e) 
		         	{}
		            rs = null;
	            }
			    if (stmt != null) {
						try {
							stmt.close();
						}
						catch (Exception e){
							e.printStackTrace();
						}
				}
		
	      		if (currentCon != null) {
			         try {
			        	 currentCon.setAutoCommit(true);
			            currentCon.close();
			         } catch (Exception e) {
			         }

	         		currentCon = null;
	      		}
	      	}


			//preparedStatement2

			/* String insertAccountData = "INSERT INTO Temp_AccountData4"
							+ "(customer_id,account_type,date_opened,branch_code,balance,od,st) VALUES"
							+ "("+c_id+",?,?,?,?,?,?)"; */
			String insertAccountData = "INSERT INTO Temp_AccountData4"
					+ "(customer_id,account_type,date_opened,branch_code,balance,od,st) VALUES"
					+ "("+c_id+",?,TO_DATE('"+dateFormat.format(date)+ "','yyyy/mm/dd'),?,?,?,?)"; 
			try{
					currentCon=ConnectionManager.getConnection();
					preparedStatement2 = currentCon.prepareStatement(insertAccountData);
					
					/* preparedStatement2.setString(1,AccountType);
					preparedStatement2.setString(2,"10-jan-1996");//need to change
					preparedStatement2.setString(3,BranchCode);
					preparedStatement2.setInt(4,Balance);
					preparedStatement2.setString(5,OverDraft);
					preparedStatement2.setString(6,"pending"); */
					
					preparedStatement2.setString(1,AccountType);
					//preparedStatement2.setString(2,"10-jan-1996");//need to change
					preparedStatement2.setString(2,BranchCode);
					preparedStatement2.setInt(3,Balance);
					preparedStatement2.setString(4,OverDraft);
					preparedStatement2.setString(5,"pending");
					currentCon.setAutoCommit(false);
				 	System.out.println("executing update ps2. ");
				 	val2=preparedStatement2.executeUpdate();
				 	currentCon.commit();
				 	System.out.println("Rows updated in Temp_AccountData Table  : - " + val2);
			}
			catch(SQLException se){
				try{
					if(currentCon!=null){
						currentCon.rollback();
					}
				}
				catch(SQLException seq){}
				System.out.println("sql Exception occured while executing preparedStatement2 ");
				se.printStackTrace();
			} 
			catch (Exception e){
					System.out.println("Exception occured while executing preparedStatement2 ");
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
				
			      if (preparedStatement2 != null) {
						try {
							preparedStatement2.close();
						}
						catch (Exception e){
							e.printStackTrace();
						}
					}
			}
		  if (val1==0 || val2==0) 
	      {
	         System.out.println("Sorry,Customer  Registration unsuccessfull !");
	         bean.setRegistered(false);
	      } 
		        
	      //if user exists set the isValid variable to true
	      else 
	      {  	
	         System.out.println("Customer Successfully Registered  " ); //+ firstName);
	         
	         bean.setRegistered(true);
	      } 



	      return bean;
	}

}