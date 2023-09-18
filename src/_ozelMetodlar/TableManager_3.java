package _ozelMetodlar;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class TableManager_3 {

	private DecimalFormat df = new DecimalFormat("#,###.00");

	private List<String> data;
	private List<Double> sumList;
	private int[] columnWidths;
	private int[] indexes;

	@SafeVarargs
	public final <T> void printTable(String title, String[] headerNames, List<T> list,
			Function<T, Object>... functions) {

		data = new ArrayList<String>();
		sumList = new ArrayList<Double>();
		columnWidths = new int[headerNames.length + 1];
		indexes = new int[headerNames.length];

		for (int i = 1; i <= headerNames.length; i++) {
			if (headerNames[i - 1].contains("+")) {
				indexes[i - 1] = 1;
				headerNames[i - 1] = headerNames[i - 1].replace("+", "");
			}
			columnWidths[i] = headerNames[i - 1].length();
			sumList.add(0.0);
		}

		for (T item : list) {

			int index = 0;

			for (Function<T, Object> function : functions) {

				Object result = function.apply(item);
				String tempData = "";

				if (result instanceof Integer || result instanceof Double) {
					if (indexes[index] == 1) {
						double sumTemp = sumList.get(index) + (double) result;
						sumList.set(index, sumTemp);
					}
					tempData = df.format((double)result);
				} else {
					tempData = result + "";
				}
				data.add(tempData);
				index++;
			}
		}
		print(title, headerNames);
	}

	private void print(String tableName, String[] titles) {

		StringBuilder result = new StringBuilder();
		String pipe = colorize("|", EColor.CYAN);
		String plus = colorize("+", EColor.CYAN);
		String minus = colorize("-", EColor.CYAN);

		columnWidths[0] = ((data.size() / titles.length) + "").length();
		columnWidths[0] = (columnWidths[0] < 3) ? 3 : columnWidths[0];

		for (int i = 1; i < columnWidths.length; i++) {
			for (int j = i - 1; j < data.size(); j += titles.length) {
				columnWidths[i] = Math.max(columnWidths[i], data.get(j).length());
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
		for (int i = 0; i < (data.size() / titles.length); i++) {
			result.append(pipe);
			result.append(String.format(" %-" + 3 + "s " + pipe, (i + 1)));
			for (int j = 0; j < titles.length; j++) {
				result.append(String.format(" %-" + columnWidths[j + 1] + "s " + pipe, data.get(indexTemp)));
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
		result.append(String.format(" %-" + 3 + "s " + pipe, (data.size() / titles.length)));

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
