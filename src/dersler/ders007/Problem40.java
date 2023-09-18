/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.ders007;

import java.util.Arrays;

/**
 * Dizi içerisindeki eksi sayıları yeni bir diziye atalım
 */
public class Problem40 {

	public static void main(String[] args) {
		
		int[] sayilar = { 0, 120, -5, -85, -256, 16, 1258, 81, 14 };
		String sayilarText = "";
		
		for(int i : sayilar) {
			if(i < 0) {
				sayilarText += i + ",";
			}
		}
		
		int[] sayilarEksi = Arrays.stream(sayilarText.substring(0, sayilarText.length() - 1).split(",")).mapToInt(Integer::parseInt).toArray();
		System.out.println("sayilarEksi -> " + Arrays.toString(sayilarEksi));

	}

}
