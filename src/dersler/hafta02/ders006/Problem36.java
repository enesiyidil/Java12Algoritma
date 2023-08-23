/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.hafta02.ders006;

/**
 * 
 */
public class Problem36 {

	public static void main(String[] args) {
		
		String text = "enes";
		System.out.println(System.identityHashCode(text));
		String text2 = "enes";
		System.out.println(System.identityHashCode(text2));
		text = "en";
		System.out.println(System.identityHashCode(text));
		text2 = "enes";
		System.out.println(System.identityHashCode(text2));
		text = "e";
		System.out.println(System.identityHashCode(text));
		text2 = "ahmet";
		System.out.println(System.identityHashCode(text2));

	}

}
