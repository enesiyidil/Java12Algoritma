package dersler.hafta04.ders014;

/*
 * Banka uygulaması
 * 
 * Account 	=> accountNo, money
 * 			=> paraYatir(), paraCek()
 */
public class Main {

	public static void main(String[] args) {

		User user1 = new User("Enes", "İYİDİL");
		Account account1 = new Account();
		user1.setAccount(account1);

		System.out.println(user1.getEmail());

		UserManager maneger1 = new UserManager();
		maneger1.krediBasvurusundaBulun(account1, 10000);
		System.out.println(account1.getMoney());
		
		AdminManeger adminManager = new AdminManeger();
		adminManager.basvuruOnayla(account1);
		System.out.println(account1.getMoney());
	}

}
