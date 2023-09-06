package dersler.hafta03.ders011;

import java.util.Random;
import java.util.Scanner;

public class Problem53_Yardimci {

	static String[] arr = { "TAŞ", "KAĞIT", "MAKAS" };

	static Scanner scanner = new Scanner(System.in);

	public static void oyun() {
		String pcSecim = pcSecim();
		String userSecim = userSecim();

		int kimKazandi = kimKazandi(pcSecim, userSecim);

		String sonuc = switch (kimKazandi) {
		case 0: {
			yield "\u001B[33m" + "Berabere!" + "\u001B[0m" + " Seçimler -> " + "\u001B[33m" + "PC: " + pcSecim
					+ " USER: " + userSecim + "\u001B[0m";
		}
		case 1: {
			yield "\u001B[31m" + "Kaybettiniz!" + "\u001B[0m" + " Seçimler -> " + "\u001B[32m" + "PC: " + pcSecim
					+ "\u001B[31m" + " USER: " + userSecim + "\u001B[0m";
		}
		case 2: {
			yield "\u001B[32m" + "Kazandınız!" + "\u001B[0m" + " Seçimler -> " + "\u001B[31m" + "PC: " + pcSecim
					+ "\u001B[32m" + " USER: " + userSecim + "\u001B[0m";
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + kimKazandi);
		};
		System.out.println(sonuc);
	}
	
	public static String pcSecim() {

		Random random = new Random();
		int index = random.nextInt(arr.length);

		return arr[index];
	}

	public static String userSecim() {

		int index = 0;

		for (int i = 0; i < arr.length; i++) {
			System.out.println((i + 1) + "- " + arr[i]);
		}
		do {
			if(indexDogruMu(index))
				System.out.println("\u001B[31m" + "Lütffen belirtilen aralıkta sayı girişi yapınız!!!" + "\u001B[0m" );
			System.out.print("Seçiminiz: ");
			index = scanner.nextInt();
			scanner.nextLine();
		} while (indexDogruMu(index));
		scanner.close();

		return arr[index - 1];
	}

	public static boolean indexDogruMu(int index) {

		if (index <= arr.length)
			return false;
		else
			return true;
	}
	
	public static int kimKazandi(String pcSecim, String userSecim) {
		
		if(pcSecim.equals(userSecim)) {
			return 0;
		}
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].equals(userSecim)) {
				int index = ((i + 2) >= arr.length)? i - 1 : i + 2;
				if(arr[index].equals(pcSecim)) {
					return 2;
				}else {
					return 1;
				}
			}
		}
		
		return 0;
	}
}
