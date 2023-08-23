/*
 * BilgeAdamBoost Java Full-Stack eğitimi
 */
package dersler.hafta01.ders003;

import java.util.Scanner;

/**
 * Koç Burcu : 21 Mart - 20 Nisan
 * Boğa Burcu : 21 Nisan - 21 Mayıs
 * İkizler Burcu : 22 Mayıs - 22 Haziran
 * Yengeç Burcu : 23 Haziran - 22 Temmuz
 * Aslan Burcu : 23 Temmuz - 22 Ağustos
 * Başak Burcu : 23 Ağustos - 22 Eylül
 * Terazi Burcu : 23 Eylül - 22 Ekim
 * Akrep Burcu : 23 Ekim - 21 Kasım
 * Yay Burcu : 22 Kasım - 21 Aralık
 * 
 * 1. Ay Oğlak Burcu : 22 Aralık - 21 Ocak
 * 1. Ay Kova Burcu : 22 Ocak - 19 Şubat
 * 
 * Balık Burcu : 20 Şubat - 20 Mart
 */
public class Problem15 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String burcDegisen;
		
		System.out.println("Doğduğunuz ayı giriniz.");
		int userAy =scanner.nextInt();
		System.out.println("Doğduğunuz günü giriniz.");
		int userGun =scanner.nextInt();
		
		String burc = switch (userAy) {
		case 1 -> {
			if(userGun >0 && userGun <= 21) {
				burcDegisen = "Oğlak";
			}else if(userGun <= 31){
				burcDegisen = "Kova";
			}else {
				burcDegisen = "Hatalı gün girişi";
			}
			yield burcDegisen;
		}case 2 -> {
			if(userGun >0 && userGun <= 19) {
				burcDegisen = "Kova";
			}else if(userGun <= 28) {
				burcDegisen = "Balık";
			}else {
				burcDegisen = "Hatalı gün girişi";
			}
			yield burcDegisen;
		}case 3 -> {
			if(userGun >0 && userGun <= 20) {
				burcDegisen = "Balık";
			}else if(userGun <= 31) {
				burcDegisen = "Koç";
			}else {
				burcDegisen = "Hatalı gün girişi";
			}
			yield burcDegisen;
		}case 4 -> {
			if(userGun >0 && userGun <= 20) {
				burcDegisen = "Koç";
			}else if(userGun <= 30){
				burcDegisen = "Boğa";
			}else {
				burcDegisen = "Hatalı gün girişi";
			}
			yield burcDegisen;
		}case 5 -> {
			if(userGun >0 && userGun <= 20) {
				burcDegisen = "Boğa";
			}else if(userGun <= 31) {
				burcDegisen = "İkizler";
			}else {
				burcDegisen = "Hatalı gün girişi";
			}
			yield burcDegisen;
		}case 6 -> {
			if(userGun >0 && userGun <= 20) {
				burcDegisen = "İkizler";
			}else if(userGun <= 30) {
				burcDegisen = "Yengeç";
			}else {
				burcDegisen = "Hatalı gün girişi";
			}
			yield burcDegisen;
		}case 7 -> {
			if(userGun >0 && userGun <= 22) {
				burcDegisen = "Yengeç";
			}else if(userGun <= 31){
				burcDegisen = "Aslan";
			}else {
				burcDegisen = "Hatalı gün girişi";
			}
			yield burcDegisen;
		}case 8 -> {
			if(userGun >0 && userGun <= 22) {
				burcDegisen = "Aslan";
			}else if(userGun <= 30) {
				burcDegisen = "Başak";
			}else {
				burcDegisen = "Hatalı gün girişi";
			}
			yield burcDegisen;
		}case 9 -> {
			if(userGun >0 && userGun <= 22) {
				burcDegisen = "Başak";
			}else if(userGun <= 30) {
				burcDegisen = "Terazi";
			}else {
				burcDegisen = "Hatalı gün girişi";
			}
			yield burcDegisen;
		}case 10 -> {
			if(userGun >0 && userGun <= 22) {
				burcDegisen = "Terazi";
			}else if(userGun <= 31){
				burcDegisen = "Akrep";
			}else {
				burcDegisen = "Hatalı gün girişi";
			}
			yield burcDegisen;
		}case 11 -> {
			if(userGun >0 && userGun <= 22) {
				burcDegisen = "Akrep";
			}else if(userGun <= 30) {
				burcDegisen = "Yay";
			}else {
				burcDegisen = "Hatalı gün girişi";
			}
			yield burcDegisen;
		}case 12 -> {
			if(userGun >0 && userGun <= 21) {
				burcDegisen = "Yay";
			}else if(userGun <= 31) {
				burcDegisen = "Oğlak";
			}else {
				burcDegisen = "Hatalı gün girişi";
			}
			yield burcDegisen;
		}
		default -> "Hatalı ay seçimi";
		};
		System.out.println(burc);
		scanner.close(); // scaner nesnesi kapandı
	}

}
