/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.ders005;

import java.util.Scanner;

/**
 * Kullanıcı mail girişi yapan program
 * 
 * ANSI_RESET = "\u001B[0m"
 * ANSI_BLACK = "\u001B[30m"
 * ANSI_RED = "\u001B[31m"
 * ANSI_GREEN = "\u001B[32m"
 * ANSI_YELLOW = "\u001B[33m"
 * ANSI_BLUE = "\u001B[34m"
 * ANSI_PURPLE = "\u001B[35m"
 * ANSI_CYAN = "\u001B[36m"
 * ANSI_WHITE = "\u001B[37m"
 */
public class Problem33 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String userMail = "";
		String userPass1 = "", userPass2 = "";
		boolean mailDogruMu = true, passwordDogruMu = true;
		
		while(mailDogruMu) {
			System.out.println("Mailinizi giriniz: ");
			userMail = scanner.next().toLowerCase();
			if(userMail.indexOf("@outlook.com") == userMail.length() - 12 || userMail.indexOf("@hotmail.com") == userMail.length() - 12) {
				mailDogruMu = false;
			}else {
				System.out.println("\u001B[31m" + "Hatalı mail girişi!" + "\u001B[0m");
			}
		}
		while(passwordDogruMu) {
			System.out.println("Şifre giriniz: ");
			userPass1 = scanner.next();
			if(userPass1.length() >= 8) {
				System.out.println("Şifreyi tekrar giriniz: ");
				userPass2 = scanner.next();
				if(userPass1.equals(userPass2)) {
					passwordDogruMu = false;
				}else {
					System.out.println("\u001B[31m" + "Şifreler uyuşmuyor!" + "\u001B[0m");
				}
			}else {
				System.out.println("\u001B[31m" + "Girilen şifre 8 karakter veya daha fazla olmalı!" + "\u001B[0m");
			}
		}
		
		System.out.println("\u001B[32m" + "Sisteme giriş yaptınız." + "\u001B[0m");
		System.out.println("Kullanıcı	: " + "\u001B[36m" + userMail + "\u001B[0m");
		System.out.println("Şifre		: " + "\u001B[36m" + userPass1 + "\u001B[0m");

	}

}
