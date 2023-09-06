package dersler.hafta03.ders011;

/**
 * 
 */
public class UserProfile {

	String userName;
	String name;
	String surname;
	String about;
	int followers;
	int following;
	String avatar;
	int postCount;
	
	public void editProfile() {
		System.out.println("Profilini düzenledi");
	}
	
	public void createPost() {
		postCount++;
		System.out.println("Post oluşturuldu");
	}
	
	public void shareStory() {
		System.out.println("Hikaye paylaşıldı");
	}
	
	public void addFriend() {
		following++;
		System.out.println("Takip edildi");
	}
	
	public void getInformation() {
		System.out.println("==========Profil Bilgileri==========");
		System.out.println("| Kullanıcı Adı  : " + userName);
		System.out.println("| Ad SOYAD       : " + name + " " + surname);
		System.out.println("| Hakkında       : " + about);
		System.out.println("| Takipçi Sayısı : " + followers);
		System.out.println("| Takip sayısı   : " + following);
		System.out.println("| Post sayısı    : " + postCount);
		System.out.println("====================================");
	}
}
