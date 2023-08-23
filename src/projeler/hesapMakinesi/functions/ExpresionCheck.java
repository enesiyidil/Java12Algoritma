package projeler.hesapMakinesi.functions;

/**
 * 
 */
public class ExpresionCheck {

	/**
	 * Is the expression true.
	 * 
	 * @param text	-> Expression.					Type : String
	 * @return		Returns is the expression true.	Type : boolean
	 */
	static boolean isCorrectExpression(String text) {
		
		boolean isThereOpenBracket = false;
		boolean isThereCloseBracket = false;
		
		text = text.replaceAll("[0-9]", "");
		
		if(StringOperations.stringCharCounter(text, '(') == StringOperations.stringCharCounter(text, ')')) {
			for(int i = 0; i < text.length(); i++) {
				char textChar = text.charAt(i);
				if(textChar == '(') {
					if(i == 0) {
						isThereOpenBracket = true;
					}else {
						if(text.charAt(i - 1) == '(') {
							isThereOpenBracket = true;
						}else {
							isThereOpenBracket = expectedOperator(text.charAt(i - 1));
						}
					}
					if(text.charAt(i + 1) == '(') {
						isThereOpenBracket = true;
					}else {
						isThereOpenBracket = expectedOperator(text.charAt(i + 1));
					}
				}else if(textChar == ')') {
					if(i == text.length() - 1) {
						isThereCloseBracket = true;
					}else {
						if(text.charAt(i - 1) == ')') {
							isThereCloseBracket = true;
						}else {
							isThereCloseBracket = expectedOperator(text.charAt(i - 1));
						}
						if(text.charAt(i + 1) == ')') {
							isThereOpenBracket = true;
						}else {
							isThereOpenBracket = expectedOperator(text.charAt(i + 1));
						}
					}
				}
			}
		}
		if(isThereOpenBracket && isThereCloseBracket) {
			return true;
		}else if(StringOperations.stringCharCounter(text, '(') == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * Does it contain character '-', '+', '*', '/', '^'
	 * 
	 * @param ch	-> Character.				Type : char
	 * @return		Returns does it contain.	Type : boolean
	 */
	static boolean expectedOperator(char ch) {
		char[] operators = new char[] {'-', '+', '*', '/', '^'};
		
		for(char chLoop : operators) {
			if(chLoop == ch) {
				return true;
			}
		}
		return false;
	}
}
