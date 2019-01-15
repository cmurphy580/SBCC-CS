package edu.sbcc.cs105;

/*
 * The NumberLookup object takes a color and can return a String but it also can return a Double. 
 * Since we are extending the LookupTable object (it didn't have the ability to return a double before) we need to inherit from the LookupTable object.
 */
public abstract class NumberLookup extends LookupTable {
	// Abstract methods passed on to child objects.
	public abstract String get(String color);
	public abstract double getDouble(String color, int i);
}