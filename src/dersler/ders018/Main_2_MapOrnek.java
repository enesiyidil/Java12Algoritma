package dersler.ders018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main_2_MapOrnek {

	public static void main(String[] args) {

		Main_2_MapOrnek main = new Main_2_MapOrnek();
		
		String[] ogrenci1 = { "Ayşe", "Zeynep", "Mehmet" };
		Integer[] notlar1 = { 60, 80, 70 };
		
		main.notlariDuzenle(ogrenci1, notlar1);

		String[] ogrenci2 = { "Ayşe", "Zeynep", "Mehmet" };
		Integer[][] notlar2 = { { 60, 80, 70 }, { 60, 80, 70 }, { 60, 80, 70 } };
		
		main.notlariDuzenle(ogrenci2, notlar2);
		
		String[] ogrenci3 = { "Ayşe", "Zeynep", "Mehmet" };
		List<List<Integer>> notlar3 = new ArrayList<>();
		notlar3.add(new ArrayList<>(Arrays.asList( 60, 80, 70 )));
		notlar3.add(new ArrayList<>(Arrays.asList( 50, 80, 70 )));
		notlar3.add(new ArrayList<>(Arrays.asList( 40, 80, 70 )));
		
		main.notlariDuzenle(ogrenci3, notlar3);
	}

	public void notlariDuzenle(String[] ogrenci, Integer[] notlar) {

		Map<String, Integer> ogrenciMap = new LinkedHashMap<>();

		for (int i = 0; i < notlar.length; i++) {
			ogrenciMap.put(ogrenci[i], notlar[i]);
		}

		ogrenciMap.forEach((k, v) -> System.out.println(k + " - " + v));
	}

	public void notlariDuzenle(String[] ogrenci, Integer[][] notlar) {

		Map<String, Integer[]> ogrenciMap = new LinkedHashMap<>();

		for (int i = 0; i < notlar.length; i++) {
			ogrenciMap.put(ogrenci[i], notlar[i]);
		}

		ogrenciMap.forEach((k, v) -> System.out.println(k + " - " + Arrays.toString(v)));
	}
	
	public void notlariDuzenle(String[] ogrenci, List<List<Integer>> notlar) {

		Map<String, List<Integer>> ogrenciMap = new LinkedHashMap<>();

		for (int i = 0; i < notlar.size(); i++) {
			ogrenciMap.put(ogrenci[i], notlar.get(i));
		}

		ogrenciMap.forEach((k, v) -> System.out.println(k + " - " + v));
	}
}
