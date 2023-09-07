package dersler.hafta04.ders013.homework.utility;

import java.util.Scanner;

import dersler.hafta04.ders013.homework.*;

public class ProductOperations {

	private static Cart cart = new Cart();

	public static void addProduct(Scanner scanner) {

		System.out.print("Enter product name: ");
		String name = scanner.next();

		System.out.print("Enter product stock: ");
		int stock = scanner.nextInt();

		System.out.print("Enter product price: ");
		double price = scanner.nextDouble();
		scanner.nextLine();

		Product product = new Product(name, stock, price);
		Database.getProducts().add(product);
	}

	public static void listProducts() {

		String list = "No\tID\t\tName\t\tStock\t\tPrice\n";
		list += "----------------------------------------------------------------------\n";

		int sequenseNo = 1;
		for (int i = 0; i < Database.getProducts().size(); i++) {
			if (Database.getProducts().get(i).isActive()) {
				list += sequenseNo + ".\t" 
						+ Database.getProducts().get(i).getId() + "\t\t"
						+ Database.getProducts().get(i).getName() + "\t\t" 
						+ Database.getProducts().get(i).getStock()+ "\t\t" 
						+ Database.getProducts().get(i).getPrice() + "\n";
				sequenseNo++;
			}
		}
		list += "\u001B[0m";
		System.out.print(list);
	}

	public static void addProductToCart(String id) {

		for (Product product : Database.getProducts()) {
			if (id.equals(product.getId())) {
				cart.addToCart(product);
				break;
			}
		}
		cart.showCart();
	}

	public static void delProductFromCart(String id) {

		for (Product product : cart.getProducts()) {
			if (id.equals(product.getId())) {
				cart.delFromCart(product);
				break;
			}
		}
		cart.showCart();
	}

	public static String searchFromDatabase(String productCode) {

		for (Product product : Database.getProducts()) {
			if (product.getProductCode().equals(productCode)) {
				return product.toString();
			}
		}
		return "There is no such product";
	}

}