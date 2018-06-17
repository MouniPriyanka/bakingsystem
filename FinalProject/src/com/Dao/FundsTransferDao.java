package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Dao.FundsTransferDao.UnsufficientFundException;
import com.Model.Account;
import com.Model.Beneficiary;
public class FundsTransferDao {
	static Connection currentCon = null;
	static Connection currentCon1 = null;
	    static ResultSet rs = null;  
		 public static List<Beneficiary> showAll(String cid) {
		    	Statement stmt = null; 
		    	List<Beneficiary> beneficiaryList = new ArrayList<Beneficiary>();
		    	Beneficiary beneficiary = new Beneficiary();
		        String searchQuery = "select nickname from beneficiary where cid="+cid;
		 	     System.out.println("Query: "+searchQuery);
		 	    
		     try 
		     {
		     	 System.out.println("entered try");
		  	    
		        currentCon = DBHelper.getConnection();
		        System.out.println("entered conn");
		 	    
		        stmt=currentCon.createStatement();
		        rs = stmt.executeQuery(searchQuery);	        
		         while(rs.next()) {
		        	  String nickname  = rs.getString("nickname");
		        	  beneficiary = new Beneficiary();
		        	 beneficiary.setNickName(nickname);
		        	 beneficiaryList.add(beneficiary);
		        	/*String benname  = rs.getString("beneficiaryname");
		            String accountnumber = rs.getString("accountnumber");
		          
		            String branchcode = rs.getString("branchcode");
		            String bank = rs.getString("bank");
		            beneficiary = new Beneficiary();
		            beneficiary.setBeneficiaryName(benname);
		            beneficiary.setAccountNumber(accountnumber);
		            
		            beneficiary.setBranchCode(branchcode);
		            beneficiary.setBankName(bank);
		             beneficiaryList.add(beneficiary)
		             System.out.print("bename: " + benname);
		            System.out.print(", accountnumber: " + accountnumber);
		             System.out.println(", branchcode " + branchcode);
		            System.out.println(", bank " + bank);*/

		            //Display values
		            
		            System.out.print(", nickname: " + nickname);
		           
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

		 return beneficiaryList;
		 	
		     }	
		 public static List<Account> showAllAccounts(String cid) {
		    	Statement stmt = null; 
		    	List<Account> accountsList = new ArrayList<Account>();
		    	Account account = new Account();
		    	
		    	 String searchQuery = "select account_number from accountdata where customer_id="+cid;
		 	     System.out.println("Query: "+searchQuery);
		 	    
		     try 
		     {
		     	 System.out.println("entered try");
		  	    
		        currentCon = DbHelperS.getConnection();
		        System.out.println("entered conn");
		 	    
		        stmt=currentCon.createStatement();
		        rs = stmt.executeQuery(searchQuery);	        
		         while(rs.next()) {
		        	  account = new Account();
		        	 int accountnumber = rs.getInt("account_number");
		        	 // String nickname  = rs.getString("nickname");
		        	  account.setAccountNumber(accountnumber);
		        	  accountsList.add(account);
		        	  System.out.print(", accountnumber: " + accountnumber);

		            //Display values
		            
		            //System.out.print(", nickname: " + nickname);
		           
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
		 public int transaction(String from, String to, int amount) throws ClassNotFoundException,
	     UnsufficientFundException, SQLException{
			 
			 Connection conn1=null;
			 Connection conn2=null;
			 
			int stat = 0;
			 PreparedStatement preparedStatement = null;
			 PreparedStatement preparedStatement1 = null;
			 PreparedStatement preparedStatement2 = null;
			 PreparedStatement preparedStatement3 = null;
			 PreparedStatement preparedStatement4 = null;
			 
			 System.out.println("your account number " + from);          
			 System.out.println("amount is" + amount);
			 try 
			    {
				 
				 System.out.println("entered try");
			    conn1 = DbHelperS.getConnection();
			    conn2 = DBHelper.getConnection();
			    conn1.setAutoCommit(false);
			    conn2.setAutoCommit(false);
			    String querySelect ="select balance from accountdata where account_number=?";
			    preparedStatement = conn1.prepareStatement(querySelect);
			    preparedStatement.setString(1, from);
			    System.out.println(querySelect);
			     rs= preparedStatement.executeQuery();
			    rs.next();
			    System.out.println("query executed");
			    int balance1 = rs.getInt("balance") - amount;
			    System.out.println(balance1);
		         if (balance1 < 0)
		            throw new UnsufficientFundException("Unsufficient Fund.");
		      
		         rs.close();
		         String withdrawl="update accountdata set balance=? "+" where account_number=?";
		         preparedStatement1= conn1.prepareStatement(withdrawl);
		         preparedStatement1.setInt(1,balance1);
		         preparedStatement1.setString(2,from);
		        System.out.println("query"+ withdrawl);
		         preparedStatement1.executeUpdate();
		         String queryBenAccountnumber="select accountnumber from beneficiary where nickname=?";
		         preparedStatement4= conn2.prepareStatement(queryBenAccountnumber);
		         System.out.println(queryBenAccountnumber);
		         preparedStatement4.setString(1,to);
			     rs= preparedStatement4.executeQuery();
			      rs.next();
			      System.out.println("query executed");
			      String accountnumber=rs.getString("accountnumber");
				  String querySelect1 ="select balance from accountdata where account_number=?";
		          preparedStatement2= conn1.prepareStatement(querySelect1);
				    preparedStatement2.setString(1,accountnumber);
				    System.out.println("query executed1");
				     rs= preparedStatement2.executeQuery();
				    rs.next();
				    int balance2 = rs.getInt("balance") + amount;
				    System.out.println(balance2);
			        
			         String deposit="update accountdata set balance=?"+" where account_number=?";
			         System.out.println("query executed1");
			          preparedStatement3 = conn1.prepareStatement(deposit);
		              preparedStatement3.setInt(1,balance2);
			          preparedStatement3.setString(2,accountnumber);
			         int i= preparedStatement3.executeUpdate();
			         if(i>0) {
			         stat=insertTransaction(amount,from,accountnumber);
			        	
			         }
			            System.out.println(conn1);
		          conn1.commit();
		          
		          
		          rs.close();
		          return stat;
			        
			    }
		          catch(SQLException ex){
		        	  conn1.rollback();
		              throw ex;
		           }finally{
		              if (rs!= null)
		            	  rs.close();
		              if (preparedStatement != null)
		            	  preparedStatement.close();

		           }		             
			 
			
			 

	}
		 public boolean minAmount(String from, String to, int amount) throws SQLException {
				// TODO Auto-generated method stub
				 PreparedStatement preparedStatement = null;
				
				 try{
				 System.out.println("entered try");
				    currentCon = DbHelperS.getConnection();
				     currentCon.setAutoCommit(false);
				    
				    String querySelect ="select balance from accountdata where account_number=?";
				    preparedStatement = currentCon.prepareStatement(querySelect);
				    preparedStatement.setString(1, from);
				    System.out.println(querySelect);
				     rs= preparedStatement.executeQuery();
				    rs.next();
				    System.out.println("query executed");
				    currentCon.commit();
				    int balance1 = rs.getInt("balance") - amount;
				    System.out.println(balance1);
				    if(balance1<5000){
	                    return true;
				    }
				    return false;
				    

				 }
				 catch(SQLException ex){
		        	  currentCon.rollback();
		              throw ex;
		           }finally{
		              if (rs!= null)
		            	  rs.close();
		              if (preparedStatement != null)
		            	  preparedStatement.close();

		           }		             
				
			
	}
		 class UnsufficientFundException extends Exception {
		      private static final long serialVersionUID = 1L;

		      public UnsufficientFundException(String message) {
		         super(message);
		      }
		   }
		 public  int insertTransaction(int amount,String from,String to) {
				//preparing some objects for connection 
			 Statement stmt = null; 	
			    	
			    	int i=0;
				// "System.out.println" prints in the console; Normally used to trace the process
			    try 
			    {System.out.println("entered try");
			 	//connect to DB
			      currentCon = DBHelperV.getConnection();
			       System.out.println("entered conn");
			       String query ="insert into transactions values(transid.nextval,CURRENT_DATE,'withdraw','account transfer',"
				            +amount
				            +","
				            +from
				            +","
				            +to
			        		+")";  
			       
			        stmt=currentCon.createStatement(); //Making use of prepared statements here to insert bunch of data
			      
			       System.out.println("Query: "+query);
			       i=stmt.executeUpdate(query);
			       return i;
			     }
			      catch (Exception ex) 
			    {
			       System.out.println("Log In failed: An Exception has occurred! " + ex);
			       ex.printStackTrace();
			    } 
				    //some exception handling
			    finally 
			    {
				
			       if (stmt != null) {
			          try {
			        	  stmt.close();
			          } catch (Exception e) {e.printStackTrace();}
			          stmt = null;
			          
			          }
				
			       if (currentCon != null) {
			          try {
			             currentCon.close();
			          } catch (Exception e) {
			        	  e.printStackTrace();
			          }

			          currentCon = null;
			       }
			    }
				return i;
			}	

	}


