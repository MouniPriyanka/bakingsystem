package com.Model;

public class ForgotPasswordBean {

	private int customerid;
	private String password;
	private boolean updated;
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
	
	public boolean isUpdated()
	{
		return updated;
	}
	public void setUpdated(boolean newupdated)
	{
		updated=newupdated;		
	}
	
}
