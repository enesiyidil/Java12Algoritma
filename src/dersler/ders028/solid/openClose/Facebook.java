package dersler.ders028.solid.openClose;

public class Facebook extends SocialMedia {

	@Override
	public void ScalePhoto(String type) {
		if (type.equals("png")) {
			setScaleRatio(25);
		} else if (type.equals("jpg")) {
			setScaleRatio(45);
		} else {
			setScaleRatio(50);
		}
	}

}
