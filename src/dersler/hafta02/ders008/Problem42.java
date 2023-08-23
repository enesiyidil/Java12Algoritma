/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.hafta02.ders008;

/**
 * { { "Bilge", "Advanced" }, { "Postgre", "Data" } }
 * { { "Adam", "Java" }, { "SQL", "Base" } }
 * 
 * Girilenin çıksı şöyle olsun
 * 
 * BilgeAdam
 * AdvancedJava
 * PostgreSQL
 * DataBase
 */
public class Problem42 {
	
public static void main(String[] args) {
		
	String[][] matris1 = { { "Bilge", "Advanced" }, { "Postgre", "Data" } };
    String[][] matris2 = { { "Adam", "Java" }, { "SQL", "Base" } };
    
    for(int i = 0; i < matris1.length; i++) {
    	for(int j = 0; j < matris1[i].length; j++) {
    		System.out.println(matris1[i][j] + matris2[i][j]);
    	}
    }

	}

}
