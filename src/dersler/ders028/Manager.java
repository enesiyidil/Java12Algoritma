package dersler.ders028;

import java.io.*;
import java.util.*;

public class Manager {

	static List<Ogrenci> ogrenciler = new ArrayList<>();

	public void ogrenciListesiOlustur() {

		File file = new File(System.getProperty("user.dir") + "\\src\\dersler\\ders028\\ogrenci.txt");

		if (file.exists()) {
			try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
				String satir;
				while ((satir = reader.readLine()) != null) {
					ogrenciler.add(new Ogrenci(satir.split(",")[0], Arrays.stream(satir.split(",")).skip(1)
							.mapToDouble(Double::parseDouble).average().orElse(0)));
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(ogrenciler);
	}

	public void ogrencilerSerilize() {
		File file = new File(System.getProperty("user.dir") + "\\src\\dersler\\ders028\\ogrenciSerilize.txt");
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
			ogrenciler.forEach(o -> {
				try {
					objectOutputStream.writeObject(o);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} catch (NotSerializableException e) {
			System.out.println("Serializable implemente edilmemiş");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void ogrencilerDeserilize() {
		File file = new File(System.getProperty("user.dir") + "\\src\\dersler\\ders028\\ogrenciSerilize.txt");
		try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {

			Ogrenci okunanOgr;
			while (true) {
				okunanOgr = (Ogrenci) objectInputStream.readObject();
				System.out.println(okunanOgr);
			}

		} catch (EOFException e) {
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
