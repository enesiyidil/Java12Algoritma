/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.ders003;

import java.util.Scanner;

/**
 * Girilen üç sayıyı büyükten küçüğe sıralayan program
 */
public class Problem14 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int userNum1, userNum2, userNum3;
		String sayiSiralama;
		
		System.out.println("1. Sayıyı giriniz.");
		userNum1 = scanner.nextInt();
		System.out.println("2. Sayıyı giriniz.");
		userNum2 = scanner.nextInt();
		System.out.println("3. Sayıyı giriniz.");
		userNum3 = scanner.nextInt();
		
		if(userNum1 >= userNum2 && userNum1 >= userNum3) {
			if(userNum2 >= userNum3) {
				sayiSiralama = userNum1 + " > " +userNum2 + " > " +userNum3;
			}else {
				sayiSiralama = userNum1 + " > " +userNum3 + " > " +userNum2;
			}
		}else if(userNum2 >= userNum1 && userNum2 >= userNum3) {
			if(userNum1 >= userNum3) {
				sayiSiralama = userNum2 + " > " +userNum1 + " > " +userNum3;
			}else {
				sayiSiralama = userNum2 + " > " +userNum3 + " > " +userNum1;
			}
		}else {
			if(userNum2 >= userNum1) {
				sayiSiralama = userNum3 + " > " +userNum2 + " > " +userNum1;
			}else {
				sayiSiralama = userNum3 + " > " +userNum1 + " > " +userNum2;
			}
		}
		System.out.println(sayiSiralama);

	}

}
