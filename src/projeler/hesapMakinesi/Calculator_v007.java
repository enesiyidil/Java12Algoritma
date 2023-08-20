/**
 * 
 */
package projeler.hesapMakinesi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Calculator
 * 
 * Added digit mathematical operations
 * Added removeChar function
 * 
 * @author enesb
 * @version v007
 */
public class Calculator_v007 {
	
	/**
	 * It performs calculations by processing the numbers and operators it receives as an array.
	 * 
	 * @param mathOperation -> Mathematical expression entered by the user. 				Type : String
	 * @param operators		-> Array holding the operators of the mathematical expression.	Type : char[]
	 * @param numbers		-> Array holding the numbers of the mathematical expression.	Type : double[]
	 * @return				 Returns the calculated result value.							Type : double
	 */
	static double calculation(String mathOperation, char[] operators, double[] numbers) {
		double result;
		int numberIndex = 1;
		
		if (mathOperation.contains("^")) {
			for (int i = 0; i < operators.length; i++) {
				double sonucDegisen;
				if (operators[i] == '^') {
					sonucDegisen = operations(operators[i], numbers[i], numbers[i + 1]);
					numbers[i] = sonucDegisen;
					numbers = arrayRemoveDouble(numbers, i + 1);
					operators = arrayRemoveChar(operators, i);
					i--;
				}
			}
		}
		if (mathOperation.contains("*") || mathOperation.contains("/")) {
			for (int i = 0; i < operators.length; i++) {
				double sonucDegisen;
				if (operators[i] == '*' || operators[i] == '/') {
					sonucDegisen = operations(operators[i], numbers[i], numbers[i + 1]);
					numbers[i] = sonucDegisen;
					numbers = arrayRemoveDouble(numbers, i + 1);
					operators = arrayRemoveChar(operators, i);
					i--;
				}
			}
		}
		result = numbers[0];
		for (char i : operators) {
			result = operations(i, result, numbers[numberIndex]);
			numberIndex++;
		}
		return result;
	}

	/**
	 * Calculates two given numbers with the desired operator
	 * 
	 * @param operationsCho -> Desired operator.					Type : char
	 * @param num1			-> Number 1.							Type : double
	 * @param num2			-> Number 2.							Type : double
	 * @return				Returns the calculated result value.	Type : double
	 */
	static double operations(char operationsCho, double num1, double num2) {
		return switch (operationsCho) {
		case '+' -> {
			yield num1 + num2;
		}
		case '-' -> {
			yield num1 - num2;
		}
		case '*' -> {
			yield num1 * num2;
		}
		case '/' -> {
			yield num1 / num2;
		}
		case '^' -> {
			yield Math.pow(num1, num2);
		}
		default -> 0;
		};
	}

	/**
	 * Deletes the desired element of an array of type double.
	 * 
	 * @param array			-> Array.								Type : double[]
	 * @param removeIndex	-> Index number.						Type : int
	 * @return				Returns the array with element deleted.	Type : double[]
	 */
	static double[] arrayRemoveDouble(double[] array, int removeIndex) {
		double[] arrayTemp = new double[array.length - 1];
		for (int i = 0, k = 0; i < array.length; i++) {
			if (i != removeIndex) {
				arrayTemp[k] = array[i];
				k++;
			}
		}
		return arrayTemp;
	}

	/**
	 * Deletes the desired element of an array of type char.
	 * 
	 * @param array			-> Array.								Type : char[]
	 * @param removeIndex	-> Index number.						Type : int
	 * @return				Returns the array with element deleted.	Type : char[]
	 */
	static char[] arrayRemoveChar(char[] array, int removeIndex) {
		char[] arrayTemp = new char[array.length - 1];
		for (int i = 0, k = 0; i < array.length; i++) {
			if (i != removeIndex) {
				arrayTemp[k] = array[i];
				k++;
			}
		}
		return arrayTemp;
	}
	
