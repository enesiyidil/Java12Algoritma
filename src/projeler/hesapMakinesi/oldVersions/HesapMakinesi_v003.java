/**
 * 
 */
package projeler.hesapMakinesi.oldVersions;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Hesap makinesi v.002 tekli parantez durumları için işlem önceliği yapabiliyor
 */
public class HesapMakinesi_v003 {

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
	static double hesaplama(String islem, char[] islemler, double[] sayilar) {
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
				}
			}	
		}
		sonuc = sayilar[0];
		for(char i: islemler) {
			sonuc = hesap(i, sonuc, sayilar[sayiIndex]);
			sayiIndex++;
		}
		return sonuc;
	}
	static String[] removeEmptyElements(String[] array) {
        int newSize = 0;
        
        // Boş olmayan elemanların sayısını bulma
        for (String element : array) {
            if (!element.isEmpty()) {
                newSize++;
            }
        }
        
        // Yeni dizi oluşturma ve boş olmayan elemanları kopyalama
        String[] newArray = new String[newSize];
        int index = 0;
        for (String element : array) {
            if (!element.isEmpty()) {
                newArray[index] = element;
                index++;
            }
        }
        
        return newArray;
    }
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String[] operatorsSplit = new String[] {"-","\\+","/","\\*","x","\\^","X","\\(","\\)"};
		String operatorRegex = String.join("|", operatorsSplit);
		
		System.out.println("İşlemi giriniz ( * / - + ).");
		String mathOperation = scanner.next();
		
		String[] mathOperationString = removeEmptyElements(mathOperation.split(operatorRegex));
		System.out.println("Kullanıcı sayıları : " + Arrays.toString(mathOperationString));
		int[] mathOperationInt = Arrays.stream(mathOperationString).mapToInt(Integer::parseInt).toArray();
		double[] numbers = Arrays.stream(mathOperationInt).asDoubleStream().toArray();
		
		char[] operators = mathOperation.replaceAll("[0-9]", "").toCharArray();
		
		System.out.println("Kullanıcı sayıları : " + Arrays.toString(numbers));
		System.out.println("Kullanıcı işlemleri : " + Arrays.toString(operators));
		
		double result = 0;
		
		if(mathOperation.contains("(")) {
			firstFor:
			for(int i = 0; i < operators.length; i++) {
				if(operators[i] == '(') {
					for(int j = operators.length - 1; j >= 0 ; j--) {
						if(operators[j] == ')') {
							double[] numbersTemp = Arrays.copyOfRange(numbers, i, j);
							char[] operatorsTemp = Arrays.copyOfRange(operators, i + 1, j);
							System.out.println("Kullanıcı numbersTemp : " + Arrays.toString(numbersTemp));
							System.out.println("Kullanıcı operatorsTemp : " + Arrays.toString(operatorsTemp));
							System.out.println("i = " + i + ", j = " + j);
							numbers[i] = hesaplama(mathOperation, operatorsTemp, numbersTemp);
							System.out.println("Kullanıcı sayıları : " + Arrays.toString(numbers));
							System.out.println("Kullanıcı işlemleri : " + Arrays.toString(operators));
							operators = diziElemanSilmeChar(operators, j);
							operators = diziElemanSilmeChar(operators, i);
							for(int k = i + 1; k < j; k++) {
								numbers = diziElemanSilmeDouble(numbers, i + 1);
								operators = diziElemanSilmeChar(operators, i);
							}
							System.out.println("Kullanıcı sayıları : " + Arrays.toString(numbers));
							System.out.println("Kullanıcı işlemleri : " + Arrays.toString(operators));
							break firstFor;
						}
					}
				}
			}
			result = hesaplama(mathOperation, operators, numbers);
		}else {
			result = hesaplama(mathOperation, operators, numbers);
		}
		
		System.out.println(mathOperation + " = " + result);

	}

}
