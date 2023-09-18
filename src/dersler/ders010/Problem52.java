/**
 * 
 */
package dersler.ders010;

import java.util.Scanner;

/**
 * 
 */
public class Problem52 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Kelime giriniz:");
		String kelime = scanner.nextLine();
		if(kelime.length() < 100) {
			if(kelime.length() == 1) {
				System.out.println(kelime);
			}else {
				System.out.println(tersleme(kelime));
			}
		}else {
			System.out.println("kelime çok uzun");
		}
		scanner.close();

	}
	
	static String tersleme(String kelime) {
		char[] kelimeChar = kelime.toCharArray();
		char temp = kelimeChar[0];
		kelimeChar[0] = kelimeChar[kelimeChar.length - 1];
		kelimeChar[kelimeChar.length - 1] = temp;
		kelime = "";
		for (char c : kelimeChar) {
			kelime += c;
		}
		return kelime;
	}

}
