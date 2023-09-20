package dersler.ders018;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_1_MapOrnek {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Bir kelime giriniz: ");
		String kelime = scanner.nextLine();
		
		Map<Character, Integer> map = new LinkedHashMap<>();
		
		for (Character harf : kelime.toCharArray()) {
			map.put(harf, map.getOrDefault(harf, 0) + 1);
		}
		
		map.forEach((k, v) -> System.out.println(k + " - " + v));
		scanner.close();
	}

}
