package dersler.hafta04.ders013.homework;

import dersler.hafta04.ders013.homework.utility.RandomGenerate;

public class Product {

	private String id;
	private String name;
	private int stock;
	private double price;
	private String productCode;
	private boolean isActive = true;

	public Product(String name, int stock, double price) {
		setName(name);
		this.id = RandomGenerate.id();
		this.productCode = RandomGenerate.productCode(this.name, this.id);
		setStock(stock);
		setPrice(price);
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		if (stock < 0) {
			System.out.println("Value cannot be less than zero");
		} else {
			this.stock = stock;
		}
	}

	public double getPrice() {
		return price;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public void setPrice(double price) {
		if (price < 0) {
			System.out.println("Value cannot be less than zero");
		} else {
			this.price = price;
		}
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", stock=" + stock + ", price=" + price + ", productCode="
				+ productCode + "]";
	}

	public void updateName(String name) {
		setName(name);
	}

	public void checkFromListing() {
		if (this.stock <= 0) {
			setActive(false);
		} else {
			setActive(true);
		}
	}

}
