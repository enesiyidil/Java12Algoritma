package dersler.hafta03.ders011;

/**
 * 
 */
public class Test {

	public static void main(String[] args) {

		UserProfile user1 = new UserProfile();

		user1.userName = "Kullanıcı_Adı";
		user1.name = "İsim";
		user1.surname = "SOYİSİM";
		user1.about = "Hakkında...";
		user1.followers = 1235;
		user1.following = 1201;
		user1.postCount = 67;

		user1.getInformation();

		UserProfile user2 = new UserProfile();

		user2.userName = "Kullanıcı_Adı";
		user2.name = "İsim";
		user2.surname = "SOYİSİM";
		user2.about = "Hakkında...";
		user2.followers = 1235;
		user2.following = 1201;
		user2.postCount = 67;

		user2.getInformation();

	}

}
