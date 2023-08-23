/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.hafta01.ders003;

import java.util.Scanner;

/**
 * Mail ve telefon kod doğrulaması yapan program
 */
public class Problem13 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String mailKodu = "M036896", telefonKodu = "T936523";
		String userMailKodu, userTelefonKodu, mesaj;
		
		System.out.println("Lütfen mailinize gelen 7 haneli kodu giriniz.");
		userMailKodu = scanner.next();
		System.out.println("Lütfen telefonunuza gelen 7 haneli kodu giriniz.");
		userTelefonKodu = scanner.next();
		
		if(userMailKodu.equals(mailKodu) && userTelefonKodu.equals(telefonKodu)) {
			mesaj = "Sisteme kayıt oldunuz";
		}else if(userMailKodu.equals(mailKodu)) {
			mesaj = "Telefon kodunuz yanlış";
		}else if(userTelefonKodu.equals(telefonKodu)) {
			mesaj = "Mail kodunuz yanlış";
		}else {
			mesaj = "Girilen kodların her ikisi de yanlış";
		}
		System.out.println(mesaj);
		scanner.close(); // scaner nesnesi kapandı
	}

}
