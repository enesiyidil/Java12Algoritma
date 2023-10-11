package dersler.ders021;

import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class Main_1_TryCatch {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		double sonuc = bolme();
		System.out.println(sonuc);

	}

	public static double bolme() {

		System.out.print("\"a/b\" olacak şekilde işlemi giriniz: ");
		String islem = scanner.nextLine().replace(" ", "");
		double sonuc = 0;

		try {
			
			sonuc = Integer.parseInt(islem.split("/")[0]) / Integer.parseInt(islem.split("/")[1]);
		} catch (NumberFormatException e) {
			try {
				islem = islem.replaceAll("[a-zA-Z]", "");
				System.out.println("İfade yanlış. İstediğiniz ifade şu olabilir: " + islem);
			} catch (PatternSyntaxException e2) {
				System.out.println("PatternSyntaxException oluştu");
			}
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException oluştu");
			return Double.POSITIVE_INFINITY;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("IndexOutOfBoundsException oluştu");
		}

		return sonuc;
	}
}
