package dersler.hafta04.ders014;

import java.util.Random;

public class Account {

	private String accountNo;
	private double money;
	private boolean krediBasvurusu;
	private int krediMiktari;

	public Account() {
		this(0);
	}

	public Account(double money) {
		super();
		this.accountNo = generateAccountNo();
		this.money = money;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public boolean isKrediBasvurusu() {
		return krediBasvurusu;
	}

	public void setKrediBasvurusu(boolean krediBasvurusu) {
		this.krediBasvurusu = krediBasvurusu;
	}

	public int getKrediMiktari() {
		return krediMiktari;
	}

	public void setKrediMiktari(int krediMiktari) {
		this.krediMiktari = krediMiktari;
	}

	private String generateAccountNo() {
		Random rnd = new Random();
		return rnd.nextInt(1000, 10001) + "";
	}	
}
