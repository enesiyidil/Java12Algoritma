package dersler.ders028.solid.openClose;

public class ResizePhoto {

	public void changeScaleRatio(Instagram instagram, String type) {
		if (type.equals("png")) {
			instagram.setScaleRatio(38);
		} else if (type.equals("jpg")) {
			instagram.setScaleRatio(30);
		} else {
			instagram.setScaleRatio(40);
		}
	}

	public void changeScaleRatio(Facebook facebook, String type) {
		if (type.equals("png")) {
			facebook.setScaleRatio(25);
		} else if (type.equals("jpg")) {
			facebook.setScaleRatio(45);
		} else {
			facebook.setScaleRatio(50);
		}
	}

	public void changeScaleRatio(SocialMedia socialMedia, String type) {
		
			socialMedia.ScalePhoto(type);
	}
}
