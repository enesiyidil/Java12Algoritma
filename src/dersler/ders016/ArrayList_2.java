package dersler.ders016;

import java.util.ArrayList;
import java.util.Random;

public class ArrayList_2 {

	public static void main(String[] args) {

		ArrayList<Integer> tekList = new ArrayList<Integer>();
		ArrayList<Integer> ciftList = new ArrayList<Integer>();
		Random rnd = new Random();

		int sayi;
		for (int i = 0; i < 35; i++) {
			sayi = rnd.nextInt(1, 101);
			if (sayi % 2 == 0)
				ciftList.add(sayi);
			else
				tekList.add(sayi);
		}

		System.out.println("Çift sayılar => " + ciftList);
		System.out.println("Tek sayılar  => " + tekList);
	}

}
