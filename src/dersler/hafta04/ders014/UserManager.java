package dersler.hafta04.ders014;

public class UserManager {

	public static String generateEmail(String name, String surname) {
		return name.toLowerCase() + "." + surname.toLowerCase() + "@banka.com";
	}

	public void krediBasvurusundaBulun(Account account, int miktar) {
		account.setKrediBasvurusu(true);
		account.setKrediMiktari(miktar);
		System.out.println(miktar + " Değerinde kredi başvurusu alındı. Onay beklemede!");
	}
}
