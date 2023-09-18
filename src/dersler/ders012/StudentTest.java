package dersler.ders012;

/**
 * ögrencilerimizin bir numarasi ve bir isimi olsun
 * 
 * daha sonra kayit metodu yazalim
 * 
 * kayit ol metodu bize ogrenci numarasi atasin sirayla 
 * 
 * Mustafa adli ogrenci basari ile kayit edildi ogrenci numarasi 1
 * Serkan adli ogrenci basari ile kayit edildi ogrenci numarasi 2
 */
public class StudentTest {

	public static void main(String[] args) {

		Student ogr1 = new Student();
		ogr1.numaraVer("Ahmet");

		Student ogr2 = new Student();
		ogr2.numaraVer("Mehmet");
		
		Student ogr3;
		ogr3 = Student.kayit("Helin");
		System.out.println(ogr3.ogrenciAd);

	}

}
