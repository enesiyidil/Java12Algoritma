package dersler.ders017;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class QueueOrnek {

	public static void main(String[] args) {

		Random rnd = new Random();
		Queue<String> queue = new LinkedList<String>();
		queue.add("Ahmet");
		queue.add("Mehmet");
		queue.add("Ali");
		queue.add("İrem");
		queue.add("Can");
		queue.add("Su");
		queue.add("Pınar");
		queue.add("Tuğçe");
		queue.add("Melih");
		queue.add("Kenan");

		for (int i = 0; i < rnd.nextInt(1, 11); i++) {
			queue.poll();
		}
		System.out.println("Hediye çeki alamayanlar => " + queue);
	}

}
