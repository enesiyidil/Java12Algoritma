/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.hafta01.ders001;

import java.util.Scanner;

/**
 * Verilen ürün satış fiyatının ham fiyatını bulunuz.
 * Satış fiyatı %18 kdv ve %15 kar oranlarını içermektedir.
 */
public class Problem03 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		double vergiOrani = 1.18, karOrani = 1.15;
		int fiyat;
		double hamFiyat;
		
		System.out.println("Ürün fiyatını giriniz.");
		fiyat = scanner.nextInt();
		
		hamFiyat = fiyat / (vergiOrani * karOrani);
		System.out.println("Verilen ürün fiyatının ham fiyatı = " + hamFiyat);
		scanner.close(); // scaner nesnesi kapandı

	}

}
