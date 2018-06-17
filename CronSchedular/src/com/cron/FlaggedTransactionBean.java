package com.cron;

public class FlaggedTransactionBean {
	private int transid;
	private String dateoftransaction; 
	private String type;
	private String narration;
	private int fromaccount;
	private int toaccount;
	private int amount;
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getTransid() {
		return transid;
	}
	public void setTransid(int transid) {
		this.transid = transid;
	}
	public String getDateoftransaction() {
		return dateoftransaction;
	}
	public void setDateoftransaction(String dateoftransaction) {
		this.dateoftransaction = dateoftransaction;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNarration() {
		return narration;
	}
	public void setNarration(String narration) {
		this.narration = narration;
	}
	public int getFromaccount() {
		return fromaccount;
	}
	public void setFromaccount(int fromaccount) {
		this.fromaccount = fromaccount;
	}
	public int getToaccount() {
		return toaccount;
	}
	public void setToaccount(int toaccount) {
		this.toaccount = toaccount;
	}

	

}
