package pojo;

public class AccountInfo {
	String AccountId;
	String Password;
	String IphoneNumber;
	String AccountName;
	String AccountStatus;
	String StatusName;
	String AccountPicture;

	public AccountInfo(String AccountId, String Password, String IphoneNumber, String AccountName, String AccountStatus,
			String AccountPicture) {
		this.AccountId = AccountId;
		this.Password = Password;
		this.IphoneNumber = IphoneNumber;
		this.AccountName = AccountName;
		this.AccountStatus = AccountStatus;
		this.AccountPicture = AccountPicture;
	}

	public AccountInfo(String AccountId, String AccountName, String IphoneNumber, String StatusName) {
		this.AccountId = AccountId;
		this.IphoneNumber = IphoneNumber;
		this.AccountName = AccountName;
		this.StatusName = StatusName;
	}

	public AccountInfo(String AccountId, String Password) {
		this.AccountId = AccountId;
		this.Password = Password;
	}

	public AccountInfo(String AccountId, String Password, String IphoneNumber) {
		this.AccountId = AccountId;
		this.Password = Password;
		this.IphoneNumber = IphoneNumber;
	}

	public AccountInfo() {

	}

	public String getAccountPicture() {
		return AccountPicture;
	}

	public void setAccountPicture(String accountPicture) {
		AccountPicture = accountPicture;
	}

	public String getStatusName() {
		return StatusName;
	}

	public void setStatusName(String statusName) {
		StatusName = statusName;
	}

	public String getAccountStatus() {
		return AccountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		AccountStatus = accountStatus;
	}

	public String getAccountId() {
		return AccountId;
	}

	public void setAccountId(String accountId) {
		AccountId = accountId;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getIphoneNumber() {
		return IphoneNumber;
	}

	public void setIphoneNumber(String iphoneNumber) {
		IphoneNumber = iphoneNumber;
	}

	public String getAccountName() {
		return AccountName;
	}

	public void setAccountName(String accountName) {
		AccountName = accountName;
	}

}
