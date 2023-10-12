package dersler.ders028.solid.openClose;

public class Whatsapp extends SocialMedia{

	@Override
	public void ScalePhoto(String type) {
		if (type.equals("png")) {
			setScaleRatio(20);
		} else if (type.equals("jpg")) {
			setScaleRatio(25);
		} else {
			setScaleRatio(30);
		}
	}

}
