package eligibilityCheckpkg;

public class EligibilityBean {

	private String ssn;
	public boolean eligible;
    public String getssn() {
        return ssn;
	}

     public void setssn(String newssn) {
        ssn = newssn;
	}
     
     
     public boolean isEligible() {
         return eligible;
	}

      public void setEligible(boolean newEligible) {
         eligible = newEligible;
	}	
}


