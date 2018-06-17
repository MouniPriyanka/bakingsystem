package com.cron;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

public class Main{
	   public static void main(String[] args){
		   
		   Date y=new Date(System.currentTimeMillis()-1000L*60L*60L*24L);
		   SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
		   
		   
		   // The function fine() when called deducts fine from account which have balance less than minimum balance
		   CronSchedularDao.fine(); 
		   
		   
		   //the function interest when called updates balance and adds interest
		   //to accounts having balance more than specified minimum limit
		   CronSchedularDao.interest();
		 
		   
		   
		   //the function flagreport when called takes all the transactions of account 
		   //whose aggregated transfered amount on one day is more than threshold limit ($10,000)
		   //it is to be executed everyday at midnight to flag and reports suspicious transactions taken place the day before;
		   CronSchedularDao.flagReport(sdf.format(y));  

		 /*   
	     Timer fineinterest = new Timer();
	     MyTask mTask = new MyTask();
	     fineinterest.scheduleAtFixedRate(mTask, 0,180000 ); 
		 
		 Timer flagReport = new Timer();
		 MyTask2 mTask2 = new MyTask2();
		 flagReport.scheduleAtFixedRate(mTask, 0,180000);
		 */
		  
	}
		
}
