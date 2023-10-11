package dersler.ders022;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main_1_TryCatch {

	public static void main(String[] args) {

		String[] array = { "6", "10", "bc", "55", "20" };
		Scanner scanner = new Scanner(System.in);

		System.out.print("Değer girin: ");
		try {
			int input = scanner.nextInt();
			System.out.println(array[input]);

		} catch (InputMismatchException e) {
			System.out.println("Rakam dışı değer girildi. Error => " + e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("0-4 arası dışında değer girildi. Error => " + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Program devam ediyor....");
		scanner.close();
	}

}
