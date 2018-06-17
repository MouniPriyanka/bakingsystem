package com.Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Model.Beneficiary;
import com.Model.User;
import com.Dao.DBHelper;
public class BeneficiaryDao {
	static Connection currentCon = null;
    static ResultSet rs = null;  
    static int i;
	 public  int add(Beneficiary beneficiary) {
	//preparing some objects for connection 
    	PreparedStatement preparedStatement = null;
    	String name=beneficiary.getBeneficiaryName();
    	String accountnumber= beneficiary.getAccountNumber();
    	String nickname=beneficiary.getNickName();
    	String branchcode=beneficiary.getBranchCode();	
    	String cid=beneficiary.getCid();
    	//String bank=beneficiary.getBankName();
    	// "System.out.println" prints in the console; Normally used to trace the process
    System.out.println("Your name  is " + name);          
    System.out.println("Your account number  is " + accountnumber);
    System.out.println("Your beneficiary nick name is " + nickname);
    System.out.println("Your branch code  is " +branchcode);
    //System.out.println("Your bank is  " + bank);
    try 
    {System.out.println("entered try");
 	//connect to DB
      currentCon = DBHelper.getConnection();
       System.out.println("entered conn");
       String query ="insert into beneficiary(beneficiaryname,accountnumber,nickname,branchcode,bank,cid) values (?,?,?,?,'INFINTY',?)"; 
       
       preparedStatement = currentCon.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
       preparedStatement.setString(1,name );
       preparedStatement.setString(2, accountnumber);
       preparedStatement.setString(3, nickname);
       preparedStatement.setString(4, branchcode);
       preparedStatement.setString(5, cid);
      // preparedStatement.setString(5, bank);
       System.out.println("Query: "+query);
       i= preparedStatement.executeUpdate();
     }
      catch (Exception ex) 
    {
       System.out.println("Log In failed: An Exception has occurred! " + ex);
       ex.printStackTrace();
    } 
	    //some exception handling
    finally 
    {
	
       if (preparedStatement != null) {
          try {
        	  preparedStatement.close();
          } catch (Exception e) {e.printStackTrace();}
          preparedStatement = null;
          
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
	 public static List<Beneficiary> showAll(String cid) {
	    	Statement stmt = null; 
	    	List<Beneficiary> beneficiaryList = new ArrayList<Beneficiary>();
	    	Beneficiary beneficiary = new Beneficiary();
	        String searchQuery = "select * from beneficiary where cid="+cid;
	 	     System.out.println("Query: "+searchQuery);
	 	    
	     try 
	     {
	     	 System.out.println("entered try");
	  	    
	        currentCon = DBHelper.getConnection();
	        System.out.println("entered conn");
	 	    
	        stmt=currentCon.createStatement();
	        rs = stmt.executeQuery(searchQuery);	        
	         while(rs.next()) {
	        	String benname  = rs.getString("beneficiaryname");
	            String accountnumber = rs.getString("accountnumber");
	            String nickname  = rs.getString("nickname");
	            String branchcode = rs.getString("branchcode");
	            String bank = rs.getString("bank");
	            beneficiary = new Beneficiary();
	            beneficiary.setBeneficiaryName(benname);
	            beneficiary.setAccountNumber(accountnumber);
	            beneficiary.setNickName(nickname);
	            beneficiary.setBranchCode(branchcode);
	            beneficiary.setBankName(bank);
	            beneficiary.setCid(cid);
	             beneficiaryList.add(beneficiary);

	            //Display values
	            System.out.print("bename: " + benname);
	            System.out.print(", accountnumber: " + accountnumber);
	            System.out.print(", nickname: " + nickname);
	            System.out.println(", branchcode " + branchcode);
	            System.out.println(", bank " + bank);
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
	
	/* public  int delete(Beneficiary beneficiary) {
			//preparing some objects for connection 
		    	PreparedStatement preparedStatement = null;
			String accountnumber = beneficiary.getAccountNumber();    
		       String ifsc = beneficiary.getIfsc(); 
		       String benname=beneficiary.getBeneficiary();
		       String mobileno=beneficiary.getMobileNO();
		       String email=beneficiary.getEmail();
		// "System.out.println" prints in the console; Normally used to trace the process
		    System.out.println("Your account number  is " + accountnumber);          
		    System.out.println("Your ifsc is " + ifsc);
		    System.out.println("Your beneficiary name is " + benname);
		    System.out.println("Your mobile no is " + mobileno);
		    System.out.println("Your email " + email);
		    try 
		    {System.out.println("entered try");
		 	//connect to DB
		      currentCon = DBHelper.getConnection();
		       System.out.println("entered conn");
		       String query ="insert into beneficiary(accountnumber,ifsc,beneficiaryname,mobileno,email) values (?,?,?,?,?)"; 
		       System.out.println("Query: "+query);
		       preparedStatement = currentCon.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
		       preparedStatement.setString(1, accountnumber);
		       preparedStatement.setString(2, ifsc);
		       preparedStatement.setString(3, benname);
		       preparedStatement.setString(4, mobileno);
		       preparedStatement.setString(5, email);
		       i= preparedStatement.executeUpdate();
		     }
		      catch (Exception ex) 
		    {
		       System.out.println("Log In failed: An Exception has occurred! " + ex);
		       ex.printStackTrace();
		    } 
			    //some exception handling
		    finally 
		    {
			
		       if (preparedStatement != null) {
		          try {
		        	  preparedStatement.close();
		          } catch (Exception e) {e.printStackTrace();}
		          preparedStatement = null;
		          
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
		}	*/
  public  int find(String nickname,String cid) {
			//PreparedStatement preparedStatement = null;
		 
	   
  	  // List<Beneficiary> beneficiaryList = new ArrayList<Beneficiary>();
  	//  Beneficiary beneficiary = new Beneficiary();
			Statement stmt= null;
			String Query = "select accountnumber from beneficiary where nickname like '"+nickname+"'and cid='"+cid+"'";
			 try 
			    {System.out.println("entered try");
			    System.out.println(nickname);
			 	//connect to DB
			      currentCon = DBHelper.getConnection();
			       System.out.println("entered conn");
			       System.out.println("Query: "+Query);
			       ///preparedStatement = currentCon.prepareStatement(Query);
			      stmt = currentCon.createStatement();
			       //preparedStatement.setString(1,firstname);
			     //stmt.setString(1,firstname);//Making use of prepared statements here to insert bunch of data
			      // i= preparedStatement.executeUpdate();
			      rs=stmt.executeQuery(Query);
			      if(rs.next()) {
			        	return 1;
			            /*String accountnumber = rs.getString("accountnumber");
			            beneficiaryList.add(beneficiary);
			            System.out.print(", accountnumber: " + accountnumber);*/
			     } else {
			    	 return 0;
			     }
			    }
			 catch (Exception ex) 
			    {
			       System.out.println("Log In failed: An Exception has occurred! " + ex);
			       ex.printStackTrace();
			    } 
			 finally 
			    {
				
			      /* if (preparedStatement != null) {
			          try {
			        	  preparedStatement.close();
			          } catch (Exception e) {e.printStackTrace();}
			          preparedStatement = null; */
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
	 public static int delete(String nickname,String cid) {
			//PreparedStatement preparedStatement = null;
		 
		  
			Statement stmt= null;
			String Query = "delete from beneficiary where nickname like '"+nickname+"'and cid='"+cid+"'";
			 try 
			    {System.out.println("entered try");
			    System.out.println(nickname);
			 	//connect to DB
			      currentCon = DBHelper.getConnection();
			       System.out.println("entered conn");
			       System.out.println("Query: "+Query);
			       ///preparedStatement = currentCon.prepareStatement(Query);
			      stmt = currentCon.createStatement();
			       //preparedStatement.setString(1,firstname);
			     //stmt.setString(1,firstname);//Making use of prepared statements here to insert bunch of data
			      // i= preparedStatement.executeUpdate();
			       i= stmt.executeUpdate(Query);
			     }
			 catch (Exception ex) 
			    {
			       System.out.println("Log In failed: An Exception has occurred! " + ex);
			       ex.printStackTrace();
			    } 
			 finally 
			    {
				
			      /* if (preparedStatement != null) {
			          try {
			        	  preparedStatement.close();
			          } catch (Exception e) {e.printStackTrace();}
			          preparedStatement = null; */
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
