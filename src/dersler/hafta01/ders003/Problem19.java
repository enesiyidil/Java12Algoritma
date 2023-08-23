/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.hafta01.ders003;

import java.util.Scanner;

/**
 * Girilen sayıya kadar olan tek sayıların toplamını veren program
 */
public class Problem19 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Sayı giriniz");
		int sayi = scanner.nextInt(), sayac = 1, toplam = 0;
		
		while(sayi > sayac) {
			if(sayac%2 != 0) {
				toplam += sayac;
				if(sayac == 1) {
					System.out.print(sayac);
				}else {
					System.out.print(" + " + sayac);
				}
			}
			sayac++;
		}
		System.out.println(" = " + toplam);
		scanner.close(); // scaner nesnesi kapandı
	}

}
