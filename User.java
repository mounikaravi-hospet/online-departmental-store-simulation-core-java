package assignment.basics;

public class User {
	private String username;
	private String emailId;
	private String password;
	private int supercoins;
	
	public User(String username, String emailId, String password) {
		super();
		this.username = username;
		this.emailId = emailId;
		this.password = password;
		this.supercoins = 100;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSupercoins() {
		return supercoins;
	}
	public void setSupercoins(int supercoins) {
		this.supercoins = supercoins;
	}	
}
