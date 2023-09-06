package dersler.hafta04.ders014;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {

	public static void main(String[] args) {

		ekranaYaz("t");
		ekranaYaz(10);

		Random rnd = new Random();
		ArrayList<Integer> randomSayilar = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			int random = rnd.nextInt(0, 101);
			randomSayilar.add(random);
		}

		ekranaYaz(randomSayilar);
		
		List<List<String>> liste = new ArrayList<>();
		
		List<String> liste1 = new ArrayList<>();
		liste1.add("a");
		liste1.add("a");
		liste1.add("a");
		List<String> liste2 = new ArrayList<>();
		liste2.add("A");
		liste2.add("A");
		liste2.add("A");
		
		liste.add(liste1);
		liste.add(liste2);
		
		System.out.println(liste);
	}

	public static <T> void ekranaYaz(T variable) {
		if (variable instanceof Integer) {
			System.out.println("------------------INTEGER LIST------------------");

		} else if (variable instanceof String) {
			System.out.println("------------------STRING LIST-------------------");
		}
	}

	public static <T> void ekranaYaz(ArrayList<T> list) {
		if (list.get(0) instanceof Integer) {
			System.out.println("------------------INTEGER LIST------------------");
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + ((i < (list.size() - 1)) ? " - " : ""));
			}
			System.out.println();

		} else if (list.get(0) instanceof String) {
			System.out.println("------------------STRING LIST-------------------");
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + ((i < (list.size() - 1)) ? " - " : ""));
			}
			System.out.println();
		}
	}
}
