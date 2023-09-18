package dersler.ders013.homework.utility;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import _ozelMetodlar.ListeYazdir;
import dersler.ders013.homework.*;

public class ProductOperations {

	public static Cart cart = new Cart();

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
		try {
			String[] titles = {"Id", "Name","Stock+","Price+"};
			String test = ListeYazdir.listeYazdir(Database.getProducts(), titles);
			System.out.println(test);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public static void addProductToCart(String id) {

		for (Product product : Database.getProducts()) {
			if (id.equals(product.getId())) {
				cart.addToCart(product);
				System.out.println("Product added to cart");
				return;
			}
		}
		System.out.println("Product not found");
	}

	public static void delProductFromCart(String id) {

		for (Product product : cart.getProducts()) {
			if (id.equals(product.getId())) {
				cart.delFromCart(product);
				System.out.println("Product deleted from cart");
				return;
			}
		}
		System.out.println("Product not found");
	}

	public static String searchFromDatabase(String productCode) {

		for (Product product : Database.getProducts()) {
			if (product.getProductCode().equals(productCode)) {
				return product.toString();
			}
		}
		return "There is no such product";
	}

	public static void payment(User user) {
		if(user.getBudget() >= cart.getTotalPrice()) {
			cart.delAllProduct();
			System.out.println("Payment received");
		}else {
			System.out.println("Your balance is not enough");
		}
	}
	public static void removeFromShow() {
		for (Product product : Database.getProducts()) {
			product.checkFromListing();
		}
	}
}
