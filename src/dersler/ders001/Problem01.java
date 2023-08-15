/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.ders001;

import java.util.Scanner;

/**
 * Kullanıcıdan 'isim' ve 'soyisim' verileri alınacak
 * Ekrana 'Hoşgeldin isim soyisim' olarak yazılacak
 * 
 * @author enesb
 */
public class Problem01 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String isim = "", soyIsim = "";
		
		System.out.println("İsminizi giriniz:");
		isim = scanner.next();
		System.out.println("Soyisminizi giriniz:");
		soyIsim = scanner.next();
		
		System.out.println("Hoşgeldiniz " + isim + " " + soyIsim);
	}

}
