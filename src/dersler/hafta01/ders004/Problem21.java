/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.hafta01.ders004;

import java.util.Scanner;

/**
 * Girilen sayı asal mı
 */
public class Problem21 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Sayı giriniz.");
		int userNum = scanner.nextInt();
		boolean asalMı = true;
		
		if(userNum < 2) {
			asalMı = false;
		}else {
			for(int i = 2; i < userNum; i++) {
				if(userNum%i == 0) {
					asalMı = false;
					break;
				}
			}
		}
		
		if(asalMı) {
			System.out.println("Girilen sayı asaldır");
		}else {
			System.out.println("Girilen sayı asal değildir.");
		}
		scanner.close(); // scaner nesnesi kapandı
	}

}
