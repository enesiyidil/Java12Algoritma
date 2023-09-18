/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.ders002;

import java.util.Scanner;

/**
 * Girilen üç sayıdan en büyük olanını veren program
 */
public class Problem10 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int numDegisen, maxNum;
		
		System.out.println("1. Sayıyı giriniz.");
		maxNum = scanner.nextInt();
		
		System.out.println("2. Sayıyı giriniz.");
		numDegisen = scanner.nextInt();
		
		if(numDegisen > maxNum) {
			maxNum = numDegisen;
		}
		System.out.println("3. Sayıyı giriniz.");
		numDegisen = scanner.nextInt();
		
		if(numDegisen > maxNum) {
			maxNum = numDegisen;
		}

		System.out.println("Girilen en büyük sayı : " + maxNum);
		scanner.close(); // scaner nesnesi kapandı
	}

}
