/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.hafta02.ders007;

import java.util.Arrays;

/**
 * Dizi örnekleri
 */
public class Problem38 {

	public static void main(String[] args) {
		
		String[] ulkeler = new String[] {"Amerika", "Türkiye", "Almanya", "Hollanda", "Yunanistan"};
		
		for(int i = 0; i < ulkeler.length; i++) {
			if(ulkeler[i].charAt(ulkeler[i].length() - 1) == 'a') {//endWith ile daha kolay
				ulkeler[i] = "?";
				System.out.println(i + ". index değişti");
			}
		}
		System.out.println("Ülkeler -> " + Arrays.toString(ulkeler));
		
		System.out.println("******************************************************");
		
		int[] sayilar = { 0, 120, -5, -85, -256, 16, 1258, 81, 14 };
		
		for(int i = 0; i < sayilar.length; i++) {
			if(sayilar[i] < 0) {
				sayilar[i] = 100;
			}
		}
		System.out.println("Sayılar -> " + Arrays.toString(sayilar));
		
		System.out.println("******************************************************");
		
		

	}

}
