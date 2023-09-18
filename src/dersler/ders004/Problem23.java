/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.ders004;

/**
 * a'dan z'ye kadar olan harfleri yazdıralım
 * 97-122
 */
public class Problem23 {

	public static void main(String[] args) {
		
		for(char i = 97; i <= 122; i++) {
			System.out.print(i + ((i < 122)? " - " : ""));
		}

	}

}
