package dersler.ders017;

import java.util.Scanner;
import java.util.Stack;

public class StackOrnek2 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Kelime giriniz: ");
		String kelime = scanner.nextLine();

		boolean polindromMu = polinromMu(kelime);
		if (polindromMu) {
			System.out.println("Kelime polindromdur.");
		} else {
			System.out.println("Kelime polindrom değildir.");
		}

		scanner.close();

	}

	public static boolean polinromMu(String kelime) {
		Stack<Character> kelimeStack = new Stack<>();

		for (Character item : kelime.toCharArray()) {
			kelimeStack.add(item);
		}

		for (int i = 0; i < kelime.length(); i++) {
			if (kelime.charAt(i) != kelimeStack.pop()) {
				return false;
			}
		}

		return true;
	}

}
