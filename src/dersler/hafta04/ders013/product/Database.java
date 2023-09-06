package dersler.hafta04.ders013.product;

import java.util.ArrayList;
import java.util.List;

public class Database {

	private static List<Product> products = new ArrayList<>();

	public static List<Product> getProducts() {
		return products;
	}

}
