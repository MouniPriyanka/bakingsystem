package com.cron;

import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;


public class CronSchedularDao {

	
	 
	   static Connection currentCon = null;
	   static ResultSet rs = null;  
		
	   public static void flagReport(String date) {
		   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		   
		      //preparing some objects for connection 
		      Statement stmt = null; 
		      int val=0;
		      FlaggedTransactionBean bean=new FlaggedTransactionBean();
		      List<FlaggedTransactionBean>list = new ArrayList<FlaggedTransactionBean>();
		      
		      
		     
		     System.out.println(date);
			  //List <List <Integer> > result = new ArrayList<>();  
		     String updateQuery,searchQuery = "select * from transactions where  datefield ='"+date+"' and  fromaccount in "
		     		+ "(select fromaccount from transactions where datefield ='"+date+"' group by fromaccount having sum(amount) > 10000)";
		   
		   System.out.println("Query: "+searchQuery);
			    
		   try 
		   {
		      //connect to DB 
		      currentCon = ConnectionManager.getConnection();
		     
		      stmt=currentCon.createStatement();
		      currentCon.setAutoCommit(false);
			  
		      
		      System.out.println("Executing search Query!");
		      rs = stmt.executeQuery(searchQuery);	 
		     // int numcols = rs.getMetaData().getColumnCount();
		      System.out.println("Executed search Query!");
			  
		      while(rs.next()) {
		    	  //arrayList of beans make changes
		    	  System.out.println("in while ");
		    	  bean=new FlaggedTransactionBean();
		    	  		System.out.println(rs.getString("datefield"));
		    	  		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
		    	  		Date d=sdf.parse(rs.getString("datefield"));
		    	  		
		    	  		System.out.println(sdf.format(d));
		    	  		//bean.setDateoftransaction(rs.getString("datefield"));
		    	  		bean.setDateoftransaction(sdf.format(d));
		    	  		bean.setFromaccount(rs.getInt("fromaccount"));
		    	  		bean.setNarration(rs.getString("Narration"));
		    	  		bean.setToaccount(rs.getInt("Toaccount"));
		    	  		bean.setTransid(rs.getInt("Transid"));
		    	  		bean.setType(rs.getString("Type"));
		    	  		bean.setAmount(rs.getInt("Amount"));
		    	  		list.add(bean);
		      } 
		   }

		   catch (Exception ex) 
		   {
			  try {
				currentCon.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      System.out.println("Log In failed11: An Exception has occurred! " + ex);
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
		        	 currentCon.setAutoCommit(true);
		            currentCon.close();
		         } catch (Exception e) {
		         }

		         currentCon = null;
		      }
		   }

		   //insert into database ***********************
		   try 
		   {
		      //connect to DB 
		      currentCon = ConnectionManager.getConnection();
		     
		      stmt=currentCon.createStatement();
		      currentCon.setAutoCommit(false);
			  
		      
		      for(FlaggedTransactionBean fbean : list) {
		    	  
		    	  updateQuery="insert into Flagged_transactions"
		    	  		+ "(transid,dateoftransaction,type,narration,amount,fromaccount,toaccount) "
		    	  		+ "values("
						+  fbean.getTransid() 
						+",TO_DATE('" + fbean.getDateoftransaction() +"','yyyy/MM/dd'),'" +  fbean.getType() +"','" +fbean.getNarration() +"'," + fbean.getAmount() +"," + fbean.getFromaccount() +"," + fbean.getToaccount() + ")";
				  val = stmt.executeUpdate(updateQuery);
				  System.out.println("Rows inserted in flagged transactions table  : - " + val);
		    	  
		      }
		      
		      
		      
			 

		   }

