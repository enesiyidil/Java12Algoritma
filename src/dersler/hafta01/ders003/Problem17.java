/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.hafta01.ders003;

import java.util.Scanner;

/**
 * Girilen sayının basamakları toplamını veren program
 */
public class Problem17 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Sayı giriniz");
		int sayi = scanner.nextInt(), toplam = 0;
		
		while(sayi != 0) {
			toplam += sayi % 10;
			sayi /= 10;
		}
		System.out.println("Girilen sayının basamakları toplamı : " + toplam);
		scanner.close(); // scaner nesnesi kapandı
	}

}
