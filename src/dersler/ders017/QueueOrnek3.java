package dersler.ders017;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueOrnek3 {

	public static void main(String[] args) {

		Queue<Hasta> kuyruk = new PriorityQueue<>();
		kuyruk.add(new Hasta("Ali", EHastalik.APANDIS));
		kuyruk.add(new Hasta("Mehmet", EHastalik.BAS_AGRISI));
		kuyruk.add(new Hasta("Hasan", EHastalik.YANIK));
		kuyruk.add(new Hasta("Veli", EHastalik.KULAK));
		kuyruk.add(new Hasta("İrem", EHastalik.APANDIS));
		kuyruk.add(new Hasta("Pınar", EHastalik.BAS_AGRISI));
		kuyruk.add(new Hasta("Hasan", EHastalik.BOGAZ));
		kuyruk.add(new Hasta("Veli", EHastalik.BAS_AGRISI));
		kuyruk.add(new Hasta("İrem", EHastalik.BAS_AGRISI));
		kuyruk.add(new Hasta("Pınar", EHastalik.BAS_AGRISI));
		
		while (kuyruk.iterator().hasNext()) {
			System.out.println(kuyruk.poll());
		}
	}

}
