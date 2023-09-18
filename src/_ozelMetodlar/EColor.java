package _ozelMetodlar;

/**
 * Console çıktılarını renklendirmek için renk kodlarını tutan Enum'dır
 */
public enum EColor {

	BLACK("30"), RED("31"), GREEN("32"), YELLOW("33"), BLUE("34"), MAGENTA("35"), CYAN("36"), WHITE("37"), RESET("0");

	public final String code;

	EColor(String code) {
		this.code = "\u001B[" + code + "m";
	}

}
