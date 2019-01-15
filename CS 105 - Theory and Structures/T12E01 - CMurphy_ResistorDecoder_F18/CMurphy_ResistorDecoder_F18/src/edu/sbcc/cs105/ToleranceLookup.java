package edu.sbcc.cs105;
/*The ToleranceLookup object takes a color and returns a String which is the tolerance string (e.g. ±5%).*/
public class ToleranceLookup extends LookupTable {
	/* Matches the color and returns the corresponding threshold from the lookup table. 
	 * @param color string
	 * */
	public String get(String color) {
		for (int i = 0; i < colorValues.length; i++) {
			if (colorValues[i][0] == color) {
				return colorValues[i][4];	
			}
		}
		return "";
	}
}