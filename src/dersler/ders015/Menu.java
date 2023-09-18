package dersler.ders015;

import dersler.ders013.homework.Messages;

public class Menu {

	static LibraryServiceImpl libraryService = new LibraryServiceImpl();
	CustumerManager userManager = new CustumerManager();

	private final String[] SYSTEM_TITLES = { "Admin Page", "User Page", "Exit" };
	private final String[] USER_PAGE_TITLES = { "Register", "Login", "Return Top Menu", "Exit" };
	private final String[] USER_APP_TITLES = { "Book Rent", "Rented Book List", "Get Back The Book", "Return Top Menu", "Exit" };
	private final String[] ADMİN_TITLES = { "Add Book", "List All Books", "List All Books By Active",
			"Search Books By Author", "Delete Book", "Change Status", "Apply Discount", "Return Top Menu", "Exit" };

	public void librarySystemMenu() {
		int election;

		do {
			printMenu(SYSTEM_TITLES, Main.library.getName());
			election = electionUser();

			switch (election) {
			case 1:
				systemMenu();
				break;
			case 2:
				userPage();
				break;
			case 0:
				System.out.println(Messages.COLOR_CODES[3] + "Closing the program..." + Messages.COLOR_CODES[8]);
				System.exit(0);
				break;
			default:
				System.out.println(Messages.COLOR_CODES[1] + "You made the wrong choice! Please check it."
						+ Messages.COLOR_CODES[8]);
				break;
			}

		} while (election != 0);
	}

	public void userPage() {
		int election;

		do {
			printMenu(USER_PAGE_TITLES, "User Page");
			election = electionUser();

			if (election > 0 && election < USER_PAGE_TITLES.length && election != 3) {
				printTitle(USER_PAGE_TITLES[election - 1]);
			}

			switch (election) {
			case 1:
				userManager.register();
				break;
			case 2:
				Custumer custumer = userManager.login();
				if(custumer != null) {
					userApp(custumer);
				}
				break;
			case 3:
				return;
			case 0:
				System.out.println(Messages.COLOR_CODES[3] + "Closing the program..." + Messages.COLOR_CODES[8]);
				System.exit(0);
				break;
			default:
				System.out.println(Messages.COLOR_CODES[1] + "You made the wrong choice! Please check it."
						+ Messages.COLOR_CODES[8]);
				break;
			}

		} while (election != 0);
	}
	
	public void userApp(Custumer custumer) {
		int election;

		do {
			printMenu(USER_APP_TITLES, custumer.getUserName());
			election = electionUser();

			if (election > 0 && election < USER_PAGE_TITLES.length && election != 3) {
				printTitle(USER_PAGE_TITLES[election - 1]);
			}

			switch (election) {
			case 1:
				userManager.kitapKirala(custumer);
				break;
			case 2:
				userManager.kiralananKitalar(custumer);
				break;
			case 3:
				userManager.kitapIadeEt(custumer);
				break;
			case 4:
				return;
			case 0:
				System.out.println(Messages.COLOR_CODES[3] + "Closing the program..." + Messages.COLOR_CODES[8]);
				System.exit(0);
				break;
			default:
				System.out.println(Messages.COLOR_CODES[1] + "You made the wrong choice! Please check it."
						+ Messages.COLOR_CODES[8]);
				break;
			}

		} while (election != 0);
	}

	public void systemMenu() {

		int election;

		do {
			printMenu(ADMİN_TITLES, "Admin Page");
			election = electionUser();

			if (election > 0 && election < ADMİN_TITLES.length && election != 8) {
				printTitle(ADMİN_TITLES[election - 1]);
			}

			switch (election) {
			case 1:
				libraryService.createBok();
				break;
			case 2:
				libraryService.getAllBooks();
				break;
			case 3:
				libraryService.getAllBooksByActive();
				break;
			case 4:
				libraryService.getAuthorByName();
				break;
			case 5:
				libraryService.deleteBookById();
				break;
			case 6:
				libraryService.getAllBooks();
				String id = Util.getStringValue("Silmek istediğiniz kitabın ID:");
				libraryService.changeStatusToDeleted(id);
				break;
			case 7:
				libraryService.getAllBooks();
				id = Util.getStringValue("Silmek istediğiniz kitabın ID:");
				double price = Util.getDoubleValue("İndirim iktarı: ");
				libraryService.applyDiscount(id, price);
				break;
			case 8:
				return;
			case 0:
				System.out.println(Messages.COLOR_CODES[3] + "Closing the program..." + Messages.COLOR_CODES[8]);
				System.exit(0);
				break;
			default:
				System.out.println(Messages.COLOR_CODES[1] + "You made the wrong choice! Please check it."
						+ Messages.COLOR_CODES[8]);
				break;
			}

		} while (election != 0);
	}

	private int electionUser() {

		String election = Util.getStringValue("What's your choise => ");
		try {
			return Integer.parseInt(election);
		} catch (Exception e) {
			return -1;
		}
	}

	private void printMenu(String[] titles, String pageName) {

		printTitle(pageName);
		System.out.print(Messages.COLOR_CODES[3]);
		int index = 1;
		for (int i = 0; i < titles.length; i++) {
			System.out.println(((i < titles.length - 1) ? index : "0") + "- " + titles[i]);
			index++;
		}
		System.out.print(Messages.COLOR_CODES[8]);
		printTitle("");
	}

	private void printTitle(String exp) {

		exp = exp.toUpperCase();
		System.out.println(Messages.COLOR_CODES[5]
				+ "________________________________________________________________________________________________________________________"
				+ Messages.COLOR_CODES[8]);
		if (exp.length() % 2 != 0) {
			exp = exp.replace(" ", "  ");
		}
		int underscoreNum = 120 - exp.length();

		System.out.print(Messages.COLOR_CODES[5]);
		for (int i = 1; i <= underscoreNum; i++) {
			if (i == underscoreNum / 2) {
				System.out.print(Messages.COLOR_CODES[6] + exp + Messages.COLOR_CODES[5]);
			}
			System.out.print("_");
		}
		System.out.println(Messages.COLOR_CODES[8]);
	}
}
