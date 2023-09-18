package _ozelMetodlar;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Tablo şeklindeki listeleri daha güzel bir biçimde yazdırmak için yardımcı
 * olan sınıftır.
 */
public class TableManager {

	private DecimalFormat df = new DecimalFormat("0.##");

	private List<String> table;
	private List<Double> sumList;
	private List<Integer> sumIndex;

	private int index;
	private int[] columnWidths;

	private final String START_EXP = "Table_Start";
	private final String END_EXP = "Table_End";

	/**
	 * Başlangıç için "Table_Start" ve bitiş için "Table_End" alan ve bu iki değer
	 * arasında aldığı değerleri listede tutan ve daha sonra tablo olarak yazan
	 * metot.
	 * 
	 * @param <T>
	 * @param value     Generic değer (Başlangıç için "Table_Start" ve bitiş için
	 *                  "Table_End")
	 * @param tableName String türünde tablo başlığı ifadesi
	 * @param titles    String[] türünde tablonun üst kısmı
	 */
	public <T> void printTable(T value, String tableName, String... titles) {

		if (value.equals(START_EXP)) {
			table = new ArrayList<>();
			sumList = new ArrayList<>();
			sumIndex = new ArrayList<>();
			index = 0;
			columnWidths = new int[titles.length + 1];

			for (int i = 0; i < titles.length; i++) {
				if (titles[i].contains("+")) {
					sumIndex.add(i);
					titles[i] = titles[i].replace("+", "");
				}
				sumList.add(0.0);
				columnWidths[i + 1] = titles[i].length();
			}
			return;
		} else if (value.equals(END_EXP)) {
			print(tableName, titles);
		} else {
			String temp = "";

			if (value instanceof Integer || value instanceof Double) {
				for (int i = 0; i < sumIndex.size(); i++) {
					if (sumIndex.get(i) == index) {
						double sumTemp = sumList.get(index) + (double) value;
						sumList.remove(index);
						sumList.add(index, sumTemp);
						break;
					}
				}
				temp = df.format(value);
			} else if (value instanceof String) {
				temp = (String) value;
			} else {
				temp = value + "";
			}
			index++;
			if (titles.length == index) {
				index = 0;
			}
			addValueToTable(temp);
		}
	}

	private void addValueToTable(String value) {
		table.add(value);
	}

	private void print(String tableName, String... titles) {

		StringBuilder result = new StringBuilder();
		String pipe = colorize("|", EColor.CYAN);
		String plus = colorize("+", EColor.CYAN);
		String minus = colorize("-", EColor.CYAN);

		columnWidths[0] = ((table.size() / titles.length) + "").length();
		columnWidths[0] = (columnWidths[0] < 3) ? 3 : columnWidths[0];

		for (int i = 1; i < columnWidths.length; i++) {
			for (int j = i - 1; j < table.size(); j += titles.length) {
				columnWidths[i] = Math.max(columnWidths[i], table.get(j).length());
				columnWidths[i] = Math.max(columnWidths[i], df.format(sumList.get(i - 1)).length());
			}
		}

		int sumTotal = 0;
		result.append(pipe);
		for (int i = 0; i < titles.length + 1; i++) {
			for (int j = 0; j < columnWidths[i] + 2; j++) {
				result.append(minus);
				sumTotal++;
			}
			result.append((i != titles.length) ? minus : pipe);
		}
		result.append("\n");
		sumTotal += titles.length - 1;
		result.append(pipe);
		result.append(String.format(" %-" + (sumTotal + 9) + "s" + pipe, colorize(tableName, EColor.GREEN)));
		result.append("\n");

		result.append(pipe);
		for (int i = 0; i < titles.length + 1; i++) {
			for (int j = 0; j < columnWidths[i] + 2; j++) {
				result.append(minus);
			}
			result.append((i != titles.length) ? plus : pipe);
		}
		result.append("\n");

		result.append(pipe);
		result.append(String.format(" %-" + (columnWidths[0] + 9) + "s " + pipe, colorize("No", EColor.RED)));
		for (int i = 0; i < titles.length; i++) {
			if (titles[i].contains("+")) {
				titles[i] = titles[i].replace("+", "");
			}
			result.append(
					String.format(" %-" + (columnWidths[i + 1] + 9) + "s " + pipe, colorize(titles[i], EColor.RED)));
		}
		result.append("\n");

		result.append(pipe);
		for (int i = 0; i < titles.length + 1; i++) {
			for (int j = 0; j < columnWidths[i] + 2; j++) {
				result.append(minus);
			}
			result.append((i != titles.length) ? plus : pipe);
		}
		result.append("\n");

		int indexTemp = 0;
		for (int i = 0; i < (table.size() / titles.length); i++) {
			result.append(pipe);
			result.append(String.format(" %-" + 3 + "s " + pipe, (i + 1)));
			for (int j = 0; j < titles.length; j++) {
				result.append(String.format(" %-" + columnWidths[j + 1] + "s " + pipe, table.get(indexTemp)));
				indexTemp++;
			}
			result.append("\n");
		}
		result.append(pipe);
		for (int i = 0; i < titles.length + 1; i++) {
			for (int j = 0; j < columnWidths[i] + 2; j++) {
				result.append(minus);
			}
			result.append((i != titles.length) ? plus : pipe);
		}
		result.append("\n");
		result.append(pipe);
		result.append(String.format(" %-" + 3 + "s " + pipe, (table.size() / titles.length)));
		for (int j = 0; j < sumList.size(); j++) {
			String temp = (sumList.get(j) == 0) ? "-" : df.format(sumList.get(j));
			result.append(String.format(" %-" + columnWidths[j + 1] + "s " + pipe, temp));
		}
		result.append("\n");

		System.out.println(result.toString());
	}

	private String colorize(String text, EColor color) {
		return color.code + text + EColor.RESET.code;
	}

}
