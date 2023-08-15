/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.ders002;

import java.util.Scanner;

/**
 * Verilen iki sayıdan hangisinin büyük olduğunu bulan program 
 */
public class Problem04 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int num1, num2;
		
		System.out.println("Bir sayı giriniz :");
		num1 = scanner.nextInt();
		System.out.println("Bir sayı giriniz :");
		num2 = scanner.nextInt();
		
		if(num1 > num2) {
			System.out.println("Büyük olan sayı : " + num1);
		}
		else if(num1 == num2) {
			System.out.println("Girilen sayılar eşittir : " + num1);
		}
		else {
			System.out.println("Büyük olan sayı : " + num2);
		}

	}

}
