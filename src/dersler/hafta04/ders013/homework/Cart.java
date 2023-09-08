package dersler.hafta04.ders013.homework;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	private List<Product> products;
	private List<Integer> amount;
	private int totalAmaunt;
	private double totalPrice;

	public Cart() {
		super();
		products = new ArrayList<>();
		amount = new ArrayList<>();
	}

	public List<Product> getProducts() {
		return products;
	}

	public int getTotalAmaunt() {
		return totalAmaunt;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void addToCart(Product product) {

		boolean isThere = true;

		if (product.getStock() > 0) {
			for (int i = 0; i < products.size(); i++) {
				if (product.getId().equals(products.get(i).getId())) {
					int temp = amount.get(i) + 1;
					amount.remove(i);
					amount.add(i, temp);
					totalPrice += product.getPrice();
					product.setStock(product.getStock() - 1);
					isThere = false;
					break;
				}
			}
			if (isThere) {
				products.add(product);
				amount.add(1);
				totalPrice += product.getPrice();
				product.setStock(product.getStock() - 1);
			}
			totalAmaunt++;
		} else {
			System.out.println("Product out of stock!");
			product.checkFromListing();
		}

	}

	public void showCart() {

		String list = "No\tName\t\tPrice\t\tQuantity\n";
		list += "----------------------------------------------------------------------\n";

		for (int i = 0; i < products.size(); i++) {
			list += (i + 1) + ".\t" + products.get(i).getName() + "\t\t" + products.get(i).getPrice() + "\t\t"
					+ amount.get(i) + "\n";
		}
		list += "----------------------------------------------------------------------\n";
		list += "\tToplam =>\t" + this.totalPrice + "\t\t" + this.totalAmaunt;
		list += "\u001B[0m";
		System.out.println(list);
	}

	public void delFromCart(Product product) {

		boolean isThere = true;

		for (int i = 0; i < products.size(); i++) {
			if (product.getId().equals(products.get(i).getId())) {
				if (amount.get(i) == 1) {
					products.remove(i);
					amount.remove(i);
				} else {
					int temp = amount.get(i) - 1;
					amount.remove(i);
					amount.add(i, temp);
				}
				totalPrice -= product.getPrice();
				product.setStock(product.getStock() + 1);
				isThere = false;
				break;
			}
		}
		if (isThere) {
			System.out.println("No this product in cart!");
		} else {
			product.checkFromListing();
			totalAmaunt--;
		}
	}

	public void delAllProduct() {
		if(products.isEmpty())
			return;
		for (Product product : products) {
			delFromCart(product);
			product.setStock(product.getStock() - 1);
		}
	}
}
