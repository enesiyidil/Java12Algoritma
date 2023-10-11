package dersler.ders020.StreamUygulama;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Market {

	static Scanner scanner = new Scanner(System.in);

	List<Urun> productList;
	Map<String, Double> urunlerMap;
	Map<String, Integer> sepet;

	public Market() {
		uruleriOlustur();
		urunlerVeFiyatListesiOlustur();
		sepet = new LinkedHashMap<>();
	}

	public void uruleriOlustur() {
		productList = Stream.of(EUrun.values()).map(e -> new Urun(e.name(), e.getPrice())).collect(Collectors.toList());
	}

	public void urunlerVeFiyatListesiOlustur() {
		urunlerMap = productList.stream().collect(Collectors.toMap(Urun::getName, Urun::getPrice));
	}

	public void urunlerVeFiyatListesiGoster() {
		urunlerMap.forEach((k, v) -> System.out.println(k + " \tFiyatı ---> " + v));
	}

	public void sepeteUrunEkle() {
		urunlerVeFiyatListesiGoster();

		System.out.print("Hangi ürünü almak istiyorsun: ");
		String urunAdi = scanner.nextLine().toUpperCase();

		if (urunlerMap.containsKey(urunAdi)) {
			sepet.put(urunAdi, sepet.getOrDefault(urunAdi, 0) + 1);
		} else {
			System.out.println("Yanlış ürün girdiniz");
		}
		sepetiGoster();
	}

	public void sepetiGoster() {
		sepet.forEach((k, v) -> System.out.println(k + " \tAdet ---> " + v));
		sepetTutar();
	}

	public void sepetTutar() {
		double tutar = sepet.keySet().stream().map(k -> urunlerMap.get(k) * sepet.get(k))
				.collect(Collectors.summarizingDouble(Double::doubleValue)).getSum();
		System.out.println(tutar);
		tutar = sepet.keySet().stream().mapToDouble(k -> urunlerMap.get(k) * sepet.get(k))
				.sum();
		System.out.println(tutar);
	}

	public void ortalamaAl() {
		double ortEllidenBuyuk = productList.stream().filter(u -> u.getPrice() < 50).map(u -> u.getPrice())
				.collect(Collectors.summarizingDouble(Double::doubleValue)).getAverage();

		System.out.println(ortEllidenBuyuk);
		
		ortEllidenBuyuk = productList.stream().filter(u -> u.getPrice() < 50).mapToDouble(u -> u.getPrice()).average().orElse(0.0);
		System.out.println(ortEllidenBuyuk);
	}
}
