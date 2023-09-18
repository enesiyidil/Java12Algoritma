package dersler.ders015;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Custumer extends User {

	private String id;
	private String tc;
	private double balance;
	private ELevel level;
	private List<Book> rentedBooks;

	public Custumer() {
		super();
		this.level = ELevel.SILVER;
		this.rentedBooks = new ArrayList<Book>();
	}

	public Custumer(String userName, String password, String tc, double balance) {
		super(userName, password);
		this.id = UUID.randomUUID().toString();
		this.tc = tc;
		this.balance = balance;
		this.level = ELevel.SILVER;
		this.rentedBooks = new ArrayList<Book>();
	}

	public String getId() {
		return id;
	}

	public String getTc() {
		return tc;
	}

	public void setTc(String tc) {
		this.tc = tc;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public ELevel getLevel() {
		return level;
	}

	public void setLevel(ELevel level) {
		this.level = level;
	}

	public List<Book> getRentedBooks() {
		return rentedBooks;
	}

	public void setRentedBooks(List<Book> rentedBooks) {
		this.rentedBooks = rentedBooks;
	}

}
