/**
 * CS 105 Theory and Practice I
 * CRN: [39626]
 * Assignment: Letter
 *
 * Statement of code ownership: I hereby state that I have written all of this
 * code and I have not copied this code from any other person or source.
 *
 * @author [Conor Murphy]
 */
package edu.sbcc.cs105;
 
/**
 * This class tests the Letter object.
 *
 */
public class Main {
 
    /**
     * Test this code by creating a letter in the form shown in the problem
     * description.
     *
     * @param args
     *            command line values. Not used in this example.
     */
    public static void main(String[] args) {
    	Letter l = new Letter("Joseph", "Mary");
    	l.addLine("Hi!");
    	l.addLine("I'm on my way home.");
    	l.addLine("Do you need anything from the market?"); 
    	System.out.print(l.getText());
    }
}
