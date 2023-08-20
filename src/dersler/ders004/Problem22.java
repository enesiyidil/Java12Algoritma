/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.ders004;

import java.util.Scanner;

/**
 * Girilen sayının çarpım tablosunu veren program
 */
public class Problem22 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Sayı giriniz.");
		int userNum = scanner.nextInt(), carpim;
		
		for(int i = 1; i <= 10; i++) {
			carpim = i * userNum;
			System.out.println(userNum + " x " + i + " = " + carpim);
		}
		
		System.out.println("************************************************************");
		
		// Tüm çarpım tablosu
		for(int i = 1; i <= 10; i++) {
			String deger="";
			for(int j = 1; j <= 10; j++) {
				carpim = i * j;
				deger += i + " x " + j + " = " + carpim + "\t";
			}
			System.out.println(deger);
		}

	}

}
