package _ozelMetodlar;

import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;

public class ListeYazdir {

	public static <T> String listeYazdir(List<T> list, String... propertyNames)
			throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {

		if (list.isEmpty()) {
			return "List is empty.";
		}

		DecimalFormat df = new DecimalFormat("0.##");
		StringBuilder result = new StringBuilder();
		String pipe = colorize("|", Color.CYAN);
		String plus = colorize("+", Color.CYAN);
		String minus = colorize("-", Color.CYAN);
		int[] columnWidths = new int[propertyNames.length + 1];
		List<String> tempData = new ArrayList<>();
		List<Double> sumList = new ArrayList<>();

		columnWidths[0] = 3;

		for (int i = 0; i < propertyNames.length; i++) {
			sumList.add(0.0);
			columnWidths[i + 1] = propertyNames[i].length();
		}

		for (T item : list) {
			for (int i = 0; i < propertyNames.length; i++) {
				boolean isTherePlus = false;
				if (propertyNames[i].contains("+")) {
					propertyNames[i] = propertyNames[i].replace("+", "");
					isTherePlus = true;
				}
				String propertyName = propertyNames[i];
				Method method = item.getClass()
						.getMethod("get" + propertyName);
				String propertyValue = method.invoke(item).toString();
				tempData.add(propertyValue);
				columnWidths[i + 1] = Math.max(columnWidths[i + 1], propertyValue.length());
				if (isTherePlus) {
					double sum = Double.parseDouble(propertyValue) + sumList.get(i);
					sumList.remove(i);
					sumList.add(i, sum);
					propertyNames[i] = propertyNames[i] + "+";
					columnWidths[i + 1] = Math.max(columnWidths[i + 1], df.format(sum).length());
				}
			}
		}

		result.append(pipe);
		result.append(String.format(" %-" + 12 + "s " + pipe, colorize("No", Color.RED)));
		for (int i = 0; i < propertyNames.length; i++) {
			if (propertyNames[i].contains("+")) {
				propertyNames[i] = propertyNames[i].replace("+", "");
			}
			result.append(String.format(" %-" + (columnWidths[i + 1] + 9) + "s " + pipe,
					colorize(propertyNames[i], Color.RED)));
		}
		result.append("\n");

		result.append(pipe);
		for (int i = 0; i < propertyNames.length + 1; i++) {
			for (int j = 0; j < columnWidths[i] + 2; j++) {
				result.append(minus);
			}
			result.append((i != propertyNames.length) ? plus : pipe);
		}
		result.append("\n");

		int index = 0;
		for (int i = 0; i < list.size(); i++) {
			result.append(pipe);
			result.append(String.format(" %-" + 3 + "s " + pipe, (i + 1)));
			for (int j = 0; j < propertyNames.length; j++) {
				result.append(String.format(" %-" + columnWidths[j + 1] + "s " + pipe, tempData.get(index)));
				index++;
			}
			result.append("\n");
		}
		result.append(pipe);
		for (int i = 0; i < propertyNames.length + 1; i++) {
			for (int j = 0; j < columnWidths[i] + 2; j++) {
				result.append(minus);
			}
			result.append((i != propertyNames.length) ? plus : pipe);
		}
		result.append("\n");
		result.append(pipe);
		result.append(String.format(" %-" + 3 + "s " + pipe, list.size()));
		for (int j = 0; j < sumList.size(); j++) {
			String temp = (sumList.get(j) == 0) ? "-" : df.format(sumList.get(j));
			result.append(String.format(" %-" + columnWidths[j + 1] + "s " + pipe, temp));
		}
		result.append("\n");

		return result.toString();
	}

	public static String colorize(String text, Color color) {
		return "\u001B[" + color.code + "m" + text + "\u001B[0m";
	}

	enum Color {
		BLACK("30"), RED("31"), GREEN("32"), YELLOW("33"), BLUE("34"), MAGENTA("35"), CYAN("36"), WHITE("37");

		private final String code;

		Color(String code) {
			this.code = code;
		}
	}
}
