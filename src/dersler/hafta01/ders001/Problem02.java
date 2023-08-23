/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.hafta01.ders001;

import java.util.Scanner;

/**
 * Kullanıcıdan 2(int) sayı alınacaktır
 * Ekrana iki sayının çarpımı yazılacak
 * 
 * @author enesb
 */
public class Problem02 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int num1, num2, carpim;
		
		System.out.println("Sayı biri giriniz:");
		num1 = scanner.nextInt();
		System.out.println("Sayı ikiyi giriniz:");
		num2 = scanner.nextInt();
		
		carpim = num1 * num2;
		System.out.println("Sonuc = " + carpim);
		scanner.close(); // scaner nesnesi kapandı

	}
	
}
