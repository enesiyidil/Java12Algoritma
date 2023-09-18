package dersler.ders014;

/*
 * Banka uygulaması
 * 
 * Account 	=> accountNo, money
 * 			=> paraYatir(), paraCek()
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {

		User user1 = new User("Enes", "İYİDİL");
		Account account1 = new Account();
		user1.setAccount(account1);
		account1.setMoney(12000);

		System.out.println("Email =>\t" + user1.getEmail());
		System.out.println("Hesap bakiyesi =>\t" + account1.getMoney());

		System.out.println("--------------------------------------------------");

		UserManager maneger1 = new UserManager();
		maneger1.krediBasvurusundaBulun(account1, 10000);
		System.out.println("Hesap bakiyesi =>\t" + account1.getMoney());

		AdminManeger adminManager = new AdminManeger();
		adminManager.basvuruOnayla(user1);
		System.out.println("Hesap bakiyesi =>\t" + account1.getMoney());

		System.out.println("--------------------------------------------------");

		maneger1.krediBorcOde(account1, 1000, true);
		maneger1.krediBorcOde(account1, 1000, false);
		System.out.println("Kredi borcu =>\t" + account1.getKrediBorcu());
		System.out.println("Kredi puanı =>\t" + account1.getKrediPuani());
		System.out.println("Hesap bakiyesi =>\t" + account1.getMoney());
		
		System.out.println("--------------------------------------------------");
		
		System.out.println(user1.getGelenKutusu());
	}

}
