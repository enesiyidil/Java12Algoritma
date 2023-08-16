/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.ders003;

import java.util.Scanner;

/**
 * Girilen sayının basamak değerlerini veren program
 */
public class Problem20 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Sayı giriniz");
		int sayi = scanner.nextInt(), basamakDegeri = 1;
		
		while(sayi != 0) {
			System.out.println(basamakDegeri + " basamağı : " + (sayi % 10));
			sayi /= 10;
			basamakDegeri *= 10;
		}

	}

}
