/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.hafta01.ders002;

import java.util.Scanner;

/**
 * Girilen TL cinsinden parayı USD cinsine çevirme
 */
public class Problem05 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		double tl, usd, usdKuru = 27.05;
		
		System.out.println("TL cinsinden para miktarını giriniz :");
		tl = scanner.nextDouble();
		
		usd = tl / usdKuru;
		System.out.println("USD karşılığı : " + usd);
		scanner.close(); // scaner nesnesi kapandı
		
	}

}
