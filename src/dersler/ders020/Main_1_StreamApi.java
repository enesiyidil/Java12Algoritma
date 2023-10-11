package dersler.ders020;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import _ozelMetodlar.EColor;

public class Main_1_StreamApi {

	public static void main(String[] args) {

		List<User> users = Arrays.asList(new User(1, "Can", 15000, EGender.ERKEK),
				new User(2, "Nur", 18000, EGender.KADIN), new User(3, "Ece", 25000, EGender.KADIN),
				new User(4, "Ali", 20000, EGender.ERKEK), new User(5, "Can", 17000, EGender.ERKEK));

		users.forEach(User::bilgileriGoster);
//		users.forEach(((Consumer<User>)User::getName).andThen(System.out::println));

		System.out.println(EColor.MAGENTA.code
				+ "--------------------------------------------------------------------------------------------------------"
				+ EColor.RESET.code);

//		Soru 1. ID 3'ten büyük olanlar listelensin ve bilgileri getir metodu çalıştırılsın
		System.out.println(EColor.RED.code + "__________Soru 01__________" + EColor.RESET.code);
		List<User> usersByIdBigger3 = users.stream().filter(u -> u.getId() > 3).toList();
		usersByIdBigger3.forEach(User::bilgileriGoster);

		System.out.println(EColor.MAGENTA.code
				+ "--------------------------------------------------------------------------------------------------------"
				+ EColor.RESET.code);

//		Soru 2. isimi Can olanları yeni listeye atalım
		System.out.println(EColor.RED.code + "__________Soru 02__________" + EColor.RESET.code);
		List<User> usersByNameWithCan = users.stream().filter(u -> u.getName().equals("Can")).toList();
		usersByNameWithCan.forEach(User::bilgileriGoster);

		System.out.println(EColor.MAGENTA.code
				+ "--------------------------------------------------------------------------------------------------------"
				+ EColor.RESET.code);

//		Soru 3. her bir user için yeni bir user nesnesi oluşturup isimlerinin yanına BA yazdırıp yeni listeye atalım
		System.out.println(EColor.RED.code + "__________Soru 03__________" + EColor.RESET.code);
		List<User> usersBA = users.stream().map(u -> new User(u.getId(), u.getName() + "BA"))
				.collect(Collectors.toList());
		usersBA.forEach(User::bilgileriGoster);

		System.out.println(EColor.MAGENTA.code
				+ "--------------------------------------------------------------------------------------------------------"
				+ EColor.RESET.code);

//		Soru 4. Kullanıcıları maaşlarına göre sıralayalım
		System.out.println(EColor.RED.code + "__________Soru 04__________" + EColor.RESET.code);
		users.stream().sorted(Comparator.comparing(User::getSalary).reversed()).forEach(System.out::println);

		System.out.println(EColor.MAGENTA.code
				+ "--------------------------------------------------------------------------------------------------------"
				+ EColor.RESET.code);

//		Soru 5. 
		System.out.println(EColor.RED.code + "__________Soru 05__________" + EColor.RESET.code);
		HashMap<String, Integer> isimMaasListesi = users.stream().collect(
				Collectors.toMap(User::getName, User::getSalary, (existing, replacement) -> existing, HashMap::new));
		isimMaasListesi.forEach((k, v) -> System.out.println(k + " " + v));
	}

}
