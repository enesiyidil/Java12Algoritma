package dersler;

import java.util.Locale;
import java.util.ResourceBundle;

public class deneme {

	public static void main(String[] args) {
		// Kullanıcının bölge tercihine bağlı olarak Locale'ı ayarlayın.
        Locale locale = Locale.of("tr", "TR");
        
        // ResourceBundle kullanarak metinlere erişin.
        ResourceBundle bundle = ResourceBundle.getBundle("MyResources", locale);
        
        // ResourceBundle'dan metinleri alın.
        String welcomeMessage = bundle.getString("welcome.message");
        String goodbyeMessage = bundle.getString("goodbye.message");
        
        System.out.println(welcomeMessage);
        System.out.println(goodbyeMessage);
    
	}

}
