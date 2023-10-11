package dersler.ders024;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main_2_Mars {

	public static void main(String[] args) {

		int karakter = 0;
		int kelime = 0;
		int satirSayisi = 0;
		String regex = ",|!|\\?|'|\"|\\.|;|-";
		Map<String, Integer> kelimeler = new LinkedHashMap<>();
		File file = new File(System.getProperty("user.dir") + "\\src\\dersler\\ders024\\mars.txt");

		if (file.exists()) {
			try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
				String satir;
				while ((satir = reader.readLine()) != null) {
					satir = satir.toLowerCase();
					satirSayisi++;
					karakter += satir.replace(" ", "").toCharArray().length;
					kelime += satir.replaceAll("^[a-zA-Z]", "").split(" ").length;
					if(satir.length()==0)
						continue;
					for (String item : satir.replaceAll(regex, "").split(" ")) {
						kelimeler.put(item, kelimeler.getOrDefault(item, 0)+1);
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Satır sayısı : "+satirSayisi);
		List<Entry<String, Integer>> list = new ArrayList<>(kelimeler.entrySet());
		list.sort(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()));
		System.out.println("karakter sayısı : "+karakter);
		System.out.println("kelime sayısı : "+kelime);
		System.out.println("Ençok tekrar eden kelime: "+list.get(0).getKey()+" tekrar sayısı: "+list.get(0).getValue());
		System.out.println("Ençok tekrar eden 2.kelime: "+list.get(1).getKey()+" tekrar sayısı: "+list.get(1).getValue());
	}

}
