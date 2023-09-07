package dersler.hafta04.ders013.homework;

/*
 * Menu
 * 1 - Product Ekle
 * 2 - ürünleri listelesin (isim , stok ve price, id)
 * (Tüm ürünleri listelerken sadece isActive true olanları Listeleyelim)
 * 3 - sepeteÜrünEkle --> benden id istesin kullanıcının girdiği id de ürün varsa onu sepete eklesin
 * 4 - Database productCode göre arama yapsın varsa getirsin
 * 0 - Çıkış
 */
public class Main {

	public static void main(String[] args) {

		Menu menu = new Menu();
		menu.menu();
	}

}
