package edu.sbcc.cs105;
 
public class IntegerSign {
	private int number;
    public IntegerSign(int numberToStore) {
    	number = numberToStore;
    }
    public int getNumber() {
    	return number;
    }
    public boolean isZero() {
    	return number == 0;
    }
 
    public boolean isPositive() {
    	return number >= 0;
    }
    public boolean isNegative() {
    	return number < 0;
    }
}