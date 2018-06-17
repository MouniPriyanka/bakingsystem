package com.Model;

public class FundsTransfer {
	private String fromaccountno;
    private String toaccountno;
    private String amount;
    public boolean valid;
    public String getfromaccountno() {
       return fromaccountno;
			}

    public void setfromaccountno(String newfromaccountno) {
       fromaccountno= newfromaccountno;
			}
    
    public String gettoaccountno() {
        return toaccountno;
 			}
     public void settoaccountno(String newtoaccountno) {
        toaccountno= newtoaccountno;
 			}	
     public String getamount() {
	        return amount;
	 			}
	     public void setamount(String newamount) {
	        amount= newamount;
	 			}	
	      public boolean isValid() {
	          return valid;
	 	}

	       public void setValid(boolean newValid) {
	          valid = newValid;}


}
