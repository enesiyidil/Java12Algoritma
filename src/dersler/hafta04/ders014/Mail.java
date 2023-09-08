package dersler.hafta04.ders014;

import java.time.LocalDateTime;

public class Mail {

	private String baslik;
	private String icerik;
	private LocalDateTime gonderiSaati;
	private String gonderen;

	public Mail() {
		this.gonderiSaati = LocalDateTime.now();
		this.gonderen = "admin@xbanka.com";
	}

	public String getBaslik() {
		return baslik;
	}

	public void setBaslik(String baslik) {
		this.baslik = baslik;
	}

	public String getIcerik() {
		return icerik;
	}

	public void setIcerik(String icerik) {
		this.icerik = icerik;
	}

	public LocalDateTime getGonderiSaati() {
		return gonderiSaati;
	}

	public void setGonderiSaati(LocalDateTime gonderiSaati) {
		this.gonderiSaati = gonderiSaati;
	}

	public String getGonderen() {
		return gonderen;
	}

	public void setGonderen(String gonderen) {
		this.gonderen = gonderen;
	}

	@Override
	public String toString() {
		return "Mail [baslik=" + baslik + ", icerik=" + icerik + ", gonderiSaati=" + gonderiSaati.getHour() + ":"
				+ gonderiSaati.getMinute() + ", gonderen=" + gonderen + "]";
	}

}
