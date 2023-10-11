package dersler.ders020.StreamUygulama;

public enum EUrun {

	CIPS(50), KOLA(25), GOFRET(15), SUT(20), KEK(12);

	private double price;

	EUrun(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
