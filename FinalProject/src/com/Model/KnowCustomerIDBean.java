package com.Model;

public class KnowCustomerIDBean {
	private int customer_id;
	private int account_number;
	public void setCustomerId(int newcustomerid)
	{
		customer_id=newcustomerid;
	}
	public int getCustomerId()
	{
		return customer_id;
	}
	public void setAccountNumber(int newaccountnumber)
	{
		account_number=newaccountnumber;
	}
	public int getAccountNumber()
	{
		return account_number;
	}
}
