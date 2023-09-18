package dersler.ders015;

import java.time.LocalDateTime;
import java.util.UUID;

public class Book {

	private String id;
	private String name;
	private String authorName;
	private String publisher;
	private Category category;
	private double price;
	private EStatus eStatus;
	private LocalDateTime rentDate;
	private LocalDateTime returnedDate;

	public Book() {
		this.id = UUID.randomUUID().toString();
		this.eStatus = EStatus.ACTIVE;
	}

	public Book(String name, String authorName, String publisher, Category category, double price) {
		this();
		this.name = name;
		this.authorName = authorName;
		this.publisher = publisher;
		this.category = category;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public EStatus geteStatus() {
		return eStatus;
	}

	public void seteStatus(EStatus eStatus) {
		this.eStatus = eStatus;
	}

	public String getId() {
		return id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public LocalDateTime getRentDate() {
		return rentDate;
	}

	public void setRentDate(LocalDateTime rentDate) {
		this.rentDate = rentDate;
	}

	public LocalDateTime getReturnedDate() {
		return returnedDate;
	}

	public void setReturnedDate(LocalDateTime returnedDate) {
		this.returnedDate = returnedDate;
	}

}