	/**
	 * Deletes empty elements from an array of type String
	 * 
	 * @param array	-> Array.								Type : String[]
	 * @return		Returns the array with element deleted.	Type : String[]
	 */
	static String[] removeEmptyElements(String[] array) {
        int newSize = 0;
        
        for (String element : array) {
            if (!element.isEmpty()) {
                newSize++;
            }
        }
        String[] newArray = new String[newSize];
        int index = 0;
        for (String element : array) {
            if (!element.isEmpty()) {
                newArray[index] = element;
                index++;
            }
        }
        return newArray;
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
	
	/**
	 * Counts the desired character in the text
	 * 
	 * @param text			-> Expression.						Type : String
	 * @param character		-> Desired character.				Type : char
	 * @return				Returns the number of characters	Type : int
	 */
	static int stringCharCounter(String text, char character) {
        int coun = 0;
        for (char c : text.toCharArray()) {
            if (c == character) {
            	coun++;
            }
        }
        return coun;
    }
	
	/**
	 * Is the expression true.
	 * 
	 * @param text	-> Expression.					Type : String
	 * @return		Returns is the expression true.	Type : boolean
	 */
	static boolean isCorrectExpression(String text) {
		boolean isThereOpenBracket = false;
		boolean isThereCloseBracket = false;
		
		if(stringCharCounter(text, '(') == stringCharCounter(text, ')')) {
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
		}else if(stringCharCounter(text, '(') == 0) {
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
	
	/**
	 * 
	 * @param ch
	 * @param chRemove
	 * @param text
	 * @return
	 */
	static char[] removeChar(char[] ch, char chRemove, String text) {
		int size = ch.length - stringCharCounter(text, chRemove);
		char[] charTemp = new char[size];
		int i = 0;
		for(char chTemp : ch) {
			if(chTemp != chRemove) {
				charTemp[i] =chTemp;
				i++;
			}
		}
		return charTemp;
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scanner = new Scanner(System.in);
		File file = new File("C:\\Users\\enesb\\Documents\\Java12BilgeAdamBoost\\Java12\\Java12AlgoritmaSorulari\\src\\projeler\\hesapMakinesi\\Description.txt");
		Scanner scannerTxt = new Scanner(file);
		
		System.out.println("\u001B[35m" + "**************************************************" + "\u001B[0m");
		while (scannerTxt.hasNextLine()) {
	        String data = scannerTxt.nextLine();
	        System.out.println(data);
	      }
		scannerTxt.close();
		System.out.println("\u001B[35m" + "**************************************************" + "\u001B[0m");
		
		String[] operatorsSplit = new String[] {"-","\\+","/","\\*","x","\\^","X","\\(","\\)"};
		String operatorRegex = String.join("|", operatorsSplit);
		double result = 0;
		boolean isContainAlphanet = false, isCorrectExp = false;
		String mathOperation = "";
		
		while(!(isContainAlphanet && isCorrectExp)) {
			System.out.println("\u001B[36m" + "Enter the mathematical expression :" + "\u001B[0m");
			mathOperation = scanner.next().toLowerCase();
			isContainAlphanet = containsAlphanet(mathOperation);
			isCorrectExp = isCorrectExpression(mathOperation);
			if(!isContainAlphanet) {
				System.out.println("\u001B[31m" + "Mathematical expression cannot contain alphanet!" + "\u001B[0m");
			}else if(!isCorrectExp){
				System.out.println("\u001B[31m" + "Mathematical expression doesnot correct!" + "\u001B[0m");
			}else {
				System.out.println("\u001B[33m" + "Calculating..." + "\u001B[0m");
			}
		}
		
		String[] mathOperationString = removeEmptyElements(mathOperation.split(operatorRegex));
		System.out.println("\u001B[33m" + "mathOperationString : " + "\u001B[35m" + Arrays.toString(mathOperationString));
		
		double[] numbers = Arrays.stream(mathOperationString).mapToDouble(Double::parseDouble).toArray();
		System.out.println("\u001B[33m" + "numbers : " + "\u001B[35m" + Arrays.toString(numbers));
		
		char[] operators = removeChar(mathOperation.replaceAll("[0-9]", "").toCharArray(), '.', mathOperation);
		System.out.println("\u001B[33m" + "operators : " + "\u001B[35m" + Arrays.toString(operators) + "\u001B[0m");
		
		if(mathOperation.contains("(")) {
			int numBrackets = stringCharCounter(mathOperation, '(');
			
			for(int l = 0; l < stringCharCounter(mathOperation, '('); l++) {
				int numBracketsOpen = 1, numBracketsClose = 1;
				secondFor:
				for(int i = 0; i < operators.length; i++) {
					
					if(operators[i] == '(') {		
						if(numBracketsOpen == numBrackets) {
							for(int j = operators.length - 1; j >= 0 ; j--) {
								if(operators[j] == ')') {
									if(numBracketsClose == numBrackets) {
										
										double[] numbersTemp = Arrays.copyOfRange(numbers, i - numBrackets + 1, j - numBrackets + 1);
										char[] operatorsTemp = Arrays.copyOfRange(operators, i + 1, j);

										numbers[i - numBrackets + 1] = calculation(mathOperation, operatorsTemp, numbersTemp);
										
										System.out.println("\u001B[33m" + "numbers : " + "\u001B[35m" + Arrays.toString(numbers));
										
										operators = arrayRemoveChar(operators, j);
										operators = arrayRemoveChar(operators, i);
										
										System.out.println("\u001B[33m" + "operators : " + "\u001B[35m" + Arrays.toString(operators));
										
										for(int k = i + 1; k < j; k++) {
											numbers = arrayRemoveDouble(numbers, i - numBrackets + 2);
											operators = arrayRemoveChar(operators, i);
										}
										System.out.println("\u001B[33m" + "numbers : " + "\u001B[35m" + Arrays.toString(numbers));
										System.out.println("\u001B[33m" + "operators : " + "\u001B[35m" + Arrays.toString(operators));
										numBrackets--;
										break secondFor;
									}else {
										numBracketsClose++;
									}
								}
							}
						}else {
							numBracketsOpen++;
						}
					}
				}
			}
		}
		
		result = calculation(mathOperation, operators, numbers);
		System.out.println("\u001B[34m" + "**************************************************" + "\u001B[0m");
		System.out.println("\u001B[32m" + mathOperation + " = " + result + "\u001B[0m");
		System.out.println("\u001B[34m" + "**************************************************" + "\u001B[0m");

	}

}
