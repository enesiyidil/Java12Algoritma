package dersler.ders015;

import java.time.LocalDateTime;

public class CustumerManager {

	public void register() {

		String tc = Util.getStringValue("TC'nizi giriniz: ");
		String userName = Util.getStringValue("Kullanıcı adını giriniz: ");
		String password = Util.getStringValue("Şifrenizi giriniz: ");
		double balance = Util.getDoubleValue("Bakiyenizi giriniz: ");

		Custumer custumer = new Custumer(userName, password, tc, balance);

		Main.library.getCustumerList().add(custumer);
	}

	public Custumer login() {

		String userName = Util.getStringValue("Kullanıcı adını giriniz: ");
		Custumer custumer = findByUsername(userName);

		if (custumer != null) {
			for (int i = 3; i > 0; i--) {
				String password = Util.getStringValue("Şifrenizi giriniz: ");
				if (custumer.getPassword().equals(password)) {

					return custumer;
				} else {
					System.out.println("Şifre hatalı, kalan hak: " + (i - 1));
				}
			}
			System.out.println("Hakkınız tükendi. Hesap askıya alındı.");
			return null;
		}
		System.out.println("Kullanıcı yok");
		return null;
	}

	private Custumer findByUsername(String username) {

		for (Custumer custumer : Main.library.getCustumerList()) {
			if (custumer.getUserName().equals(username)) {
				return custumer;
			}
		}
		return null;
	}

	public void kitapKirala(Custumer custumer) {

		Menu.libraryService.getAllBooks();

		String id = Util.getStringValue("Kiralamak istediğiniz kitabın ID'si: ");
		Book book = Menu.libraryService.findById(id);

		if (book == null) {
			System.out.println("Kitap bulunamadı");
			return;
		}

		if (book.geteStatus().name().equals("ACTIVE")) {
			if (custumer.getBalance() >= book.getPrice()) {
				int day = Util.getIntValue("Kaç gün kiralayacaksınız: ");
				custumer.getRentedBooks().add(book);
				custumer.setBalance(custumer.getBalance() - book.getPrice());
				book.seteStatus(EStatus.RENTED);
				book.setRentDate(LocalDateTime.now());
				book.setReturnedDate(LocalDateTime.now().plusDays(day));

				System.out
						.println("Kitap kiralandı. Geri iade terihi: " + book.getReturnedDate().format(Main.formatter));
			} else {
				System.out.println("Bakiyeniz yetersiz.");
			}
		} else {
			System.out.println("Kitap uygun değil");
		}
	}

	public void kiralananKitalar(Custumer custumer) {
		if (!custumer.getRentedBooks().isEmpty()) {
			String[] columbTitles = { "Id", "Name", "RentDate", "ReturnedDate" };
			String tableTitle = "All Book in " + custumer.getUserName().toUpperCase() + " Library";

			Main.tb.printTable(tableTitle, columbTitles, Main.library.getBookList(),
					book -> book.getId(),
					book -> book.getName(),
					book -> (book.getRentDate() != null) ? book.getRentDate().format(Main.formatter) : "-",
					book -> (book.getReturnedDate() != null)?book.getReturnedDate().format(Main.formatter): "-");
			return;
		}
		System.out.println("Kiralanan kitap yok!");
	}
	
	public void kitapIadeEt(Custumer custumer) {

		kiralananKitalar(custumer);

		String id = Util.getStringValue("İade etmek istediğiniz kitabın ID'si: ");
		
		for (int i = 0; i < custumer.getRentedBooks().size(); i++) {
			if(custumer.getRentedBooks().get(i).getId().equals(id)) {
				Book book = custumer.getRentedBooks().get(i);
				System.out.println(custumer.getRentedBooks().remove(book));
				book.seteStatus(EStatus.ACTIVE);
				book.setRentDate(null);
				book.setReturnedDate(null);
				System.out.println("Kitap iade edildi.");
				return;
			}
		}
		System.out.println("Böyle bir kitap kiralamadınız!");
	}
}
