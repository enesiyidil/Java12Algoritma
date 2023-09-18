package dersler;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class deneme {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Bir veri girin: ");

		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<String> future = executor.submit(() -> scanner.nextLine());

		try {
			String input = future.get(5, TimeUnit.SECONDS); // 5 saniye içinde giriş bekler
			System.out.println("Girilen veri: " + input);
		} catch (TimeoutException e) {
			System.out.println("Zaman aşımına uğrandı.");
			future.cancel(true); // Zaman aşımı durumunda görevi iptal et
			System.out.println("--");
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} finally {
			System.out.println("----");
			executor.shutdownNow();
			scanner.close();
		}
		System.out.println("------");// Bu kısım çalışmıyor
	}

}
