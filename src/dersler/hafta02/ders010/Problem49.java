package dersler.hafta02.ders010;

import java.util.Scanner;

/**
 * Asal sayı kontrol eden metot
 */
public class Problem49 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Bir sayı giriniz: ");
		int sayi = scanner.nextInt();scanner.nextLine();
		asalYazdirma(sayi);
		
		scanner.close();

	}
	static boolean asalMi(int num) {
		boolean asalMi = true;
		if(num < 2) {
			asalMi = false;
		}else {
			for(int i = 2; i < num; i++) {
				if(num%i == 0) {
					asalMi = false;
					break;
				}
			}
		}
		return asalMi;
	}
	static void asalYazdirma(int num) {
		for(int i = 1; i < num; i++) {
			boolean asalMi = asalMi(i);
			if(asalMi) {
				System.out.print(i + " ");
			}
		}
	}

}
