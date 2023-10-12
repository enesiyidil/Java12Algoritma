package dersler.ders028.solid.openClose;

public class Instagram extends SocialMedia {

	@Override
	public void ScalePhoto(String type) {
		if (type.equals("png")) {
			setScaleRatio(38);
		} else if (type.equals("jpg")) {
			setScaleRatio(30);
		} else {
			setScaleRatio(40);
		}
	}
	

}
