package dersler.ders025;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

public class Main_Taksi {
	private static Queue<Integer> musteri = new ArrayDeque<>();

	public static synchronized Integer getMusteri() {
		return musteri.poll();

	}

	public static void main(String[] args) {

		for (int i = 1; i <= 100; i++) {
			musteri.add(i);
		}
		List<Taksi> taksiler = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			taksiler.add(new Taksi());
			taksiler.get(i).start();

		}

	}

}