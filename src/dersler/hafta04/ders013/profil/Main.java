package dersler.hafta04.ders013.profil;

public class Main {

	public static void main(String[] args) {
		
		Profile prf1 = new Profile();
		
		prf1.kullaniciAdi = "ahmet1";
		prf1.isim = "Ahmet";
		
		System.out.println(prf1.postSayisi);
		prf1.postOlusturma("Ankara Kahve");
		System.out.println(prf1.postSayisi);
		
		prf1.profileIsimGuncelle("Mehmet");
		
		prf1.istekKabulEt();
		prf1.istekKabulEt();
		prf1.istekKabulEt();
		System.out.println(prf1.takipciSayisi);
		prf1.takiptenCikar();
		System.out.println(prf1.takipciSayisi);
		prf1.istekKabulEt();
		prf1.istekKabulEt();
		prf1.istekKabulEt();
		
		prf1.profilBilgileriniGetir();

	}

}
