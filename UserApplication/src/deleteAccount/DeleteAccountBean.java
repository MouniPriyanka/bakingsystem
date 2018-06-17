package deleteAccount;

public class DeleteAccountBean {
	private int account_number;
	private int customer_id;
	private String popup;
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	private boolean account_closed;
	
	public int getAccountNumber() {
		return account_number;
	}
	public void setAccountNumber(int newAccountNumber) {
		account_number = newAccountNumber;
	}
	public boolean isClosed() {
		return account_closed;
	}
	public void setClosed(boolean newaccount_closed) {
		account_closed = newaccount_closed;
	}
	public String getpopup()
	{
		return popup;
	}
	public void setpopup(String newpopup) {
		popup = newpopup;
	}
}
