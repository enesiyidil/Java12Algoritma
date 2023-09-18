package dersler.ders014;

public class AdminManeger {

	public void basvuruOnayla(User user) throws InterruptedException {
		if (user.getAccount().isKrediBasvurusu()) {
			System.out.println("Kredi başvurusu onaylanmıştır.");
			
			user.getAccount().setMoney(user.getAccount().getMoney() + user.getAccount().getKrediMiktari());
			user.getAccount().setKrediBorcu(user.getAccount().getKrediMiktari());
			user.getAccount().setKrediMiktari(0);
			user.getAccount().setKrediBasvurusu(false);
			mailGonder(user, "Kredi başvurusu onaylanmıştır.");
		}else {
			System.out.println("Kredi başvurusu bulunmamaktadır.");
		}
	}
	public void basvuruReddet(User user) throws InterruptedException {
		if (user.getAccount().isKrediBasvurusu()) {
			System.out.println("Kredi başvurusu reddedilmiştir.");

			user.getAccount().setKrediMiktari(0);
			user.getAccount().setKrediBasvurusu(false);
			mailGonder(user, "Kredi başvurusu reddedilmiştir.");
		}else {
			System.out.println("Kredi başvurusu bulunmamaktadır.");
		}
	}
	
	public void mailGonder(User user, String icerik) throws InterruptedException {
		Mail mail = new Mail();
		mail.setBaslik("Kredi Durumu");
		mail.setIcerik(icerik);
		Thread.sleep(5000);
		user.getGelenKutusu().add(mail);
	}
}
