package dersler.ders013.homework.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Bu sınıfın
 */
public class RandomGenerate {

	private static List<String> idList = new ArrayList<>();
	private static Random rnd = new Random();

	public static String id() {

		boolean isThere = true;
		String id = "";
		do {
			id = rnd.nextInt(1000, 100000) + "";
			if (idList.isEmpty()) {
				break;
			}
			for (String string : idList) {
				if (id.equals(string)) {
					isThere = true;
					break;
				} else {
					isThere = false;
				}
			}
		} while (isThere);
		idList.add(id);
		return id;
	}

	public static String productCode(String name, String id) {
		return ((name.length() > 3) ? name.substring(0, 3) : name) + id;
	}
}
