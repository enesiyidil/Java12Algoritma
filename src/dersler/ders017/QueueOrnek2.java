package dersler.ders017;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueOrnek2 {

	public static void main(String[] args) {
		
		Queue<Musteri> kuyruk = new PriorityQueue<Musteri>(Comparator.comparing(Musteri::getYas).reversed());
		kuyruk.add(new Musteri("Ali", 45));
		kuyruk.add(new Musteri("Veli", 65));
		kuyruk.add(new Musteri("Zeynep", 18));
		kuyruk.add(new Musteri("Hasan", 47));
		kuyruk.add(new Musteri("Murat", 33));
		
		while (kuyruk.iterator().hasNext()) {
			System.out.println(kuyruk.poll());
		}
		
		System.out.println(
				"--------------------------------------------------------------------------------------------------------");
		
		Queue<Musteri> kuyruk2 = new PriorityQueue<Musteri>();
		kuyruk2.add(new Musteri("Ali", 45));
		kuyruk2.add(new Musteri("Veli", 65));
		kuyruk2.add(new Musteri("Zeynep", 18));
		kuyruk2.add(new Musteri("Hasan", 47));
		kuyruk2.add(new Musteri("Murat", 33));
		
		while (kuyruk2.iterator().hasNext()) {
			System.out.println(kuyruk2.poll());
		}
	}

}
