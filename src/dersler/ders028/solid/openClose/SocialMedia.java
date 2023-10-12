package dersler.ders028.solid.openClose;

public abstract class SocialMedia implements IScale {

	private int scaleRatio;

	public static void sendEmail(String email) {
		System.out.println(email + " emailine gönderiliyor....");
	}

	public static void sendSms(String phone) {
		System.out.println(phone + " telefonuna sms gönderiliyor....");
	}

	public int getScaleRatio() {
		return scaleRatio;
	}

	public void setScaleRatio(int scaleRatio) {
		this.scaleRatio = scaleRatio;
	}
}
