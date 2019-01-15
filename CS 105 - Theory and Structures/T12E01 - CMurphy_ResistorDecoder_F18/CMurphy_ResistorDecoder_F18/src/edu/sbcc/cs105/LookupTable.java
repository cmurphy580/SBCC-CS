package edu.sbcc.cs105;

/*
 * The LookupTable object is an abstract object since it contains an abstract method get()
 * */
public abstract class LookupTable {
	// Static array of with each array consisting of its color, corresponding first and second values, multiplier, and threshold.
	protected String [][] colorValues = {
			{"Black", "0", "0", "1", ""},
			{"Brown", "1", "1", "10", "±1%"},
			{"Red", "2", "2", "100", "±2%"},
			{"Orange", "3", "3", "1000", ""},
			{"Yellow", "4", "4", "10000", "±5%"},
			{"Green", "5", "5", "100000", "±0.5%"},
			{"Blue", "6", "6", "1000000", "±0.25%"}, 
			{"Violet", "7", "7", "10000000", "±0.1%"},
			{"Gray", "8", "8", "100000000", "±10%"},
			{"White", "9", "9", "1000000000", ""},
			{"Gold", "", "", "0.1", "±5%"},
			{"Silver", "", "", "0.01", "±10%"},
			{"None", "", "", "", "±20%"}
	};
	// Abstract method passed to child classes
	abstract String get(String color);

}