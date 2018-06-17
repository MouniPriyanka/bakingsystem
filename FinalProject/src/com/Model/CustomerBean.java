package com.Model;

public class CustomerBean {

	      private String customerid;
	      private String oldpassword;
	      private String newpassword;
	      public boolean valid;
	      public String getCustomerId() {
	         return customerid;
				}

	      public void setCustomerId(String newcustomerid) {
	         customerid= newcustomerid;
				}
	      public String getoldpassword() {
		         return oldpassword;
					}

		      public void setoldpassword(String newoldpassword) {
		         oldpassword = newoldpassword;
					}
					
		      

		      public String getnewPassword() {
		         return newpassword;
			}

		      public void setnewPassword(String newnewPassword) {
		        newpassword = newnewPassword;
		      }
		      public boolean isValid() {
		          return valid;
		 	}

		       public void setValid(boolean newValid) {
		          valid = newValid;}
}
