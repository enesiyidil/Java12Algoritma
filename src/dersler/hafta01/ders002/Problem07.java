/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.hafta01.ders002;

import java.util.Scanner;

/**
 * Girilen sayı tek mi çift mi
 */
public class Problem07 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Sayı giriniz");
		int num = scanner.nextInt();
		if(num%2 == 0) {
			System.out.println("Sayı çift");
		}else {
			System.out.println("Sayı tek");
		}
		
		scanner.close(); // scaner nesnesi kapandı
	}

}
