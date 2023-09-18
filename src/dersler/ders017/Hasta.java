package dersler.ders017;

public class Hasta implements Comparable<Hasta> {

	private static int num;
	private String isim;
	private EHastalik sikayet;
	private int sira;

	public Hasta(String isim, EHastalik sikayet) {
		super();
		this.isim = isim;
		this.sikayet = sikayet;
		this.sira = num;
		num++;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public EHastalik getSikayet() {
		return sikayet;
	}

	public void setSikayet(EHastalik sikayet) {
		this.sikayet = sikayet;
	}

	public int getSira() {
		return sira;
	}

	@Override
	public String toString() {
		return "Hasta [isim=" + isim + ", sikayet=" + sikayet.name() + ", sira=" + sira + "]";
	}

	@Override
	public int compareTo(Hasta o) {
		if (this.sikayet.ordinal() - o.getSikayet().ordinal() == 0
				|| (o.sikayet.ordinal() >= 3 && this.sikayet.ordinal() >= 3)) {
			return this.sira - o.getSira();
		}
		return this.sikayet.ordinal() - o.getSikayet().ordinal();
	}

}
