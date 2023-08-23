package projeler.hesapMakinesi.functions;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 */
public class CalculatorMain {

	public static void calculator(Scanner scanner) {
		String[] operatorsSplit = new String[] {"-","\\+","/","\\*","x","\\^","X","\\(","\\)"};
		String operatorRegex = String.join("|", operatorsSplit);
		double result = 0;
		boolean isContainAlphanet = false, isCorrectExp = false;
		String mathOperation = "";
		
		while(!(isContainAlphanet && isCorrectExp)) {
			System.out.println("\u001B[36m" + "Enter the mathematical expression :" + "\u001B[0m");
			mathOperation = scanner.next().toLowerCase();
			if(mathOperation.equals("q")) {
				System.out.println("System exit...");
				System.exit(0);
			}
			isContainAlphanet = StringOperations.containsAlphanet(mathOperation);
			isCorrectExp = ExpresionCheck.isCorrectExpression(mathOperation);
			if(!isContainAlphanet) {
				System.out.println("\u001B[31m" + "Mathematical expression cannot contain alphanet!" + "\u001B[0m");
			}else if(!isCorrectExp){
				System.out.println("\u001B[31m" + "Mathematical expression doesnot correct!" + "\u001B[0m");
			}else {
				System.out.println("\u001B[33m" + "Calculating..." + "\u001B[0m");
			}
		}
		
		String[] mathOperationString = ArraysOperations.removeEmptyElements(mathOperation.split(operatorRegex));
		System.out.println("\u001B[33m" + "mathOperationString : " + "\u001B[35m" + Arrays.toString(mathOperationString));
		
		double[] numbers = Arrays.stream(mathOperationString).mapToDouble(Double::parseDouble).toArray();
		System.out.println("\u001B[33m" + "numbers : " + "\u001B[35m" + Arrays.toString(numbers));
		
		char[] operators = ArraysOperations.removeChar(mathOperation.replaceAll("[0-9]", "").toCharArray(), '.', mathOperation);
		System.out.println("\u001B[33m" + "operators : " + "\u001B[35m" + Arrays.toString(operators) + "\u001B[0m");
		
		if(mathOperation.contains("(")) {
			int numBrackets = StringOperations.stringCharCounter(mathOperation, '(');
			
			for(int l = 0; l < StringOperations.stringCharCounter(mathOperation, '('); l++) {
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

										numbers[i - numBrackets + 1] = Calculation.calculation(mathOperation, operatorsTemp, numbersTemp);
										
										System.out.println("\u001B[33m" + "numbers : " + "\u001B[35m" + Arrays.toString(numbers));
										
										operators = ArraysOperations.arrayRemoveChar(operators, j);
										operators = ArraysOperations.arrayRemoveChar(operators, i);
										
										System.out.println("\u001B[33m" + "operators : " + "\u001B[35m" + Arrays.toString(operators));
										
										for(int k = i + 1; k < j; k++) {
											numbers = ArraysOperations.arrayRemoveDouble(numbers, i - numBrackets + 2);
											operators = ArraysOperations.arrayRemoveChar(operators, i);
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
		
		result = Calculation.calculation(mathOperation, operators, numbers);
		System.out.println("\u001B[34m" + "**************************************************" + "\u001B[0m");
		System.out.println("\u001B[32m" + mathOperation + " = " + result + "\u001B[0m");
		System.out.println("\u001B[34m" + "**************************************************" + "\u001B[0m");
	}
}
