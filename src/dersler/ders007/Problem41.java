/**
 * 
 */
package dersler.ders007;

/**
 * Dizideki en büyük ikinci sayıyı bulalım
 */
public class Problem41 {

	public static void main(String[] args) {
		
		int[] sayilar = { 0, 120, -5, -85, -256, 16, 1258, 81, 14 };
		
		int max = Integer.MIN_VALUE, max2 = 0;
		
		for(int i : sayilar) {
			if(max < i) {
				max2 = max;
				max = i;
			}else if(max2 < i && i != max) {
				max2 = i;
			}
		}
		System.out.println(max2);

	}

}
