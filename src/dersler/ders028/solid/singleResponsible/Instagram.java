package dersler.ders028.solid.singleResponsible;

import dersler.ders028.solid.util.Notification;
import dersler.ders028.solid.util.User;

public class Instagram {

	public void sendNotification(User user) {
		
		
	}
	
	public void sendEmail(User user) {
		if(user.getEmail() != null) {
			Notification.sendEmail(user.getEmail());
		}
	}
	public void sendSms(User user) {
		if(user.getPhone() != null) {
			Notification.sendSms(user.getPhone());
		}
	}
}
