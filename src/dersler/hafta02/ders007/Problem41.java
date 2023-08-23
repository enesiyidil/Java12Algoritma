/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.hafta02.ders007;

import java.util.Arrays;

/**
 * Dizideki en büyük ikinci sayıyı bulalım
 */
public class Problem41 {

	public static void main(String[] args) {
		
		int[] sayilar = { 0, 120, -5, -85, -256, 16, 1258, 81, 14, 16, 1258};
		
		int max = Integer.MIN_VALUE, max2 = 0;
		
		for(int i : sayilar) {
			if(max < i) {
				max2 = max;
				max = i;
			}else if(max2 < i && i != max) {
				max2 = i;
			}
		}
		System.out.println(max2);
		
		for(int i = 0; i < sayilar.length; i++) {
			int min = sayilar[i];
			int index = -1;
			for(int j = i + 1; j < sayilar.length; j++) {
				if(sayilar[j] < min) {
					min = sayilar[j];
					index = j;
				}
			}
			if(index > -1) {
				sayilar[index] = sayilar[i];
				sayilar[i] = min;
			}	
		}
		System.out.println(Arrays.toString(sayilar));

	}

}
