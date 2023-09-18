package dersler.ders015;

public class Admin extends User{

	private String email;

	public Admin(String userName, String password, String email) {
		super(userName, password);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
