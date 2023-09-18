/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.ders008;

import java.util.Arrays;

/**
 * String dizisi içindeki en büyük ve en küçük sayıyı bulma
 */
public class Problem46 {
	
public static void main(String[] args) {
		
		String[] arr = {"100", "8", "7", "5", "99", "85"};
		
		int[] arrInt = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arrInt);
		
		System.out.println("En büyük sayı -> " + arrInt[arrInt.length - 1]);
		System.out.println("En küçük sayı -> " + arrInt[0]);

	}

}
