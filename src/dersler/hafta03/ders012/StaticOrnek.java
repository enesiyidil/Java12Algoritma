package dersler.hafta03.ders012;

/**
 * 
 */
public class StaticOrnek {

	int number1;
	static int number2;

	public void numberVer() {
		System.out.println("Numara ver metodu");
		number1++;
		number2++;
		System.out.println("Number 1: " + number1);
		System.out.println("Number 2: " + number2);
	}
	
	public static void numaraVer2() {
		System.out.println("Numara ver metodu");
		// static bir metot içinde static olmayan bir özellik direkt olarak kullanılmaz
		//number1++; 
		number2++;
		//System.out.println("Number 1: " + number1);
		System.out.println("Number 2: " + number2);
	}
	
	public static void main(String[] args) {
		
		number2 = 5;
	}
}
