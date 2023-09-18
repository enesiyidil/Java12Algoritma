package dersler.ders013.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * boostegitimoperasyon@bilgeadam.com
 */
public class Main {

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {

		Product product1 = new Product();

		System.out.println(product1.getId());

		product1.setName("Asus");
		product1.setPrice(15000);
		product1.setStock(100);

		System.out.println(product1.getName());
		product1.updateName("Asus X1");
		System.out.println(product1.getName());
		product1.saveToDatabase();

		Product product2 = new Product("Apple", "Telefon", 2, 40000);
		Product product3 = new Product("Xiaomi", "Telefon", 2, 20000);
		Product product4 = new Product("Samsung", "Telefon", 2, 30000);
		addProduct();

		System.out.println(product2.getProductCode());

		Cart cart = new Cart();

		cart.addToCart(product2);
		cart.addToCart(product1);
		cart.addToCart(product2);
		cart.addToCart(product2);
		cart.addToCart(product2);
		cart.addToCart(product3);
		cart.addToCart(product3);
		cart.addToCart(product4);

		cart.showCart();
		System.out.println(cart.getTotalAmaunt());

		cart.delFromCart(product2);

		cart.showCart();
		System.out.println(cart.getTotalAmaunt());

		cart.addToCart(product2);

		cart.showCart();
		
		System.out.println(Database.getProducts());

	}

	public static void addProduct() {

		String[] names = { "Ad", "Tür", "Stock", "Fiyat" };
		String[] type = { "String", "String", "int", "double" };
		List<Object> constructorVariables = new ArrayList<>();

		for (int i = 0; i < names.length; i++) {
			System.out.print(names[i] + ": ");
			String temp = scanner.next();
			if (type[i].equals("int")) {
				constructorVariables.add(Integer.parseInt(temp));
			} else if (type[i].equals("double")) {
				constructorVariables.add(Double.parseDouble(temp));
			} else {
				constructorVariables.add(temp);
			}
		}
		Product product = new Product((String) constructorVariables.get(0), (String) constructorVariables.get(1),
				(int) constructorVariables.get(2), (double) constructorVariables.get(3));
		Database.getProducts().add(product);
	}
}
