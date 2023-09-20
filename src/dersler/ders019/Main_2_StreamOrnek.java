package dersler.ders019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main_2_StreamOrnek {

	public static void main(String[] args) {

		List<Integer> sayilar = new ArrayList<>(Arrays.asList(5, 55, 60, 12, 97, 77));

		// sayilar listenin içinden 5 e bölüneneleri listeye at
		List<Integer> beseBolunen = sayilar.stream().filter(x -> x % 5 == 0).toList();
		System.out.print("beseBolunen \t=> ");
		beseBolunen.forEach(x -> System.out.print(x + " "));
		System.out.println();

		// sayilari kendisiyle çarpıp listeye at
		List<Integer> sayilarKare = sayilar.stream().map(x -> x*x).toList();
		System.out.print("sayilarKare \t=> ");
		sayilarKare.forEach(x -> System.out.print(x + " "));
		System.out.println();
		
		// Kaç tane 5 e bölünen sayı var
		System.out.println("Beşe bölünen sayıların adedi => " + sayilar.stream().filter(x -> x % 5 == 0).count());
	}

}
