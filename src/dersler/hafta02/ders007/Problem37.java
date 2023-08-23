/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.hafta02.ders007;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Sayı tahmin uygulaması
 * Tahmin küçükse arttır, büyükse azalt
 * Tahmin doğru ise kaçıncı denemede bulduğunu yazsın
 */
public class Problem37 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		int rndNum = random.nextInt(1, 101);
		int tahmin, sayac = 0;
		String tahminler = "";
		
		System.out.print("(Hak -> 5) Tahmininizi giriniz : ");
		while(true) {
			if(sayac == 5) {
				System.out.println("Hakkınız tükendi! Sayı -> " + rndNum);
				break;
			}
			tahmin = scanner.nextInt();
			tahminler += tahmin + ",";
			sayac++;
			if(tahmin < rndNum && sayac < 5) {
				System.out.print("(Hak -> " + (5 - sayac) + ") Daha yüksek bir sayı giriniz : ");
			}else if(tahmin > rndNum && sayac < 5) {
				System.out.print("(Hak -> " + (5 - sayac) + ") Daha küçük bir sayı giriniz : ");
			}else if(tahmin == rndNum) {
				System.out.println("Tebrikler! " + sayac + " denemede buldunuz.");
				break;
			}
		}
		int[] tahminlerInt = Arrays.stream(tahminler.substring(0, tahminler.length() - 1).split(",")).mapToInt(Integer::parseInt).toArray();
		System.out.println("Tahminleriniz -> " + Arrays.toString(tahminlerInt));
		scanner.close();
	}

}
