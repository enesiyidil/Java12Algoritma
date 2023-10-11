package dersler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class deneme2 {

	public static void main(String[] args) {

		/**
		 * \u001B[0m: Normal stil (tüm önceki stil ayarlarını sıfırlar) 
		 * 
		 * \u001B[1m: Kalın
		 * metin 
		 * 
		 * \u001B[3m: İtalik metin 
		 * 
		 * \u001B[4m: Altı çizili metin 
		 * 
		 * 
		 * \u001B[39m: Metin rengini sıfırlar (varsayılan rengi kullanır) Altını Çizme:
		 * 
		 * \u001B[4m: Metni altı çizili yapar Metin Rengini Arka Plan Rengiyle
		 * Değiştirme:
		 * 
		 * \u001B[40m: Siyah arka plan rengi \u001B[41m: Kırmızı arka plan rengi
		 * \u001B[42m: Yeşil arka plan rengi \u001B[43m: Sarı arka plan rengi
		 * \u001B[44m: Mavi arka plan rengi \u001B[45m: Magenta arka plan rengi
		 * \u001B[46m: Cyan arka plan rengi \u001B[47m: Beyaz arka plan rengi
		 * \u001B[49m: Arka plan rengini sıfırlar (varsayılan arka plan rengini
		 * kullanır) 
		 */
		
		System.out.print("\u001B[46m");
		(new ArrayList<String>()).stream().max(Comparator.comparingInt(String::length));
		String array[]= {"5","j","2","a","3","v","a"};
		int toplam=0;
		String value="";
	for (int i = 0; i < array.length; i++) {
		
		try {
		int x=Integer.parseInt(array[i]);
		toplam+=x;
		} catch (Exception e) {
			value+=array[i];
		}finally {
			toplam+=1;
     value="";
		}
	}
	System.out.print(toplam);	
	 System.out.print(value.replace("a", "e"));
	 List<String> words = Arrays.asList("Java", "Stream", "API", "is", "powerful");

	 List<String> filteredWords = words.stream().filter(w -> w.length() > 3).map(String::toUpperCase).collect(Collectors.toList());

	 System.out.println(filteredWords);

	}

}
