package dersler.ders015;

import java.util.ArrayList;
import java.util.List;

public class Library {

	private String name;
	private List<Book> bookList;
	private List<Custumer> custumerList;

	public Library() {
		this.bookList = new ArrayList<Book>();
		this.custumerList = new ArrayList<Custumer>();
	}

	public Library(String name) {
		this();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public List<Custumer> getCustumerList() {
		return custumerList;
	}

	public void setCustumerList(List<Custumer> custumerList) {
		this.custumerList = custumerList;
	}

}
