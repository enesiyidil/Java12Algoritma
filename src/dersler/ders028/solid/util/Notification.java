package dersler.ders028.solid.util;

public class Notification {

	public static void sendEmail(String email) {
		System.out.println(email + " emailine gönderiliyor....");
	}

	public static void sendSms(String phone) {
		System.out.println(phone + " telefonuna sms gönderiliyor....");
	}
}
