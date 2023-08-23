package projeler.hesapMakinesi.functions;

/**
 * @author enesb
 * @since v.007
 */
public class Calculation {

	/**
	 * It performs calculations by processing the numbers and operators it receives as an array.
	 * 
	 * @param mathOperation -> Mathematical expression entered by the user. 				Type : String
	 * @param operators		-> Array holding the operators of the mathematical expression.	Type : char[]
	 * @param numbers		-> Array holding the numbers of the mathematical expression.	Type : double[]
	 * @return				 Returns the calculated result value.							Type : double
	 * 
	 * @author enesb
	 * @since v.007
	 */
	public static double calculation(String mathOperation, char[] operators, double[] numbers) {
		double result;
		int numberIndex = 1;
		
		if (mathOperation.contains("^")) {
			for (int i = 0; i < operators.length; i++) {
				double sonucDegisen;
				if (operators[i] == '^') {
					sonucDegisen = operations(operators[i], numbers[i], numbers[i + 1]);
					numbers[i] = sonucDegisen;
					numbers = ArraysOperations.arrayRemoveDouble(numbers, i + 1);
					operators = ArraysOperations.arrayRemoveChar(operators, i);
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
					numbers = ArraysOperations.arrayRemoveDouble(numbers, i + 1);
					operators = ArraysOperations.arrayRemoveChar(operators, i);
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
	 * 
	 * @author enesb
	 * @since v.007
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

}
