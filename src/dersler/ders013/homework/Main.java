package dersler.ders013.homework;

import java.util.Scanner;

/*
 * Menu
 * 1 - Product Ekle
 * 2 - ürünleri listelesin (isim , stok ve price, id)
 * (Tüm ürünleri listelerken sadece isActive true olanları Listeleyelim)
 * 3 - sepeteÜrünEkle --> benden id istesin kullanıcının girdiği id de ürün varsa onu sepete eklesin
 * 4 - Database productCode göre arama yapsın varsa getirsin
 * 0 - Çıkış
 */
public class Main {

	static Scanner scanner = new Scanner(System.in);
	private static final String ADMIN = "admin";
	private static final String PASSWORD = "admin12345";
	private static User admin = new User(ADMIN);

	public static void main(String[] args) {

		Menu menu = new Menu();
		User user1 = new User("Enes");
		User user2 = new User("Ahmet");
		User user3 = new User("Ebru");
		login(menu, user1, user2, user3);
	}

	public static void login(Menu menu, User... users) {

		for (;;) {
			System.out.print("Enter user name: ");
			String userName = scanner.nextLine();

			if (userName.equalsIgnoreCase(ADMIN)) {
				System.out.print("Enter password: ");
				String password = scanner.nextLine();
				if (password.equals(PASSWORD)) {
					menu.menu(scanner, admin);
				} else {
					System.out.println(Messages.COLOR_CODES[1] + Messages.ADMIN_PASSWORD_INCORRET_ERROR_MESSAGE
							+ Messages.COLOR_CODES[8]);
				}
			} else {
				boolean isThereUser = false;
				for (User user : users) {
					if (userName.equalsIgnoreCase(user.getName())) {
						isThereUser = true;
						System.out.print("Enter budget: ");
						int budget = scanner.nextInt();
						scanner.nextLine();
						user.setBudget(budget);
						menu.menu(scanner, user);
					}
				}
				if(isThereUser) {
					System.out.println(Messages.COLOR_CODES[1] + Messages.NO_USER_ERROR_MESSAGE
							+ Messages.COLOR_CODES[8]);
				}
			}
		}
	}
}
