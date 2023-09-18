package dersler.ders015;

import java.util.stream.Collectors;

public class LibraryServiceImpl implements ILibraryService {

	@Override
	public void createBok() {

		String bookName = Util.getStringValue("Kitap adını giriniz: ");
		String authorName = Util.getStringValue("Kitap yazarını giriniz: ");
		String publisher = Util.getStringValue("Kitap yayınevini giriniz: ");
		String categoryName = Util.getStringValue("Kitap kategorisini giriniz: ");
		double bookPrice = Util.getDoubleValue("Kitap fiyatını giriniz: ");

		Category category = new Category(categoryName);
		Book book = new Book(bookName, authorName, publisher, category, bookPrice);

		Main.library.getBookList().add(book);
	}

	@Override
	public void getAllBooks() {
		String[] columbTitles = { "Id", "Name", "AuthorName", "Category", "Publisher", "Price", "eStatus", "RentDate",
				"ReturnedDate" };
		String tableTitle = "All Book in Library";

		Main.tb.printTable(tableTitle, columbTitles, Main.library.getBookList(),
				book -> book.getId(),
				book -> book.getName(),
				book -> book.getAuthorName(),
				book -> book.getCategory(),
				book -> book.getPublisher(),
				book -> book.getPrice(),
				book -> book.geteStatus().name(),
				book -> (book.getRentDate() != null) ? book.getRentDate().format(Main.formatter) : "-",
				book -> (book.getReturnedDate() != null)?book.getReturnedDate().format(Main.formatter): "-");
	}

	@Override
	public void getAllBooksByActive() {

		String list = "No\tName\t\tAuthor\t\tCategory\t\tPrice\n";
		list += "----------------------------------------------------------------------\n";

		int index = 1;
		for (int i = 0; i < Main.library.getBookList().size(); i++) {
			if (Main.library.getBookList().get(i).geteStatus().name().equals("ACTIVE")) {
				list += index + ".\t" + Main.library.getBookList().get(i).getName() + "\t\t"
						+ Main.library.getBookList().get(i).getAuthorName() + "\t\t"
						+ Main.library.getBookList().get(i).getCategory().getName() + "\t\t"
						+ Main.library.getBookList().get(i).getPrice() + "\n";
				index++;
			}
		}
		System.out.print(list);
		
		String[] columbTitles = { "Id", "Name", "AuthorName", "Category", "Publisher", "Price", "RentDate",
		"ReturnedDate" };
		String tableTitle = "All Book in Library by ACTIVE";

		Main.tb.printTable(tableTitle, columbTitles, Main.library.getBookList().stream().filter(book -> book.geteStatus().name().equals("ACTIVE")).collect(Collectors.toList()),
				book -> book.getId(),
				book -> book.getName(),
				book -> book.getAuthorName(),
				book -> book.getCategory(),
				book -> book.getPublisher(),
				book -> book.getPrice(),
				book -> (book.getRentDate() != null) ? book.getRentDate().format(Main.formatter) : "-",
				book -> (book.getReturnedDate() != null)?book.getReturnedDate().format(Main.formatter): "-");
	}

	@Override
	public void getAuthorByName() {

		String name = Util.getStringValue("Yazar adını giriniz: ");

		String list = "";
		list += "No\tName\t\tCategory\t\tPrice\n";
		list += "----------------------------------------------------------------------\n";

		int index = 1;
		for (int i = 0; i < Main.library.getBookList().size(); i++) {
			if (Main.library.getBookList().get(i).getAuthorName().equalsIgnoreCase(name)) {
				list += index + ".\t" + Main.library.getBookList().get(i).getName() + "\t\t"
						+ Main.library.getBookList().get(i).getCategory().getName() + "\t\t"
						+ Main.library.getBookList().get(i).getPrice() + "\n";
				index++;
			}
		}
		if (index == 1) {
			System.out.println("Böyle bir yazara ait kitap bulunamadı");
		} else {
			list = name + " yazdığı kitaplar.\n" + list;
			System.out.print(list);
		}
	}

	@Override
	public void deleteBookById() {

		String list = "No\tID\t\tName\n";
		list += "----------------------------------------------------------------------\n";

		for (int i = 0; i < Main.library.getBookList().size(); i++) {
			list += (i + 1) + ".\t" + Main.library.getBookList().get(i).getId() + "\t\t"
					+ Main.library.getBookList().get(i).getName() + "\n";

		}
		System.out.print(list);

		String id = Util.getStringValue("Silmek istediğiniz kitabın ID: ");

		for (int i = 0; i < Main.library.getBookList().size(); i++) {
			if (Main.library.getBookList().get(i).getId().equals(id)) {
				Main.library.getBookList().remove(i);
				return;
			}
		}
		System.out.println("Girilen ID yanlış!");
	}

	@Override
	public void changeStatusToDeleted(String id) {

		Book book = findById(id);

		if (book != null) {
			book.seteStatus(EStatus.DELETED);
			return;
		}
		System.out.println(id + " bu id'ye sahip bir kitap yok!");
	}

	public Book findById(String id) {

		for (int i = 0; i < Main.library.getBookList().size(); i++) {
			if (Main.library.getBookList().get(i).getId().equals(id)) {
				return Main.library.getBookList().get(i);
			}
		}
		return null;
	}

	@Override
	public void applyDiscount(String id, double price) {
		Book book = findById(id);

		if (book != null) {
			book.setPrice(book.getPrice() - price);
			return;
		}
		System.out.println(id + " bu id'ye sahip bir kitap yok!");
	}

}
