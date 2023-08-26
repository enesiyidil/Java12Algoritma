/**
 * 
 */
package dersler.hafta02.ders010;

import java.time.Year;
import java.util.Scanner;

/**
 * Doğum yılına göre yaş ve doğum yüzyılını hesaplama (Metot ile)
 */
public class Problem50 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		kullaniciBilgileriGoster(scanner);
		
		scanner.close();

	}
	static void kullaniciBilgileriGoster(Scanner scanner) {
		System.out.print("Doğum yılınızı giriniz: ");
		int yil = scanner.nextInt();scanner.nextLine();
		
		int yuzyil = yuzyilHesaplama(yil);
		int yas = yasHesaplama(yil);
		
		System.out.println(yuzyil + ". Yüzyılda doğdunuz. " + yas + " yaşındasınız.");
	}
	static int yuzyilHesaplama(int yil) {
		int yuzyil = (yil / 100) + 1;
		return yuzyil;
	}
	static int yasHesaplama(int yil) {
		int suankiYil = Year.now().getValue();;
		int yas = suankiYil - yil;
		return yas;
	}

}
