/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.hafta02.ders008;

import java.util.Arrays;

/**
 * 3x3 lük matris oluştur içine şunu yazdır
 * 
 * 1 1 1
 * 2 2 2
 * 3 3 3
 */
public class Problem43 {
	
public static void main(String[] args) {
		
		int[][] num = new int[3][3];
		
		for(int i = 0; i < num.length; i++) {
			for(int j = 0; j < num[i].length; j++) {
				num[i][j] = i + 1;
			}
		}
		for (int[] i : num) {
			System.out.println(Arrays.toString(i));
		}
	}

}
