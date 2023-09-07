package dersler.hafta04.ders013.homework;

import java.util.Scanner;

import dersler.hafta04.ders013.homework.utility.ProductOperations;

public class Menu {

	private Scanner scanner = new Scanner(System.in);
	private final static String[] colorCodes = { "siyah\u001B[30m", // Siyah
			"\u001B[31m", // Kırmızı
			"\u001B[32m", // Yeşil
			"\u001B[33m", // Sarı
			"\u001B[34m", // Mavi
			"\u001B[35m", // Mor
			"\u001B[36m", // Çiyan
			"\u001B[37m", // Beyaz
			"\u001B[0m" // Reset
	};
	private final String[] titles = { "Add Product", "List Products", "Add Product To Cart", "Del Product From Cart",
			"Search From Database", "Exit" };

	public void menu() {

		int election;

		do {
			printMenu();
			election = electionUser();

			if (election > 0 && election < titles.length) {
				printTitle(titles[election - 1]);
			}

			switch (election) {
			case 1:
				ProductOperations.addProduct(scanner);
				break;
			case 2:
				ProductOperations.listProducts();
				break;
			case 3:
				System.out.print("Enter product ID => ");
				ProductOperations.addProductToCart(scanner.nextLine());
				break;
			case 4:
				System.out.print("Enter product ID => ");
				ProductOperations.delProductFromCart(scanner.nextLine());
				break;
			case 5:
				System.out.print("Enter product CODE => ");
				System.out.println(ProductOperations.searchFromDatabase(scanner.nextLine()));
				break;
			case 0:
				System.out.println(colorCodes[3] + "Closing the program..." + colorCodes[8]);
				break;
			default:
				System.out.println(colorCodes[1] + "You made the wrong choice! Please check it." + colorCodes[8]);
				break;
			}

		} while (election != 0);
	}

	private int electionUser() {
		System.out.print("What's your choise => ");
		String election = scanner.nextLine();
		try {
			return Integer.parseInt(election);
		} catch (Exception e) {
			return -1;
		}
	}

	private void printMenu() {
		printTitle("BilgeAdam Shop");
		System.out.print(colorCodes[3]);
		for (int i = 0; i < titles.length; i++) {
			System.out.println(((i < titles.length - 1) ? (i + 1) : "0") + "- " + titles[i]);
		}
		System.out.print(colorCodes[8]);
		printTitle("");
	}

	private void printTitle(String exp) {

		exp = exp.toUpperCase();
		System.out.println(colorCodes[5] + "______________________________________________________________________"
				+ colorCodes[8]);
		if (exp.length() % 2 != 0) {
			exp = exp.replace(" ", "  ");
		}
		int underscoreNum = 70 - exp.length();

		System.out.print(colorCodes[5]);
		for (int i = 1; i <= underscoreNum; i++) {
			if (i == underscoreNum / 2) {
				System.out.print(colorCodes[6] + exp + colorCodes[5]);
			}
			System.out.print("_");
		}
		System.out.println(colorCodes[8]);
	}
}
