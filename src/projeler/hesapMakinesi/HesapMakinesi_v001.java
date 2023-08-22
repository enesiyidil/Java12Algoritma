/**
 * 
 */
package projeler.hesapMakinesi;

import java.util.Scanner;

/**
 * Sıralı işlem yapan hesap makinesi
 */
public class HesapMakinesi_v001 {

	static double hesap(char islemTuru, double sayi1, int sayi2) {
		return switch (islemTuru) {
		case '+' -> {
			yield sayi1 + sayi2;
		}case '-' -> {
			yield sayi1 - sayi2;
		}case '*' -> {
			yield sayi1 * sayi2;
		}case '/' -> {
			yield sayi1 / sayi2;
		}
		default -> 0;
		};
	}
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String[] operators = new String[] {"-","\\+","/","\\*"};
		String operatorRegex = String.join("|", operators);
		/*
		 * Bir regex deseni, özel karakterler (meta karakterler) ve normal karakterlerin 
		 * kombinasyonlarından oluşur. Bu özel karakterler, desenin davranışını belirler.
		 */
		System.out.println("İşlemi giriniz ( * / - + ).");
		String islem = scanner.next();
		
		String[] sayilar = islem.split(operatorRegex);
		char[] islemler = islem.replaceAll("[0-9]", "").toCharArray();
		
		double sonuc = Integer.parseInt(sayilar[0]);
		int sayiIndex = 1;
		
		for(char i: islemler) {
			sonuc = hesap(i, sonuc, Integer.parseInt(sayilar[sayiIndex]));
			sayiIndex++;
		}
		System.out.println(islem + " = " + sonuc);
		scanner.close(); // scaner nesnesi kapandı
	}

}
