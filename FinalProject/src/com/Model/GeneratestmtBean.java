package com.Model;

public class GeneratestmtBean {
    private String fromdate;
    private String todate;
    private String date;
    private String narration;
    private String checkno;
    private String type;
    private String amount;
    private String lasttrans;
    private String accountno;
    private String toaccount;
    public boolean valid;
    public String getfromdate() {
       return fromdate;
			}

    public void setfromdate(String newfromdate) {
       fromdate= newfromdate;
			}
    
    public String gettodate() {
        return todate;
 			}

     public void settodate(String newtodate) {
        todate= newtodate;
 			}	
     public String getdate() {
         return date;
  			}

      public void setdate(String newdate) {
         date= newdate;
  			}	
 	      

	      public String getnarration() {
	         return narration;
		}

	      public void setnarration(String newnarration) {
	        narration = newnarration;
	      }
	      public String getcheckno() {
	          return checkno;
	   			}

	       public void setcheckno(String newcheckno) {
	         checkno= newcheckno;
	   			}
	       public String gettype() {
	           return type;
	    			}

	        public void settype(String newtype) {
	           type= newtype;
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

		public void setlasttrans(String newlasttrans) {
		 lasttrans = newlasttrans;
			
		}
		public String getlasttrans() {
			return lasttrans;
			
		}

		public String getAccountno() {
			return accountno;
		}

		public void setAccountno(String newaccountno) {
			accountno = newaccountno;
		}

		public String getToaccount() {
			return toaccount;
		}

		public void setToaccount(String newtoaccount) {
			toaccount = newtoaccount;
		}

}
