package com.cron;

import java.util.TimerTask;

class MyTask extends TimerTask{

	   public MyTask(){
	     //Some stuffs
	   }

	   @Override
	   public void run() {
	     System.out.println("Hi see you after 3 mins");
	     CronSchedularDao.fine();
	     CronSchedularDao.interest();

	   }

	}