/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.ders006;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Kullanıcıdan alınan kelime harfa göre sayım yapan program
 */
public class Problem35 {
	
	static int stringCharCounter(String text, char character) {
        int coun = 0;
        for (char c : text.toCharArray()) {
            if (c == character) {
            	coun++;
            }
        }
        return coun;
    }

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		boolean loop = true;
		while(loop) {
			System.out.println("\u001B[35m" + "=====String İşlemler=====" + "\u001B[0m");
			System.out.println("\u001B[36m" + "1- Harf Saydırma");
			System.out.println("2- Harf Değiştirme");
			System.out.println("3- Palindrom kontrol");
			System.out.println("4- Her Harf Arasına ? İşareti Koyma");
			System.out.println("5- Kelime Karakter Gizle");
			System.out.println("6- Kelimenin Ilk 3 Harfindeki Sonraki Harfleri Gizleme");
			System.out.println("0- Çıkış" + "\u001B[0m");
			
			int secim = scanner.nextInt();
			String kelime;
			char harf;
			switch (secim) {
			case 1:
				System.out.println("\u001B[33m" + "Lütfen bir kelime giriniz:" + "\u001B[0m");
				kelime =scanner.next();
				
				System.out.println("\u001B[33m" + "Hangi harfi saymak istiyorsunuz" + "\u001B[0m");
				harf = scanner.next().toCharArray()[0];
				
				if(kelime.contains(harf + "")) {
					int harfSayisi = 0;
					int[] index = new int[stringCharCounter(kelime, harf)];
					String indexStr = "";
					
					for(int i = 0; i < kelime.length(); i++) {
						if(kelime.charAt(i) == harf) {
							index[harfSayisi] = i;
							indexStr += i + ",";
							harfSayisi++;
						}
					}
					System.out.println("\u001B[32m" + harf + " harfi kelime içerisinde " + harfSayisi + " adet bulunmaktadır.");
					System.out.println(harf + " harfinin indexleri ==> " + Arrays.toString(index));
					System.out.println(harf + " harfinin indexleri ==> " + indexStr.substring(0, indexStr.length() - 1) + "\u001B[0m");
					
				}else {
					System.out.println("\u001B[31m" + "Aradığınız harf bulunmuyor" + "\u001B[0m");
				}
				break;
				
			case 2:
				System.out.println("\u001B[33m" + "Lütfen bir kelime giriniz:" + "\u001B[0m");
				kelime =scanner.next();
				
				System.out.println("\u001B[33m" + "Hangi harfi değiştirmek istiyorsunuz" + "\u001B[0m");
				harf = scanner.next().toCharArray()[0];
				
				if(kelime.contains(harf + "")) {
					System.out.println("\u001B[33m" + "Hangi harf ile değişecek" + "\u001B[0m");
					char harfDegistirme = scanner.next().toCharArray()[0];
					
					kelime = kelime.replace(harf, harfDegistirme);
					System.out.println("\u001B[32m" + kelime + "\u001B[0m");
				}else {
					System.out.println("\u001B[31m" + harf + " harfi kelime içerisinde mevcut değil." + "\u001B[0m");
				}
				break;
				
			case 3:
				
				System.out.println("\u001B[33m" + "Lütfen bir kelime giriniz:" + "\u001B[0m");
				kelime = scanner.next();
				
				StringBuilder kelimeTers = new StringBuilder(kelime);
				kelimeTers.reverse();
				
				if(kelime.equals(kelimeTers.toString())) {
					System.out.println("\u001B[32m" + "Girilen kelime palindromdur." + "\u001B[0m");
				}else {
					System.out.println("\u001B[31m" + "Girilen kelime palindrom değildir." + "\u001B[0m");
				}
				break;
				
			case 4:
				System.out.println("\u001B[33m" + "Lütfen bir kelime giriniz:" + "\u001B[0m");
				kelime = scanner.next();
				String kelimeSoru = "";
				
				for(int i = 0; i < kelime.length(); i++) {
					if(i != kelime.length() - 1) {
						kelimeSoru += kelime.charAt(i) + "?";
					}else {
						kelimeSoru += kelime.charAt(i);
					}
				}
				System.out.println("\u001B[32m" + kelimeSoru + "\u001B[0m");
				break;
				
			case 5:
				System.out.println("\u001B[33m" + "Lütfen bir kelime giriniz:" + "\u001B[0m");
				kelime = scanner.next();
				String kelimeNokta = "";
				
				for(int i = 0; i < kelime.length(); i++) {
					if(i < 3) {
						kelimeNokta += kelime.charAt(i);
					}else {
						break;
					}
				}
				kelimeNokta += "...";
				System.out.println("\u001B[32m" + kelimeNokta + "\u001B[0m");
				break;
				
			case 6:
				System.out.println("\u001B[33m" + "Lütfen bir kelime giriniz:" + "\u001B[0m");
				kelime = scanner.next();
				String kelimeNokta2 = "";
				
				for(int i = 0; i < kelime.length(); i++) {
					if(i < 3) {
						kelimeNokta2 += kelime.charAt(i);
					}else {
						kelimeNokta2 += ".";
					}
				}
				System.out.println("\u001B[32m" + kelimeNokta2 + "\u001B[0m");
				break;
				
			case 0:
				System.out.println("\u001B[31m" + "Sistem çıkış..." + "\u001B[0m");
				loop = false;
				break;

			default:
				break;
			}
		}

	}

}
