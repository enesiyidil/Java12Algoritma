/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.ders004;

import java.util.Scanner;

/**
 * Girilen 0-100 arası 5 sayının en büyüğü ve en küçüğünü veren program
 */
public class Problem26 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int maxSayi = Integer.MIN_VALUE, minSayi = Integer.MAX_VALUE;
		
		System.out.println("Integer max : " + Integer.MAX_VALUE); // int max değerini verir
		System.out.println("Integer min : " + Integer.MIN_VALUE); // int min değerini verir
		
		System.out.println("0-100 arası 5 sayı girilecek");
		for(int i = 1; i < 6; i++) {
			System.out.println(i + ". Sayıyı giriniz");
			int userNum = scanner.nextInt();
			if(userNum >= 0 && userNum <= 100) {
				if(userNum > maxSayi) {
					maxSayi = userNum;
				}
				if(userNum < minSayi) {
					minSayi = userNum;
				}
			}else {
				System.err.println("Hatalı sayı girişi");
				i--;
			}
		}
		System.out.println("Girilen sayıların en büyüğü -> " + maxSayi + ", en küçüğü -> " + minSayi);

	}
	
}
