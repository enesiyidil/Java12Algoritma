package dersler.ders025;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//* Durağımızda toplam 10 adet taksi olsun ve durak onunde 100 kişilik
// * bir müşteri kuygrugu(queue) olsun bu musterilerimiz için sınıf yaratmayalım
// * bir int bir id değeri olarak tutalım
// *
// * 10 adet taksimiz hızlarına göre kuyruktan sırayla musteri alacaklardır

// Takside run methodunu override edelim
// taksilere müşteri alcaz
// müşterileri duraktaki kuyruktan alcaz
// ve aldığımız müşterileri listeye atıcaz
// taksini her müşteri aldığında hangi taksinin kaçıncı müşterisini aldığını
// yazdıralım
public class Taksi extends Thread {

	private static Integer taksiSayisi = 0;
	private Integer musteriSayisi = 0;
	private String isim;
	private List<Integer> musteriler = new ArrayList<>();
	Random rnd = new Random();

	public Taksi() {
		super();
		taksiSayisi++;
		isim = taksiSayisi + ". taksi ";
	}

	@Override
	public void run() {

		while (true) {

			Integer musteri = Main_Taksi.getMusteri();
			if (musteri == null) {
				break;
			}
			musteriler.add(musteri);
			musteriSayisi++;
			System.out.println(isim + " -->  " + musteriSayisi + ".musterisini aldı.--> " + musteri);
			int sure = rnd.nextInt(100);

			try {
				Thread.sleep(sure);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}
		System.out.println(isim + " toplam " + musteriSayisi + " aldı.");

	}

	public static Integer getTaksiSayisi() {
		return taksiSayisi;
	}

	public static void setTaksiSayisi(Integer taksiSayisi) {
		Taksi.taksiSayisi = taksiSayisi;
	}

	public Integer getMusteriSayisi() {
		return musteriSayisi;
	}

	public void setMusteriSayisi(Integer musteriSayisi) {
		this.musteriSayisi = musteriSayisi;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public List<Integer> getMusteriler() {
		return musteriler;
	}

	public void setMusteriler(List<Integer> musteriler) {
		this.musteriler = musteriler;
	}

	public Random getRnd() {
		return rnd;
	}

	public void setRnd(Random rnd) {
		this.rnd = rnd;
	}

}