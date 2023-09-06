package projeler.hesapMakinesi_v002;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 */
public class Runner {

	public static void main(String[] args) throws FileNotFoundException {
		
		description();

	}

	private static void description() throws FileNotFoundException {
		File file = new File("C:\\Users\\enesb\\Documents\\Java12BilgeAdamBoost\\Java12\\Java12AlgoritmaSorulari\\src\\projeler\\hesapMakinesi\\Description.txt");
		Scanner scannerTxt = new Scanner(file);
		
		System.out.println("\u001B[35m" + "**************************************************" + "\u001B[0m");
		while (scannerTxt.hasNextLine()) {
	        String data = scannerTxt.nextLine();
	        System.out.println(data);
	      }
		scannerTxt.close();
		System.out.println("\u001B[35m" + "**************************************************" + "\u001B[0m");
	}
}
