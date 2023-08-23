/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.hafta02.ders008;

import java.util.Arrays;

/**
 * Verilen 2 dizideki tekrar eden sayıları yazdırma
 */
public class Problem45 {
	
public static void main(String[] args) {
		
	int array1[] = { 50, 60, 3, 4, 3, 9, 8 ,7, 45, 95};
    int array2[] = { 1, 2, 50,50, 60, 3, 8, 9, 7,88,95 };
    
    int array1Temp[] = Arrays.copyOf(array1, array1.length);
    Arrays.sort(array1Temp);
    int temp = 0;
    
    for (int i : array1Temp) {
    	if(temp != i) {
    		for (int j : array2) {
    			if(i == j) {
    				System.out.println(i);
    				break;
    			}
    		}
    	}
		temp = i;
	}

	}

}
