package dersler.ders016;

import java.util.ArrayList;

public class ArrayList_1 {

	public static void main(String[] args) {

		ArrayList<String> sehirler = new ArrayList<String>();
		sehirler.add("Ankara");
		sehirler.add("istanbul");
		sehirler.add("izmir");
		sehirler.add("antalya");
		sehirler.add("adana");

		System.out.println(sehirler);

		/**
		 * \\b[Anan]+\\w*\\b
		 * 
		 * (?i)([a-z])\\1([a-z]+)
		 */
		sehirler.replaceAll(deger -> deger.replaceAll("(?i)\\ban", "xxx"));
		
		System.out.println(sehirler);
	}

}
