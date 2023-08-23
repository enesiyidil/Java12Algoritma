/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.hafta01.ders003;

import java.util.Scanner;

/**
 * Girilen sayı 5'in kuvveti mi
 */
public class Problem18 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Sayı giriniz");
		int sayi = scanner.nextInt();
		String besinKatiMi = "5'in kuvveti değil";
		
		while(sayi != 1) {
			if(sayi%5 != 0) {
				besinKatiMi = "5'in kuvveti değil";
				sayi = 1;
			}else {
				besinKatiMi = "5'in kuvveti";
				sayi /= 5;
			}
		}
		System.out.println(besinKatiMi);
		scanner.close(); // scaner nesnesi kapandı
	}

}
