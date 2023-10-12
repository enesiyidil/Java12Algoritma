package dersler.ders025;

public class Main {

	public static void main(String[] args) {

		Kosucu kosucu1 = new Kosucu("Mehmet");
		Kosucu kosucu2 = new Kosucu("Ahmet");

		kosucu1.start();
		kosucu2.start();

		try {
			kosucu1.join();
			kosucu2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Kazanan : " + (kosucu1.getSure() < kosucu2.getSure() ? kosucu1.getNameRunner()
				: kosucu2.getSure() < kosucu1.getSure() ? kosucu2.getNameRunner() : "berabere"));
	}

}
