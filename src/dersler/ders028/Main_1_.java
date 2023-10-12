package dersler.ders028;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/*
 * Bir tane öğretmen sınıf oluşturcaz
 * öğretmenler öğrencilerin notlarını okuyacak ve hangi öğretmen hangi öğrenciyi okuduysa;
 * ali öğretmen mehmet öğrencisinin kağıdını okudu
 * 
 * 
 * Mainde 2 tane öğretmen oluşturup iki ayrı thredde çalıştıralım
 */
public class Main_1_ {

	public static void main(String[] args) {
		/*
		 * Manager manager = new Manager(); manager.ogrenciListesiOlustur();
		 * manager.ogrencilerSerilize(); manager.ogrencilerDeserilize();
		 */
		File file = new File(System.getProperty("user.dir") + "\\src\\dersler\\ders028\\ogrenci.txt");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			Ogretmen ogr1 = new Ogretmen("Ahmet", reader);
			Ogretmen ogr2 = new Ogretmen("Mehmet", reader);
			ogr1.start();
			ogr2.start();
			ogr1.join();
			ogr2.join();
			System.out.println(ogr1.getIsim() + " " + ogr1.getHiz() + " -> " + ogr1.getOkunanOgrenciler());
			System.out.println(ogr2.getIsim() + " " + ogr2.getHiz() + " -> " + ogr2.getOkunanOgrenciler());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
