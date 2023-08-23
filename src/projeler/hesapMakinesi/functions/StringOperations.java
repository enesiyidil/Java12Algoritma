package projeler.hesapMakinesi.functions;

/**
 * 
 */
public class StringOperations {

	/**
	 * Counts the desired character in the text
	 * 
	 * @param text			-> Expression.						Type : String
	 * @param character		-> Desired character.				Type : char
	 * @return				Returns the number of characters	Type : int
	 */
	public static int stringCharCounter(String text, char character) {
        int coun = 0;
        for (char c : text.toCharArray()) {
            if (c == character) {
            	coun++;
            }
        }
        return coun;
    }
	
	/**
	 * Does the expression of type String contain alphanet and 
	 * 'ı', 'ş', 'ü', 'ç', 'ö', 'ğ', ',', '!', '%', '&', '=', '?'
	 * 
	 * @param text	-> Expression.							Type : String	
	 * @return		Returns does the expression contain.	Type : boolean
	 */
	static boolean containsAlphanet(String text) {
		boolean isContain = true;
		char[] ch = new char[] {'ı', 'ş', 'ü', 'ç', 'ö', 'ğ', ',', '!', '%', '&', '=', '?'};
		text = text.toLowerCase();
		for(char alphanet = 'a'; alphanet <= 'z'; alphanet++) {
			if(text.indexOf(alphanet) != -1) {
				isContain = false;
			}
		}
		for(char chTemp : ch) {
			if(text.indexOf(chTemp) != -1) {
				isContain = false;
			}
		}
		return isContain;
	}
}
