package dersler.hafta04.ders014;

public class AdminManeger {

	public void basvuruOnayla(Account account) {
		if (account.isKrediBasvurusu()) {
			System.out.println("Kredi başvurusu onaylanmıştır.");
			
			account.setMoney(account.getMoney() + account.getKrediMiktari());
			account.setKrediMiktari(0);
			account.setKrediBasvurusu(false);
		}else {
			System.out.println("Kredi başvurusu bulunmamaktadır.");
		}
	}
	public void basvuruReddet(Account account) {
		if (account.isKrediBasvurusu()) {
			System.out.println("Kredi başvurusu reddedilmiştir.");

			account.setKrediMiktari(0);
			account.setKrediBasvurusu(false);
		}else {
			System.out.println("Kredi başvurusu bulunmamaktadır.");
		}
	}
}
