package com.Model;

public class CustomerLoginBean {
	private int customerid;
	private String password;
	private String name;
	public boolean valid;
	
	public int getCustomerId() {
		return customerid;
	}
	public void setCustomerId(int newcustomerid) {
		customerid = newcustomerid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String newpassword) {
		password = newpassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String newname) {
		name = newname;
	}
	public void setValid(boolean newValid) {
         valid = newValid;
	}
	public boolean isValid() {
		return valid;
	}	

}
