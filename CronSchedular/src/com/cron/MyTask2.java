package com.cron;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

class MyTask2 extends TimerTask{

	   public MyTask2(){
	     //Some stuffs
	   }

	   @Override
	   public void run() {
		   Date y=new Date(System.currentTimeMillis()-1000L*60L*60L*24L);
		   SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
		   CronSchedularDao.flagReport(sdf.format(y));

	   }

	}