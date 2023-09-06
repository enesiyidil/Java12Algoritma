package dersler.hafta04.ders013.product.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerateID {

	private static List<String> idList = new ArrayList<>();
	private static Random rnd = new Random();
	
	public static String generateId() {
		
		boolean isThere = true;
		String id = "";
		do {
			id = rnd.nextInt(1000, 100000) + "";
			if(idList.isEmpty()) {
				break;
			}
			for (String string : idList) {
				if(id.equals(string)) {
					isThere = true;
					break;
				}else {
					isThere = false;
				}
			}
		} while (isThere);
		idList.add(id);
		return id;	
	}
	
	public static String generateProductCode(String isim) {
		return isim.substring(0, 3) + rnd.nextInt(1000, 10000);
	}
}
