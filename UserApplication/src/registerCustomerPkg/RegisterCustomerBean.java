package registerCustomerPkg;

public class RegisterCustomerBean {
	private String Name;
	private String Gender;
	private String Residence;
	private String Email;
	private String DOB;
	private int Phone;
	private int SSN;
	private boolean registered;
	private String AccountType;
	private String Status;
	private String  OverDraft;
	private String BranchCode;
	private int Balance;
	private int C_id;
	

	public int getC_id() {
		return C_id;
	}
	public void setC_id(int C_id) {
		this.C_id = C_id;
	}
	public int getBalance() {
		return Balance;
	}
	public void setBalance(int balance) {
		Balance = balance;
	}
	public String getAccountType() {
		return AccountType;
	}
	public void setAccountType(String accountType) {
		AccountType = accountType;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getOverDraft() {
		return OverDraft;
	}
	public void setOverDraft(String overDraft) {
		OverDraft = overDraft;
	}
	public String getBranchCode() {
		return BranchCode;
	}
	public void setBranchCode(String branchCode) {
		BranchCode = branchCode;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getResidence() {
		return Residence;
	}
	public void setResidence(String residence) {
		Residence = residence;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public int getPhone() {
		return Phone;
	}
	public void setPhone(int phone) {
		Phone = phone;
	}
	public int getSSN() {
		return SSN;
	}
	public void setSSN(int sSN) {
		SSN = sSN;
	}
    public boolean isRegistered() {
        return registered;
	}

     public void setRegistered(boolean newregistered) {
    	 registered = newregistered;
	}

	

}
