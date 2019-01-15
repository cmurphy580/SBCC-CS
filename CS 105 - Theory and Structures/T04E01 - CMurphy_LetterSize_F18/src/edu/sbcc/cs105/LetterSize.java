/**
 * CS 105 Theory and Practice I
 * CRN: [39626]
 * Assignment: LetterSize
 *
 * Statement of code ownership: I hereby state that I have written all of this
 * code and I have not copied this code from any other person or source.
 *
 * @author [Conor Murphy]
 */
package edu.sbcc.cs105;
 
/**
 * This class converts the size of letters.
 *
 */
public class LetterSize {
	private double widthInMillimeters;
	private double heightInMillimeters;
 
    public LetterSize(double widthInInches, double heightInInches) {
    	this.widthInMillimeters = (widthInInches * 25.4);
    	this.heightInMillimeters = (heightInInches * 25.4);
	}
 
    public double getWidthInMillimeters() {
    	return this.widthInMillimeters;
    }
 
    public double getHeightInMillimeters() {
    	return this.heightInMillimeters;
    }
}