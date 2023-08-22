/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.ders004;

import java.util.Scanner;
import java.util.Arrays;

/**
 * 
 */
public class Problem28 {
	
	static double hesap(char islemTuru, double sayi1, double sayi2) {
		return switch (islemTuru) {
		case '+' -> {
			yield sayi1 + sayi2;
		}case '-' -> {
			yield sayi1 - sayi2;
		}case '*' -> {
			yield sayi1 * sayi2;
		}case '/' -> {
			yield sayi1 / sayi2;
		}
		default -> 0;
		};
	}
	static int stringIfadedeKarakterSayaci(String Ifade, char karakter) {
        int sayac = 0;
        for (char c : Ifade.toCharArray()) {
            if (c == karakter) {
            	sayac++;
            }
        }
        return sayac;
    }
	static double[] diziElemanSilmeDouble(double[] dizi, int silinecekIndex) {
        double[] diziGecici = new double[dizi.length-1];
        for(int i=0, k=0;i<dizi.length;i++){
            if(i!=silinecekIndex){
            	diziGecici[k]=dizi[i];
                k++;
            }
        }
            return diziGecici;
        }
	static char[] diziElemanSilmeChar(char[] dizi, int silinecekIndex) {
        char[] diziGecici = new char[dizi.length-1];
        for(int i=0, k=0;i<dizi.length;i++){
            if(i!=silinecekIndex){
            	diziGecici[k]=dizi[i];
                k++;
            }
        }
            return diziGecici;
        }

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String[] operators = new String[] {"-","\\+","/","\\*","x","\\^","X","\\(","\\)"};
		String operatorRegex = String.join("|", operators);
		/*
		 * Bir regex deseni, özel karakterler (meta karakterler) ve normal karakterlerin 
		 * kombinasyonlarından oluşur. Bu özel karakterler, desenin davranışını belirler.
		 */
		
		System.out.println("İşlemi giriniz ( * / - + ).");
		String islem = scanner.next();
		
		//String[] sayilar = islem.split(operatorRegex);
		//int[] sayilar = Arrays.stream(islem.split(operatorRegex)).mapToInt(Integer::parseInt).toArray();
		double[] sayilar = Arrays.stream(Arrays.stream(islem.split(operatorRegex)).mapToInt(Integer::parseInt).toArray()).asDoubleStream().toArray();
		System.out.println("Kullanıcı sayıları : " + Arrays.toString(sayilar));
		char[] islemler = islem.replaceAll("[0-9]", "").toCharArray();
		System.out.println("Kullanıcı işlemleri : " + Arrays.toString(islemler));
		
		double sonuc;
		int sayiIndex = 1;
		
		
		if(islem.contains("*") || islem.contains("/")) {
			for(int i = 0; i < islemler.length; i++) {
				double sonucDegisen;
				if(islemler[i] == '*' || islemler[i] == '/') {
					sonucDegisen = hesap(islemler[i], sayilar[i], sayilar[i + 1]);
					sayilar[i] = sonucDegisen;
					sayilar = diziElemanSilmeDouble(sayilar, i + 1);
					islemler = diziElemanSilmeChar(islemler, i);
					i--;
					System.out.println("Kullanıcı sayıları : " + Arrays.toString(sayilar));
					System.out.println("Kullanıcı işlemleri : " + Arrays.toString(islemler));
				}
			}	
		}
		sonuc = sayilar[0];
		for(char i: islemler) {
			sonuc = hesap(i, sonuc, sayilar[sayiIndex]);
			sayiIndex++;
		}
		
		
		System.out.println(sonuc);
		scanner.close(); // scaner nesnesi kapandı
	}

}
