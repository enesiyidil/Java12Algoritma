/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.ders004;

import java.util.Scanner;

/**
 * Hesap Makinesi
 */
public class Problem27 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("İşlem türünü giriniz ( * / - + ).");
		String ıslemTuru = scanner.next();
		
		System.out.println("1. Sayıyı giriniz");
		int userNum1 = scanner.nextInt();
		System.out.println("2. Sayıyı giriniz");
		int userNum2 = scanner.nextInt();
		
		double sonuc = switch (ıslemTuru) {
		case "+" -> {
			yield userNum1 + userNum2;
		}case "-" -> {
			yield userNum1 - userNum2;
		}case "*" -> {
			yield userNum1 * userNum2;
		}case "/" -> {
			yield userNum1 / userNum2;
		}
		default -> 0;
		};
		System.out.println(userNum1 + " " + ıslemTuru + " " + userNum2 + " = " + sonuc);
		scanner.close(); // scaner nesnesi kapandı
	}

}
