/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.hafta01.ders002;

import java.util.Scanner;

/**
 * Kenarları verilen üçgenin ne çeşit bir üçgen olduğunu söyleyen program
 */
public class Problem08 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int kenar1, kenar2, kenar3;
		
		System.out.println("Üçgenin 1. kenarının uzunluğunu giriniz.");
		kenar1 = scanner.nextInt();
		System.out.println("Üçgenin 2. kenarının uzunluğunu giriniz.");
		kenar2 = scanner.nextInt();
		System.out.println("Üçgenin 3. kenarının uzunluğunu giriniz.");
		kenar3 = scanner.nextInt();
		
		if(kenar1 > 0 && kenar2 > 0 && kenar3 > 0) {
			if(kenar1 == kenar2 && kenar1 == kenar3){
				System.out.println("Eşkenar üçkendir");
			}else if(kenar1 == kenar2 || kenar1 == kenar3 || kenar2 == kenar3) {
				System.out.println("İkizkenar üçgendir");
			}else {
				System.out.println("Çeşitkenar üçgendir");
			}
		}else {
			System.out.println("Kenarlardan bir veya daha fazlasını negatif girdiniz");
		}
		scanner.close(); // scaner nesnesi kapandı
	}

}
