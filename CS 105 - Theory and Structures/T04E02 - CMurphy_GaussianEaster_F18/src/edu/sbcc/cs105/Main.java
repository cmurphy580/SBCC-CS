/**
 * CS 105 Theory and Practice I
 * CRN: [39626]
 * Assignment: GaussianEaster
 *
 * Statement of code ownership: I hereby state that I have written all of this
 * code and I have not copied this code from any other person or source.
 *
 * @author [Conor Murphy]
 */
package edu.sbcc.cs105;
import java.util.*;
/**
 * This class tests the GaussianEaster object.
 *
 */
public class Main {
    /**
     * Test this code by asking for a year and then having the GaussianEaster class compute the value.
     *
     * @param args
     *            command line values. Not used in this example.
     */
    public static void main(String[] args) {
    	System.out.print("Enter a year: ");
    	Scanner input = new Scanner(System.in);
    	int year = input.nextInt(); 
    	
    	GaussianEaster easterDate = new GaussianEaster(year);
    	System.out.printf("Year: %d Month: %d Day: %d", year, easterDate.getN(), easterDate.getP());
    	
    	input.close();
    }
}