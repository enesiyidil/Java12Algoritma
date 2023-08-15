/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.ders002;

import java.util.Scanner;

/**
 * Kullanıcıdan alınan Vize ve Final notuna göre öğrenci geçti mi kaldı mı
 * 
 * Vize %40, Final %60
 */
public class Problem06 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		boolean girilenNotDugruMu = true;
		double ortNotu = 0;
		
		while(girilenNotDugruMu) {
			
			System.out.println("Vize notunu giriniz.");
			double vizeNotu = scanner.nextDouble();
			if(vizeNotu >= 0 && vizeNotu <= 100) {
				
				System.out.println("Final notunu giriniz.");
				double finalNotu = scanner.nextDouble();
				if(finalNotu >= 0 && finalNotu <= 100) {
					
					ortNotu = (vizeNotu * 0.40) + (finalNotu * 0.60);
					if(ortNotu >= 50) {
						System.out.println("Öğrenci geçti. Ortalaması :" + ortNotu);
					}else {
						System.out.println("Öğrenci kaldı. Ortalaması :" + ortNotu);
					}
					girilenNotDugruMu = false;
				}else {
					System.out.println("Final notunu yanlış girdiniz. Girilen not 0 - 100 arası olmalıdır.");
				}
			}else {
				System.out.println("Vize notunu yanlış girdiniz. Girilen not 0 - 100 arası olmalıdır.");
			}
		}
		
	}

}
