package dersler.ders015;

import java.time.format.DateTimeFormatter;

import _ozelMetodlar.TableManager_3;

public class Main {

	static Library library = new Library("Milli Kütüphane");
	static TableManager_3 tb = new TableManager_3();
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	public static void main(String[] args) {

		Main.library.getBookList().add(new Book("XKitabı", "Ali", "AYayın", new Category("Polisiye"), 150.258));
		Main.library.getBookList().add(new Book("YKitabı", "Ali", "BYayın", new Category("Roman"), 200));
		Main.library.getBookList().add(new Book("ZKitabı", "Ayşe", "CYayın", new Category("Öykü"), 300));
		Main.library.getBookList().add(new Book("DKitabı", "Mehmet", "DYayın", new Category("Hikaye"), 350));

		Menu menu = new Menu();
		menu.librarySystemMenu();
		
	}

}
