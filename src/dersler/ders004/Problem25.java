/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.ders004;

import java.util.Scanner;

/**
 * üs alma
 */
public class Problem25 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int usSonuc = 1;
		for(int i = 1; i <= 5; i++) {
			usSonuc *= 2;
		}
		System.out.println("2^5 = " + usSonuc);
		
		System.out.println("************************************************************");
		
		System.out.println("Taban değerini giriniz.");
		int tabanDegeri = scanner.nextInt();
		System.out.println("Üs değerini giriniz.");
		int usDegeri = scanner.nextInt();
		
		usSonuc = 1;
		for(int i = 1; i <= usDegeri; i++) {
			usSonuc *= tabanDegeri;
		}
		System.out.println(tabanDegeri + "^" + usDegeri + " = " + usSonuc);
		scanner.close(); // scaner nesnesi kapandı
	}
	
}
