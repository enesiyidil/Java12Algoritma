/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.hafta02.ders007;

/**
 * Dizi içerisinde eleman saydırma
 */
public class Problem39 {

	public static void main(String[] args) {
		
		int[] array = { 1, 4, 4, 2, 4, 4, 2, 2, 9, 2, 8, 4};
		
		int dortler = 0, ikiler = 0;
		
		for(int i : array) {
			if(i == 2) {
				ikiler++;
			}else if(i == 4) {
				dortler++;
			}
		}
		if(ikiler > dortler) {
			System.out.println("2'ler 4'lerden fazla. 2'ler -> " + ikiler + ", 4'ler -> " + dortler);
		}else if(dortler > ikiler) {
			System.out.println("4'ler 2'lerden fazla. 2'ler -> " + ikiler + ", 4'ler -> " + dortler);
		}else {
			System.out.println("2'ler 4'lere eşit. 2'ler -> " + ikiler + ", 4'ler -> " + dortler);
		}

	}

}
