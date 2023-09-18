package _ozelMetodlar;

import java.util.ArrayList;
import java.util.List;

import dersler.ders015.Book;
import dersler.ders015.Category;

public class Test {

	public static <T> void main(String[] args) {
		
		List<Book> list = new ArrayList<Book>();
		list.add(new Book("XKitabı", "Ali", "AYayın", new Category("Polisiye"), 155546540.258));
		list.add(new Book("YKitabı", "Ali", "BYayın", new Category("Roman"), 200));
		list.add(new Book("ZKitabı", "Ayşe", "CYayın", new Category("Öykü"), 300));
		list.add(new Book("DKitabı", "Mehmet", "DYayın", new Category("Hikaye"), 350));

		TableManager_3 tb = new TableManager_3();

		String[] headerNames = { "Id", "Name", "AuthorName", "Category", "Publisher", "Price+", "eStatus" };
		String tableTitle = "All Book in Library";

		tb.printTable(tableTitle, headerNames, list, 
				book -> book.getId(), 
				book -> book.getName(),
				book -> book.getAuthorName(), 
				book -> book.getCategory(), 
				book -> book.getPublisher(),
				book -> book.getPrice(), 
				book -> book.geteStatus().name());
	}

}
