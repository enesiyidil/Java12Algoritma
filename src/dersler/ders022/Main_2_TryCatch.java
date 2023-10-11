package dersler.ders022;

public class Main_2_TryCatch {

	public static void main(String[] args) {

		String[] array = { "6", "10", "bc", "55", "20", null };

		int toplam = 0, hata = 0;
		for (String item : array) {
			
			if(item == null) 
				throw new NullPointerCheck("NULL olamaz");

			try {
				toplam += Integer.parseInt(item);
			} catch (Exception e) {
				hata++;
			}
		}
		System.out.println("Toplam: " + toplam);
		System.out.println("Hatalar: " + hata);
	}

}

class NullPointerCheck extends NullPointerException{

	private static final long serialVersionUID = 1L;
	
	public NullPointerCheck(String message) {
		super(message);
	}
	public NullPointerCheck() {
		super();
	}
}
