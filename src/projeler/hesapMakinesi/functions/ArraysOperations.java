package projeler.hesapMakinesi.functions;

/**
 * 
 */
public class ArraysOperations {

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
	 * 
	 * @param ch
	 * @param chRemove
	 * @param text
	 * @return
	 */
	static char[] removeChar(char[] ch, char chRemove, String text) {
		int size = ch.length - StringOperations.stringCharCounter(text, chRemove);
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
	
	/**
	 * Deletes the desired element of an array of type double.
	 * 
	 * @param array			-> Array.								Type : double[]
	 * @param removeIndex	-> Index number.						Type : int
	 * @return				Returns the array with element deleted.	Type : double[]
	 * 
	 * @author enesb
	 * @since v.007
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
	 * 
	 * @author enesb
	 * @since v.007
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
}
