/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.ders005;

/**
 * Java,Spring,Postgre,React
 * ifadesini sırayla yazdır
 */
public class Problem31 {

	public static void main(String[] args) {
		
		String text = "Java,Spring,Postgre,React";
		
		for(int i = 0; i < text.split(",").length; i++) {
			System.out.println(text.split(",")[i]);
		}
		
		System.out.println("*********************************************************************************************");
		
		for(int i = 0; i < text.length(); i++) {
			char karakter = text.charAt(i);
			if(karakter != ',') {
				System.out.print(karakter);
			}else {
				System.out.println();
			}
		}
		
		System.out.println();
		System.out.println("*********************************************************************************************");
		
		text = "Java  , ,,  Spring   , Postgre,   React  ,, ";
		int baslangicIndex = 0;
		String textBoslukEklenmis = text.replace(" ", "").concat(" ");
		for(int i = 0; i < textBoslukEklenmis.length(); i++) {
			if(textBoslukEklenmis.charAt(i) == ',' || i == textBoslukEklenmis.length() - 1) {
				String sub = textBoslukEklenmis.substring(baslangicIndex, i);
				System.out.print((sub != "")? sub + "\n" : "");
				baslangicIndex = i + 1;
			}
		}

	}

}
