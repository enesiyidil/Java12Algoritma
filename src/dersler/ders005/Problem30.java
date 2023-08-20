/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.ders005;

import java.util.Scanner;

/**
 * Girilen kelimenin harflerini alt alta yazan program
 */
public class Problem30 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Bir kelime giriniz.");
		String userKelime =scanner.next();
		
		for(int i = 0; i < userKelime.length(); i++) {
			System.out.println(userKelime.charAt(i));
		}

	}

}
