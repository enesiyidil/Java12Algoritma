package dersler.ders015;

public interface ILibraryService {
	
	void createBok();
	
	void getAllBooks();
	
	void getAllBooksByActive();
	
	void getAuthorByName();
	
	void deleteBookById();
	
	void changeStatusToDeleted(String id);
	
	void applyDiscount(String id, double price);
	
}
