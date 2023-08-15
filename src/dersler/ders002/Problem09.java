/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.ders002;

import java.util.Scanner;

/**
 * Girilen ortalamanın harf notuna göre geçip geçmediğini bulan program
 * 
 * 90 üstü AA
 * 80 ve 90 arası BB
 * 70 ve 80 arası CC
 * 60 ve 70 arası DD
 * 60 dan daha azı FF
 */
public class Problem09 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Öğrenci ortalamasını giriniz.");
		double ortalama = scanner.nextDouble();
		String harfNotu = "", gecmeDurumu = "";
		
		if(ortalama >= 0 && ortalama <= 100) {
			if(ortalama >= 90) {
				harfNotu = "AA";
				gecmeDurumu = "geçti";
			}else if(ortalama >= 80) {
				harfNotu = "BB";
				gecmeDurumu = "geçti";
			}else if(ortalama >= 70) {
				harfNotu = "CC";
				gecmeDurumu = "geçti";
			}else if(ortalama >= 60) {
				harfNotu = "DD";
				gecmeDurumu = "şartlı geçti";
			}else {
				harfNotu = "FF";
				gecmeDurumu = "kaldı";
			}
			System.out.println("Öğrenci " + ortalama + " ile " + gecmeDurumu + ". Harf notu : " + harfNotu);
		}else {
			System.out.println("Hatalı değer girdiniz");
		}

	}

}
