package dersler.ders018;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main_3_SetOrnek {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Bir kelime giriniz: ");
		String kelime = scanner.nextLine().toLowerCase();

		Set<Character> tekrarEtmeyenler = new LinkedHashSet<>();
		Set<Character> tekrarEdenler = new LinkedHashSet<>();

		for (Character character : kelime.toCharArray()) {
			if (!tekrarEtmeyenler.add(character) && !tekrarEdenler.add(character)) {
				tekrarEtmeyenler.remove(character);
			} 
		}
		System.out.println("Tekrar edenler    => " + tekrarEdenler);
		System.out.println("Tekrar etmeyenler => " + tekrarEtmeyenler);

		scanner.close();
	}

}
