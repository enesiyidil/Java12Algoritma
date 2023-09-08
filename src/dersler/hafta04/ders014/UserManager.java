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

	public void krediBorcOde(Account account, int miktar, boolean isCash) {
		if (account.getKrediBorcu() > 0 && miktar <= account.getKrediBorcu()) {
			if (!isCash) {
				if (miktar > account.getMoney()) {
					System.out.println("Hesap bakiyesi yetersiz.");
					return;
				}
				account.setMoney(account.getMoney() - miktar);
			}
			account.setKrediBorcu(account.getKrediBorcu() - miktar);
			account.setKrediPuani(account.getKrediPuani() + Account.KREDI_PUANI_ARTIS_MIKTARI);
			System.out.println("Kredi ödemesi gerçekleşti. Kalan borç: " + account.getKrediBorcu()
					+ ", güncel kredi puanı: " + account.getKrediPuani());
		} else {
			System.out.println((account.getKrediBorcu() > 0) ? "Kredi borcundan çok ödeme yapılamaz."
					: "Kredi borcunuz bulunmamaktadır.");
		}
	}
}
