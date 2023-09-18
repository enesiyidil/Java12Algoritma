package dersler.ders012;

/**
 * Günlük Faiz Getirisi = (Anapara / 100) x (Faiz Oranı / 365)
 */
public class BankAccount {

	public static final double INTEREST_RATE = 0.05;
	public String accountNumber;
	public double balance;
	
	public double gunlukFaizGetirisi() {
		return (balance / 100) * (INTEREST_RATE / 365);
	}
	public double aylikFaizGetirisi() {
		return (balance / 100) * (INTEREST_RATE / 12);
	}
	public double yillikFaizGetirisi() {
		return (balance / 100) * (INTEREST_RATE);
	}
	@Override
	public String toString() {
		return "BankAccount [interestrate=" + INTEREST_RATE + ", accountNumber=" + accountNumber + ", balance=" + balance
				+ "]";
	}
	
}
