/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.hafta02.ders008;

/**
 * Dizide 13 ve bir sonraki eleman hariç diğer elemanların toplamı
 */
public class Problem47 {

	public static void main(String[] args) {
	
		int sayilar[] = { 1, 13, 13, 13, 2, 5, 13, 1 };
		
		int temp = 0, toplam = 0;
		for (int i : sayilar) {
			if(temp != 13 && i != 13) {
				toplam += i;
				System.out.print(i + " ");
			}
			temp = i;
		}
		System.out.println("-> Toplam : " + toplam);

	}

}
