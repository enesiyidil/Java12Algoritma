package dersler.ders028;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Ogretmen extends Thread {

	private BufferedReader reader;
	private String isim;
	private int hiz;
	private List<Ogrenci> okunanOgrenciler = new ArrayList<>();
	Random rnd = new Random();

	public Ogretmen(String isim, BufferedReader reader) {
		super();
		this.isim = isim;
		this.reader = reader;
		this.hiz = rnd.nextInt(1000,5000);
	}
	
	@Override
	public void run() {
		String satir;
		try {
			while ((satir = reader.readLine()) != null) {
				Ogrenci ogrenci = new Ogrenci(satir.split(",")[0], Arrays.stream(satir.split(",")).skip(1)
						.mapToDouble(Double::parseDouble).average().orElse(0));
				okunanOgrenciler.add(ogrenci);
				System.out.println(isim+" adlı öğretmen "+ogrenci.getName()+" adlı öğrencinin kağıdını okudu");
				Thread.sleep(hiz);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	public BufferedReader getReader() {
		return reader;
	}
	public void setReader(BufferedReader reader) {
		this.reader = reader;
	}
	public String getIsim() {
		return isim;
	}
	public void setIsim(String isim) {
		this.isim = isim;
	}
	public int getHiz() {
		return hiz;
	}
	public void setHiz(int hiz) {
		this.hiz = hiz;
	}
	public List<Ogrenci> getOkunanOgrenciler() {
		return okunanOgrenciler;
	}
	public void setOkunanOgrenciler(List<Ogrenci> okunanOgrenciler) {
		this.okunanOgrenciler = okunanOgrenciler;
	}
	public Random getRnd() {
		return rnd;
	}
	public void setRnd(Random rnd) {
		this.rnd = rnd;
	}
	
}
