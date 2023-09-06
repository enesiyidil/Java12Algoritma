package dersler.hafta04.ders013.product;

import dersler.hafta04.ders013.product.utility.RandomGenerateID;

public class Product {

	private String id;
	private String name;
	private String type;
	private int stock;
	private double price;
	private String productCode;
	private boolean isActive = true;

	public Product() {
		id = RandomGenerateID.generateId();
	}

	public Product(String name, String type, int stock, double price) {
		this();
		setName(name);
		this.productCode = RandomGenerateID.generateProductCode(this.name);
		setType(type);
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		if (stock < 0) {
			System.out.println("Girilen stok değeri sıfırdan küçük olamaz");
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
			System.out.println("Girilen fiyat değeri sıfırdan küçük olamaz");
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
		return "Product [id=" + id + ", name=" + name + ", type=" + type + ", stock=" + stock + ", price=" + price
				+ ", productCode=" + productCode + "]";
	}

	public void updateName(String name) {
		setName(name);
	}

	public void saveToDatabase() {
		System.out.println("\"" + this.name + "\" ürünü veri tabanına kaydedildi.");
	}
	
	public void checkFromListing() {
		if(this.stock <= 0) {
			setActive(false);
			System.out.println(getName() + " gösterimden kaldırıldı.");
		}else {
			setActive(true);
		}
	}

}
