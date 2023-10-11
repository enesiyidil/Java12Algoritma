package dersler.ders023;

import java.io.File;

public class ConstantFile {

	public static final String PATH = System.getProperty("user.dir") + "\\src\\dersler\\ders023\\";

	public static final File FILE = new File(PATH + "dosya.txt");
}
