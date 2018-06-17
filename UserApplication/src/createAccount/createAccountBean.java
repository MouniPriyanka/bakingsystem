package createAccount;

public class createAccountBean {
	

	private int customerid;
	private int account_number;
	private String account_type;
	private String branch_code;
	private int balance;
	private String overdraft;
	private String status;
	private String popupmsg;
	public String getPopupmsg() {
		return popupmsg;
	}
	public void setPopupmsg(String popupmsg) {
		this.popupmsg = popupmsg;
	}
	private boolean account_added;
	
	public int getCustomerID() {
		return customerid;
	}
	public void setCustomerID(int newcustomerid) {
		customerid = newcustomerid;
	}
	public int getAccountNumber() {
		return account_number;
	}
	public void setAccountNumber(int newAccountNumber) {
		account_number = newAccountNumber;
	}
	public String getAccountType() {
		return account_type;
	}
	public void setAccountType(String newaccount_type) {
		account_type = newaccount_type;
	}
	public String getBranchCode() {
		return branch_code;
	}
	public void setBranchCode(String newbranch_code) {
		branch_code = newbranch_code;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int newbalance) {
		balance = newbalance;
	}
	public String getOverDraft() {
		return overdraft;
	}
	public void setOverDraft(String newoverdraft) {
		overdraft = newoverdraft;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String newstatus) {
		status = newstatus;
	}
	
	public boolean isAdded() {
		return account_added;
	}
	public void setAdded(boolean newaccount_added) {
		account_added = newaccount_added;
	}

}
