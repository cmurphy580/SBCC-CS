package edu.sbcc.cs105;

/* 
 * The MultiplierLookup object works in a similar way to the NumberLookup object but the internal lookup tables are different. 
 * Therefore we need to inherit from the NumberLookup table even though we don't need to add any methods.
 */
public class MultiplierLookup extends NumberLookup {
	/*Get method matches the color and find the corresponding multiplier in lookup table
	 * @param a color string
	 * */
	public String get(String color) {
		for (int i = 0; i < colorValues.length; i++) {
			if (colorValues[i][0] == color) {
				return colorValues[i][3];	
			}
		}
		return "";
	}
	/*Get double method takes the color of the string and its place/index in the inputed string array
	 * @param color string and integer representing the index in the color string array.
	 * */
	public double getDouble(String color, int i) {
		int idx;
		idx = i + 1; 
		for (int j = 0; j < colorValues.length; j++) {
			// Matches the color and returns the color value 
			if (colorValues[j][0] == color) {
				return Double.parseDouble(colorValues[j][idx]);	
			}
		}
		return 1.0;
	}
}
