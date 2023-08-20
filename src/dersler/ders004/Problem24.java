/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.ders004;

import java.util.Scanner;

/**
 * Girilen sayı mükemmel sayı mıdır.
 * 
 * 6 --> 1 + 2 + 3 = 6 tam bölenlerinin toplamı kendisine eşitse mükemmel sayıdır
 */
public class Problem24 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Sayı giriniz.");
		int userNum = scanner.nextInt(), tamBolenToplam = 1;
		
		System.out.print(userNum + " sayısının tam bölenleri : 1 + ");
		for(int i = 2; i < userNum; i++) {
			if(userNum%i == 0) {
				tamBolenToplam += i;
				System.out.print(i + (((i * 2) < userNum)? " + " : (" = " + tamBolenToplam)));
			}
		}
		//System.out.print(" = " + tamBolenToplam);
		if(userNum == tamBolenToplam) {
			System.out.println(" --> sayı mükemmel sayıdır.");
		}else {
			System.out.println(" --> sayı mükemmel sayı değildir");
		}

	}

}
