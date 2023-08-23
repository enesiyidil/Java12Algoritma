/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.hafta01.ders003;

import java.util.Scanner;

/**
 * Girilen iki sayının toplamının tek mi çift mi olma durumuna göre true veya false veren program
 */
public class Problem12 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1. Sayıyı giriniz.");
		int userNum = scanner.nextInt(), toplam = userNum;
		System.out.println("2. Sayıyı giriniz.");
		userNum = scanner.nextInt();
		toplam += userNum;
		
		if(toplam%2 == 0) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
		scanner.close(); // scaner nesnesi kapandı
	}

}
