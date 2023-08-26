/**
 * 
 */
package dersler.hafta02.ders009;

import java.util.Scanner;

/**
 * Kelimedeki türkçe karakterleri ingilizce karaktere çevirelim
 */
public class Problem48 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

        System.out.print("Bir kelime giriniz: ");
        String kelime = changeTrToEng(scanner.next());
        System.out.println(kelime);
        
        scanner.close();

	}
	
	public static String changeTrToEng(String expression) {
		String[] ingilizceKarakter = { "I", "i", "s", "S", "c", "C", "g", "G", "u", "U", "o", "O" };
        String[] turkceKarakter    = { "İ", "ı", "ş", "Ş", "ç", "Ç", "ğ", "Ğ", "ü", "Ü", "ö", "Ö" };
        
		for(int i = 0; i < turkceKarakter.length; i++) {
        	if(expression.contains(turkceKarakter[i])) {
        		expression = expression.replaceAll(turkceKarakter[i], ingilizceKarakter[i]);
        	}
        }
        return expression;
	}

}
