package dersler.ders019;

import java.util.Random;
import java.util.Scanner;

public class OyunMenusu {

	static Scanner scanner = new Scanner(System.in);
	static Random rnd = new Random();
	
	public static void menu() {

		PlakaTahmin plakaTahmin = new PlakaTahmin();
		
		int secim;

		do {
			menuYazdir(plakaTahmin.getOyunSayisi());
			System.out.print("Seçiminiz: ");
			secim = scanner.nextInt();
			scanner.nextLine();

			switch (secim) {
			case 1:
				plakaTahmin.tahminEt();
				break;
			case 2:
				plakaTahmin.tahminlerim();
				break;
			case 0:
				System.out.println("Çıkış yapılıyor...");
				break;

			default:
				System.out.println("Hatalı seçim!");
				break;
			}
		} while (secim != 0);
	}

	private static void menuYazdir(int i) {
		System.out.println(i + ". Oyun");
		System.out.println("Şehir Tahmin Oyununa Hoşgeldiniz");
		System.out.println("Oyunumuzda Toplam 3 Hakkınız Bulunmaktadır");
		System.out.println("1- Oyuna Başla");
		System.out.println("2- Tahminlerim");
		System.out.println("0- Çıkış");
	}
}
