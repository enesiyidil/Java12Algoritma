package dersler.ders013.homework;

import java.util.Scanner;

import dersler.ders013.homework.utility.ProductOperations;

public class Menu {

	private final String[] TITLES = { "Add Product", "Search From Database", "Remove From Show", "List Products",
			"Add Product To Cart", "Del Product From Cart", "Payment", "Return To Top Menu", "Exit" };

	public void menu(Scanner scanner, User user) {

		int election;

		do {
			printMenu(TITLES, user.getName());
			election = electionUser(scanner);

			election += (user.getName().equals("admin") || election == 0) ? 0 : 3;

			if (election > 0 && election < TITLES.length) {
				printTitle(TITLES[election - 1]);
			}

			switch (election) {
			case 1:
				ProductOperations.addProduct(scanner);
				break;
			case 2:
				System.out.print("Enter product CODE => ");
				System.out.println(ProductOperations.searchFromDatabase(scanner.nextLine()));
			case 3:
				ProductOperations.removeFromShow();
				break;
			case 4:
				ProductOperations.listProducts();
				break;
			case 5:
				System.out.print("Enter product ID => ");
				ProductOperations.addProductToCart(scanner.nextLine());
				break;
			case 6:
				System.out.print("Enter product ID => ");
				ProductOperations.delProductFromCart(scanner.nextLine());
				break;
			case 7:
				ProductOperations.cart.showCart();
				System.out.print("Do you confirm?");
				scanner.nextLine();
				ProductOperations.payment(user);
				break;
			case 8:
				System.out.print("Changes will be lost. Do you confirm?");
				scanner.nextLine();
				ProductOperations.cart.delAllProduct();
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

	private int electionUser(Scanner scanner) {
		System.out.print("What's your choise => ");
		String election = scanner.nextLine();
		try {
			return Integer.parseInt(election);
		} catch (Exception e) {
			return -1;
		}
	}

	private void printMenu(String[] titles, String user) {
		printTitle("BilgeAdam Shop");
		System.out.print(Messages.COLOR_CODES[3]);
		int index = 1;
		for (int i = (user.equals("admin")) ? 0 : 3; i < titles.length; i++) {
			System.out.println(((i < titles.length - 1) ? index : "0") + "- " + titles[i]);
			index++;
		}
		System.out.print(Messages.COLOR_CODES[8]);
		printTitle("");
	}

	private void printTitle(String exp) {

		exp = exp.toUpperCase();
		System.out.println(Messages.COLOR_CODES[5]
				+ "______________________________________________________________________" + Messages.COLOR_CODES[8]);
		if (exp.length() % 2 != 0) {
			exp = exp.replace(" ", "  ");
		}
		int underscoreNum = 70 - exp.length();

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
