package dersler.hafta02.ders010;

import java.util.Scanner;

/**
 * Login() metodu ile email giriş sistemi yapıldı
 */
public class Problem51 {

	public static void main(String[] args) {
		
		login();
		
	}
	static void login() {
		Scanner scanner = new Scanner(System.in);
		String userMail = "";
		String userPass = "";
		boolean isMailCorr = true, isPassCorr = true;

		while(isPassCorr) {
			if(isMailCorr) {
				userMail = getEmail(scanner);
				if(!(userMail.equals("hata"))) {
					isMailCorr = false;
				}
			}else {
				userPass = getPassword(scanner);
				if(!(userPass.equals("hata"))) {
					isPassCorr = false;
				}
			}
		}
		
		System.out.println("\u001B[32m" + "Sisteme giriş yaptınız." + "\u001B[0m");
		System.out.println("Kullanıcı	: " + "\u001B[36m" + userMail + "\u001B[0m");
		System.out.println("Şifre		: " + "\u001B[36m" + userPass + "\u001B[0m");
		
		scanner.close();
	}
	
	static String getEmail(Scanner scanner) {
		String userMail = "";
		
		System.out.println("Mailinizi giriniz: ");
		userMail = scanner.next().toLowerCase();
		if(emailCheck(userMail)) {
			return userMail;
		}else {
			System.out.println("\u001B[31m" + "Hatalı mail girişi!" + "\u001B[0m");
		}
		return "hata";
	}
	
	static String getPassword(Scanner scanner) {
		String userPass1 = "", userPass2 = "";
		
		System.out.println("Şifre giriniz: ");
		userPass1 = scanner.next();
		System.out.println("Şifreyi tekrar giriniz: ");
		userPass2 = scanner.next();
		
		if(passwordCheck(userPass1, userPass2))
			return userPass1;
		else
			System.out.println("\u001B[31m" + "Şifreler uyuşmuyor ya da 8 haneden küçük!" + "\u001B[0m");
		
		return "hata";
	}
	
	static boolean emailCheck(String userMail) {
		boolean isCorret = false;
		int atNum = stringCharCounter(userMail, '@');
		
		if(atNum == 1 && containsIncorrectChar(userMail.split("@")[0])) {
			if(userMail.indexOf("@outlook.com") == userMail.length() - 12 || userMail.indexOf("@hotmail.com") == userMail.length() - 12) {
				isCorret = true;
			}
		}
		return isCorret;
	}
	
	static boolean passwordCheck(String userPass1, String userPass2) {
		if(userPass1.length() >= 8 && userPass1.equals(userPass2)) {
			return true;
		}else {
			return false;
		}
	}
	
	static boolean containsIncorrectChar(String text) {
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
	
	static int stringCharCounter(String text, char character) {
        int coun = 0;
        for (char c : text.toCharArray()) {
            if (c == character) {
            	coun++;
            }
        }
        return coun;
    }

}
