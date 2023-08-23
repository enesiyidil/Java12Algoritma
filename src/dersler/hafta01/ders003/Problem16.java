/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.hafta01.ders003;

import java.util.Scanner;

/**
 * Girilen günün hafta içi mi hafta sonu mu olduğunu gösteren program
 */
public class Problem16 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int userGun = scanner.nextInt();
		
		String durum = switch (userGun) {
		case 1, 2, 3, 4, 5 -> {
			yield "Hafta içi";
		}case 6, 7 -> {
			yield "Hafta sonu";
		}
		default -> "Yanlış gün girişi";
		};
		System.out.println(durum);
		scanner.close(); // scaner nesnesi kapandı
	}

}
