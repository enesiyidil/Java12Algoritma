package dersler.hafta04.ders013.profil;

public class Profile {

	// Attribute, Property, Field
	public String profilResmi;
	public String kullaniciAdi;
	public String isim;
	public int takipciSayisi;
	public int takipSayisi;
	public String[] posts;
	public int postSayisi;
	public boolean maviTik;

	public Profile() {
		this.posts = new String[10];
	}

	public void postOlusturma(String isim) {
		System.out.println("\"" + isim + "\" Post oluşturuldu!");
		this.posts[postSayisi] = isim;
		this.postSayisi++;
	}

	public void profileIsimGuncelle(String isim) {
		System.out.println("\"" + this.isim + "\" -> \"" + isim + "\" ile güncellendi");
		this.isim = isim;
	}

	public void istekKabulEt() {
		System.out.println("Takip isteği kabul edildi.");
		this.takipciSayisi++;
		maviTikKontrol();
	}

	public void takiptenCikar() {
		if (this.takipciSayisi > 0) {
			System.out.println("Takipçi çıkarıldı.");
			this.takipciSayisi--;
			maviTikKontrol();
		} else {
			System.out.println("Takipçiniz yok!");
		}
	}

	private void maviTikKontrol() {
		if (this.takipciSayisi > 5 && maviTik == false) {
			this.maviTik = true;
		} else if (this.takipciSayisi <= 5 && maviTik == true) {
			this.maviTik = false;
		}
	}

	public void profilBilgileriniGetir() {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return "Profile [isim=" + isim + ", takipciSayisi=" + takipciSayisi + ", postSayisi=" + postSayisi
				+ ", maviTik=" + ((this.maviTik)? "var" : "yok") + "]";
	}
	
	
}
