/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.hafta02.ders006;

import java.util.Scanner;

/**
 * Kullanıcı mail girişi yapan program
 * 
 */
public class Problem34 {

	static int stringCharCounter(String text, char character) {
        int coun = 0;
        for (char c : text.toCharArray()) {
            if (c == character) {
            	coun++;
            }
        }
        return coun;
    }
	
	static boolean containsChar(String text) {
		boolean isContain = true;
		char[] ch = new char[] {'ı', 'ş', 'ü', 'ç', 'ö', 'ğ', ',', '!', '%', '&', '=', '?'};
		text = text.toLowerCase();
		for(char chTemp : ch) {
			if(text.indexOf(chTemp) != -1) {
				isContain = false;
			}
		}
		return isContain;
	}
	
	static boolean isMailCorret(String userMail) {
		boolean isCorret = false;
		int atNum = stringCharCounter(userMail, '@');
		
		if(atNum == 1 && containsChar(userMail.split("@")[0])) {
			if(userMail.indexOf("@outlook.com") == userMail.length() - 12 || userMail.indexOf("@hotmail.com") == userMail.length() - 12) {
				isCorret = true;
			}
		}
		return isCorret;
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String userMail = "";
		String userPass1 = "", userPass2 = "";
		boolean isMailCorr = true, isPassCorr = true;
		
		while(isMailCorr) {
			System.out.println("Mailinizi giriniz: ");
			userMail = scanner.next().toLowerCase();
			if(isMailCorret(userMail)) {
				isMailCorr = false;
			}else {
				System.out.println("\u001B[31m" + "Hatalı mail girişi!" + "\u001B[0m");
			}
		}
		while(isPassCorr) {
			System.out.println("Şifre giriniz: ");
			userPass1 = scanner.next();
			if(userPass1.length() >= 8) {
				System.out.println("Şifreyi tekrar giriniz: ");
				userPass2 = scanner.next();
				if(userPass1.equals(userPass2)) {
					isPassCorr = false;
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
		scanner.close(); // scaner nesnesi kapandı
	}

}
