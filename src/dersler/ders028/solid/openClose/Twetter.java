package dersler.ders028.solid.openClose;

public class Twetter extends SocialMedia{

	@Override
	public void ScalePhoto(String type) {
		if (type.equals("png")) {
			setScaleRatio(45);
		} else if (type.equals("jpg")) {
			setScaleRatio(30);
		} else {
			setScaleRatio(70);
		}
	}

}
