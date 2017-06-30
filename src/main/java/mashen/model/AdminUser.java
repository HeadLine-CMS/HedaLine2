package mashen.model;

public class AdminUser {
	private String name;
	private String account;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
