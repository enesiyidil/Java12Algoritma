package dersler.ders015;

import java.time.LocalDateTime;

public class User {

	private String userName;
	private String password;
	private LocalDateTime signDate;
	
	public User() {
		this.signDate = LocalDateTime.now();
	}

	public User(String userName, String password) {
		this();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getSignDate() {
		return signDate;
	}

	public void setSignDate(LocalDateTime signDate) {
		this.signDate = signDate;
	}
	
}
