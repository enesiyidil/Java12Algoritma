/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.hafta01.ders005;

import java.util.Scanner;

/**
 * Girilen kelimenin içerisindeki istenilen karakter sayısını veren program
 */
public class Problem32 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Bir kelime giriniz.");
		String userKelime = scanner.next().toLowerCase();
		System.out.println("Sayısını bulmak istediğiniz karakter");
		String userKarakter = scanner.next().toLowerCase();
		int eSayisi = 0;
		
		for(int i = 0; i < userKelime.length(); i++) {
			if(userKelime.charAt(i) == userKarakter.charAt(0)) {
				eSayisi++;
			}
		}
		System.out.println("'" + userKelime + "' ifadesinin içerisinde '" + userKarakter + "' sayısı -> " + eSayisi);
		scanner.close(); // scaner nesnesi kapandı
	}

}
