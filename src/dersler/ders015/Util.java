package dersler.ders015;

import java.util.Scanner;

import dersler.ders013.homework.Messages;

public class Util {

	static Scanner scanner = new Scanner(System.in);

	public static String getStringValue(String message) {

		System.out.print(message);
		System.out.print(Messages.COLOR_CODES[2]);
		String value = scanner.nextLine();
		System.out.print(Messages.COLOR_CODES[8]);
		return value;
	}

	public static double getDoubleValue(String message) {

		System.out.print(message);
		System.out.print(Messages.COLOR_CODES[2]);
		double value = scanner.nextDouble();
		scanner.nextLine();
		System.out.print(Messages.COLOR_CODES[8]);
		return value;
	}

	public static int getIntValue(String message) {

		System.out.print(message);
		System.out.print(Messages.COLOR_CODES[2]);
		int value = scanner.nextInt();
		scanner.nextLine();
		System.out.print(Messages.COLOR_CODES[8]);
		return value;
	}
}
