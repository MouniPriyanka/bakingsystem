package com.Model;

public class RegisterCustomerBean {
	private int customerid;
	private String password;
	private boolean registered;
	public void setCustomerId(int newcustomerid)
	{
		customerid=newcustomerid;
	}
	public int getCustomerId()
	{
		return customerid;
	}
	public void setPassword(String newPassword)
	{
		password=newPassword;
	}
	public String getPassword()
	{
		return password;
	}
	
	public boolean isRegistered()
	{
		return registered;
	}
	public void setRegistered(boolean newregistered)
	{
		registered=newregistered;		
	}
	
	
}
