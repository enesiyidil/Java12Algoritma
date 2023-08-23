/**
 * 
 */
package projeler.hesapMakinesi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import projeler.hesapMakinesi.functions.*;

/**
 * 
 */
public class Calculator_v008 {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scanner = new Scanner(System.in);
		File file = new File("C:\\Users\\enesb\\Documents\\Java12BilgeAdamBoost\\Java12\\Java12AlgoritmaSorulari\\src\\projeler\\hesapMakinesi\\Description.txt");
		Scanner scannerTxt = new Scanner(file);
		
		System.out.println("\u001B[35m" + "**************************************************" + "\u001B[0m");
		while (scannerTxt.hasNextLine()) {
	        String data = scannerTxt.nextLine();
	        System.out.println(data);
	      }
		scannerTxt.close();
		System.out.println("\u001B[35m" + "**************************************************" + "\u001B[0m");
		
		while(true) {
			CalculatorMain.calculator(scanner);
		}

	}

}