		   catch (Exception ex) 
		   {
			  try {
				currentCon.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      System.out.println("Log In failed22: An Exception has occurred! " + ex);
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
		        	 currentCon.setAutoCommit(true);
		            currentCon.close();
		         } catch (Exception e) {
		         }

		         currentCon = null;
		      }
		   }
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   }
	   
	   //******************FINE ***************************************************************************************
		
		
	   public static void fine() {
		
	      //preparing some objects for connection 
	      Statement stmt = null;    
	      int account_number=0,balance=0,value=0,finecharges=250;
		  List <List <Integer> > result = new ArrayList<>(); 
	     String updateQuery,searchQuery = "select account_number,balance from accountdata where balance<5000";
		// String updateQuery="update account set bal=";
	   
	   System.out.println("Query: "+searchQuery);
		    
	   try 
	   {
	      //connect to DB 
	      currentCon = ConnectionManager.getConnection();
	     
	      stmt=currentCon.createStatement();
	      currentCon.setAutoCommit(false);
		  
		  

	      rs = stmt.executeQuery(searchQuery);	 
	      int numcols = rs.getMetaData().getColumnCount();

		  
	      while(rs.next()) {
	     
				   account_number = rs.getInt("account_number");
				  
				   balance = rs.getInt("balance");
				   System.out.println("account number  : - " + account_number+ " , balance  " + balance);
				   //newbalance=balance-250;

				   List <Integer> row = new ArrayList<>(numcols); // new list per row

					for (int i=1; i<= 2; i++) {  // don't skip the last column, use <=
						
						
						if(i==2){
							System.out.println("second column : balance  = " +rs.getString(i) );
							row.add(Integer.parseInt(rs.getString(i))-finecharges);
							System.out.println("updated balance  = " + (Integer.parseInt(rs.getString(i))-250 ) );
						}
						else
							row.add(Integer.parseInt(rs.getString(i)));
						//System.out.print(rs.getString(i) + "\t");
					}
					result.add(row); // add it to the result
					//System.out.print("\n");
					
			}
				  
			//System.out.println(rs.getRow());
	   } 

	   catch (Exception ex) 
	   {
		  try {
			currentCon.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	        	 currentCon.setAutoCommit(true);
	            currentCon.close();
	         } catch (Exception e) {
	         }

	         currentCon = null;
	      }
	   }

	  /* //create newbalance 
	   System.out.println("NEw balance");
	   for(List<Integer> innerList : result) {
		    for(Integer number : innerList) {
		        System.out.println(number);
		    }
		}*/
	   
	   // update balance
	   /*for(List<Integer> innerList : result) {
		    for(int x=0;x<2;x++) {
		        System.out.print(innerList[x]);
		    }
		} */


	   try 
	   {
	      //connect to DB 
	      currentCon = ConnectionManager.getConnection();
	     
	      stmt=currentCon.createStatement();
	      currentCon.setAutoCommit(false);
		  
		  
	   Iterator<List<Integer>> it = result.iterator();

	    while(it.hasNext())
	        {
	        Iterator<Integer> itr = it.next().iterator();
	        while(itr.hasNext())
	            {
		            //System.out.print(itr.next() + " , " );
	        		account_number=itr.next();
		            while(itr.hasNext())
		            //System.out.println(itr.next());
		            	balance=itr.next();
		            updateQuery="update accountdata set balance="+balance+"where account_number="+account_number;
		            value=stmt.executeUpdate(updateQuery);
					System.out.println("updated  " + value + "rows successfully!" );
		           
	            }
	       
	        
	        }

	   }

	   catch (Exception ex) 
	   {
		  try {
			currentCon.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	        	 currentCon.setAutoCommit(true);
	            currentCon.close();
	         } catch (Exception e) {
	         }

	         currentCon = null;
	      }
	   }
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   }
	
	   
	   
	   public static void interest() {
			
		      //preparing some objects for connection 
		      Statement stmt = null;    
		      Double account_number=0.0,balance=0.0,value=0.0,interestrate=6.0,oldbalance=0.0,newbalance=0.0;
			  List <List <Double> > result = new ArrayList<>(); 
		     String updateQuery,searchQuery = "select account_number,balance from accountdata where balance>=5000";
			// String updateQuery="update account set bal=";
		   
		   System.out.println("Query: "+searchQuery);
			    
		   try 
		   {
		      //connect to DB 
		      currentCon = ConnectionManager.getConnection();
		     
		      stmt=currentCon.createStatement();
		      currentCon.setAutoCommit(false);
			  
			  

		      rs = stmt.executeQuery(searchQuery);	 
		      int numcols = rs.getMetaData().getColumnCount();

			  
		      while(rs.next()) {
		     
					   account_number = rs.getDouble("account_number");
					  
					   balance = rs.getDouble("balance");
					   System.out.println("account number  : - " + account_number+ " , balance  " + balance);
					   //newbalance=balance-250;

					   List <Double> row = new ArrayList<>(numcols); // new list per row

						for (int i=1; i<= 2; i++) {  // don't skip the last column, use <=
							
							
							if(i==2){
								System.out.println("second column : balance  = " +rs.getInt(i) );
								
								oldbalance=(double) (rs.getInt(i));
								System.out.println("old balance  : = "+ oldbalance);
								newbalance=oldbalance+(oldbalance*interestrate*0.01);
								System.out.println("new balance  : = "+newbalance);
								
								row.add((double) newbalance);
								
								//System.out.println("updated balance  = " + ( Integer.parseInt(rs.getString(i))-250 ) );
							}
							else
								row.add((double) Integer.parseInt(rs.getString(i)));
							//System.out.print(rs.getString(i) + "\t");
						}
						result.add(row); // add it to the result
						//System.out.print("\n");
						
				}
					  
				//System.out.println(rs.getRow());
		   } 

		   catch (Exception ex) 
		   {
			  try {
				currentCon.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		        	 currentCon.setAutoCommit(true);
		            currentCon.close();
		         } catch (Exception e) {
		         }

		         currentCon = null;
		      }
		   }

		  /* //create newbalance 
		   System.out.println("NEw balance");
		   for(List<Integer> innerList : result) {
			    for(Integer number : innerList) {
			        System.out.println(number);
			    }
			}*/
		   
		   // update balance
		   /*for(List<Integer> innerList : result) {
			    for(int x=0;x<2;x++) {
			        System.out.print(innerList[x]);
			    }
			} */


		   try 
		   {
		      //connect to DB 
		      currentCon = ConnectionManager.getConnection();
		     
		      stmt=currentCon.createStatement();
		      currentCon.setAutoCommit(false);
			  
			  
		   Iterator<List<Double>> it = result.iterator();

		    while(it.hasNext())
		        {
		        Iterator<Double> itr = it.next().iterator();
		        while(itr.hasNext())
		            {
			            //System.out.print(itr.next() + " , " );
		        		account_number=itr.next();
			            while(itr.hasNext())
			            //System.out.println(itr.next());
			            	balance=itr.next();
			            updateQuery="update accountdata set balance="+balance+"where account_number="+account_number;
			            value=(double) stmt.executeUpdate(updateQuery);
						System.out.println("updated  " + value + "rows successfully!" );
			           
		            }
		       
		        
		        }

		   }

		   catch (Exception ex) 
		   {
			  try {
				currentCon.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		        	 currentCon.setAutoCommit(true);
		            currentCon.close();
		         } catch (Exception e) {
		         }

		         currentCon = null;
		      }
		   }
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   }
		
	
}