package _ozelMetodlar;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class TableManager_2<R> implements IPrintable<R>{

	List<String> data = new ArrayList<String>();
	
	@Override
	public <T> void printTable(String title, String[] headerNames, List<T> list, List<Function<T, String>> functions) {
		
		for (Function<T, String> function : functions) {
			for (T item : list) {
				String result =function.apply(item);
				data.add(result + "");
			}
		}
		for (String item : data) {
			System.out.println(item);
		}
	}

	@Override
	public <T> void printTable(String title, String[] headerNames, List<T> list, @SuppressWarnings("unchecked") Function<T, String>... functions) {
		for (Function<T, String> function : functions) {
			for (T item : list) {
				String result =function.apply(item);
				data.add(result + "");
			}
		}
		for (String item : data) {
			System.out.println(item);
		}
	}

	@Override
	public <T> void printTable(String title, List<T> list, Function<T, String>[] functions) {
		for (Function<T, String> function : functions) {
			for (T item : list) {
				String result =function.apply(item);
				data.add(result + "");
			}
		}
		for (String item : data) {
			System.out.println(item);
		}
	}

	


}
