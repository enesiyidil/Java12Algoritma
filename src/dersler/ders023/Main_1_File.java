package dersler.ders023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main_1_File {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int election;
		do {
			System.out.println("1 - Dosya Yarat");
			System.out.println("2 - Dosyaya veri ekleme");
			System.out.println("3 - Dosya Oku");

			System.out.print("Seçiminiz : ");
			election = scanner.nextInt();
			scanner.nextLine();

			switch (election) {
			case 1:
				createFile(setFileName());
				break;
			case 2:
				textAddToFile(selectionFile());
				break;
			case 3:
				readFile();
				break;
			default:
				break;
			}
		} while (election != 0);
		scanner.close();
	}

	public static File selectionFile() {

		Path path = Path.of(ConstantFile.PATH);
		try {
			List<Path> fileList = Files.list(path).collect(Collectors.toList());
			fileList.forEach(p -> System.out.println(p.getFileName()));
			System.out.print("Hangi dosyaya ekleme yapacaksınız : ");
			int election = scanner.nextInt();
			scanner.nextLine();
			return new File(fileList.get(election).toUri());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void readFile() {
		File file = setFileName();
		
		if(file.exists()) {
			try(BufferedReader reader = new BufferedReader(new FileReader(file))){
				String satir;
				while((satir = reader.readLine()) != null) {
					System.out.println(satir);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void textAddToFile(File file) {

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
			System.out.print("Metin giriniz : ");
			String text = scanner.nextLine();
			writer.write(text+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void createFile(File file) {

		try {
			if (file.exists())
				throw new FileAlreadyExistsException("Dosya zaten var");
			file.createNewFile();
			System.out.println("Dosya oluşturuldu => " + file.getName());
		} catch (FileAlreadyExistsException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static File setFileName() {

		System.out.print("Dosya adınını giriniz : ");
		String fileName = scanner.nextLine() + ".txt";
		return new File(ConstantFile.PATH + fileName);
	}
}
