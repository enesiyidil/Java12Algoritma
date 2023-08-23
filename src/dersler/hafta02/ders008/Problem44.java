/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.hafta02.ders008;

/**
 * Tekrar eden sayı var mı
 */
public class Problem44 {
	
public static void main(String[] args) {
		
		int[] sayilar = {1, -26, -256, 2, 1258, 32};
		boolean tekrarVarMi = false;
		
		for(int i = 0; i < sayilar.length - 1; i++) {
			if(sayilar[i] == sayilar[i +1]) {
				tekrarVarMi = true;
				break;
			}
		}
		System.out.println(tekrarVarMi);

	}

}
