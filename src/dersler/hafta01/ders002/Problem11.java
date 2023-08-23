/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.hafta01.ders002;

import java.util.Scanner;

/**
 * Yarı çapı verilen dairenin alanı ve çevresini hesaplayan program
 */
public class Problem11 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		final double pi = 3.14;
		double yariCap, daireninCevresi, daireninAlani;
		
		System.out.println("Dairenin yarı çapını giriniz.");
		yariCap = scanner.nextDouble();
		
		if(yariCap > 0) {
			daireninAlani = pi * yariCap * yariCap;
			daireninCevresi = 2 * pi * yariCap;
			
			System.out.println("Dairenin çevresi : " +daireninCevresi + "\nDairenin alanı : " +daireninAlani);
		}else {
			System.out.println("Hatalı yarı çap değeri girdiniz.");
		}
		scanner.close(); // scaner nesnesi kapandı
	}

}
