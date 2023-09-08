package dersler.hafta04.ders014;

import java.util.ArrayList;
import java.util.List;

public class User {

	private String name;
	private String surname;
	private String email;
	private Account account;
	private List<Mail> gelenKutusu;
	
	public User(String name, String surname) {
		super();
		this.email = UserManager.generateEmail(name, surname);
		this.gelenKutusu = new ArrayList<Mail>();
		this.name = name;
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Mail> getGelenKutusu() {
		return gelenKutusu;
	}

	public void setGelenKutusu(List<Mail> gelenKutusu) {
		this.gelenKutusu = gelenKutusu;
	}
	
}
