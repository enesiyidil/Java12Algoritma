/**
 * 
 */
package dersler.hafta03.ders012;

import java.util.UUID;

/**
 * 
 */
public class BankAccountTest {

	public static void main(String[] args) {
		
		BankAccount hesap1 = new BankAccount();
		hesap1.accountNumber = UUID.randomUUID().toString();
		hesap1.balance = 10000;
		
		System.out.println(hesap1);
		
		System.out.println(hesap1.gunlukFaizGetirisi());
		System.out.println(hesap1.aylikFaizGetirisi());
		System.out.println(hesap1.yillikFaizGetirisi());

	}

}
