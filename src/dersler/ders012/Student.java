package dersler.ders012;

/**
 * 
 */
public class Student {

	private static int ogrenciSayisi = 1;
	
	public String ogrenciAd;
	private int ogrenciNumarası;
	
	public void numaraVer(String ogrenciAd) {
		this.ogrenciAd = ogrenciAd;
		this.ogrenciNumarası = ogrenciSayisi;
		ogrenciSayisi++;
		System.out.println(this.ogrenciAd + " adlı öğrenci başarı ile kaydedildi. Numarası: " + ogrenciNumarası);
	}
	public static Student kayit(String ogrenciAd) {
		Student ogr = new Student();
		ogr.numaraVer(ogrenciAd);
		return ogr;
	}
}
