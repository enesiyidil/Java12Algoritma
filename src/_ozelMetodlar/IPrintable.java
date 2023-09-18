package _ozelMetodlar;

import java.util.List;
import java.util.function.Function;

public interface IPrintable<R> {

	<T> void printTable(String title, String[] headerNames, List<T> list, List<Function<T, String>> functions);
	
	<T> void printTable(String title, String[] headerNames, List<T> list, @SuppressWarnings("unchecked") Function<T, String>... functions);
	
	<T> void printTable(String title, List<T> list, Function<T, String>[] functions);
}
