package edu.sbcc.cs105;
/*
 * The ResistorDecoder object will be the object used by your Main.java to translate the array of colors into the human-friendly string. 
 * The ResistorDecoder will need several different types of lookup tables depending upon 
 * whether we are looking up a String from the colors or a numerical value.
 */
public class ResistorDecoder {
	/*@param string array of colors
	 * */
	public String decodeResistor(String[] resistorColor) {
		// Result variable will be the final string returned at end
		String result = ""; 
		// Variables are the values that correspond to colors in the argument. Value depends on the color's location in the array. 
		double first = 0.0, second = 0.0;
		String third = "", fourth = "";
		// Iterate through color and use lookup table to get appropriate values
		for (int i = 0; i < resistorColor.length; i++) {
			if (i == 0) {
				//use multiplier lookup method to get the first value of given color from lookup table
				MultiplierLookup decoder1 = new MultiplierLookup();
				first = decoder1.getDouble(resistorColor[i], i);
			} else if (i == 1) {
				//use multiplier lookup method to get the second value of given color from lookup table
				MultiplierLookup decoder2 = new MultiplierLookup();
				second = decoder2.getDouble(resistorColor[i], i);
			} else if (i == 2) {
				//use multiplier lookup method to get the multiplier from lookup table
				NumberLookup decoder3 = new MultiplierLookup();
				third = decoder3.get(resistorColor[i]);
			} else if (i == 3) {
				//use tolerance lookup method to get the tolerance level from lookup table
				ToleranceLookup decoder4 = new ToleranceLookup();
				fourth = decoder4.get(resistorColor[i]);
			}
		}
		// The value of the first two colors multiplied by the multiplier of the third color
		double value = Integer.parseInt(Integer.toString((int)first) + Integer.toString((int)second)) * Double.parseDouble(third);
		// If a decimal below one just add to string
		if (value < 1.0) {
			result += Double.toString(value);
		} else if ((int)value < 1000) {
			// If less than 1000 just add to string
			result += Integer.toString((int)(value)); 
		} else if ((int)value >= 1000) {
			// While greater than 1000 divide by a thousand in order to get value in proper format
			while(value >= 1000) {
				value /= 1000; 
			}
			// Convert value to string
			String v = Double.toString(value);
			// If the double has a zero after the decimal change to integer
			if (v.charAt(v.length()-1) == '0') {
				v = Integer.toString((int)value);
			}
			// Add to value to string
			result += v;
		}
		
		// Find the proper abbreviation for the total ohms (determined by the multiplier or variable, 'third')
		double multiplier = Double.parseDouble(third);
		if (multiplier < 100.00) {
			result += "Ω";
		} else if (multiplier < 100000.00) {
			result += "KΩ";
		} else if (multiplier < 100000000.00) {
			result += "MΩ";
		}
		
		//Final formatting of string add the threshold to the end
		result += ", " + fourth;
		//System.out.println(result + "\n");
		return result;
	}

}
