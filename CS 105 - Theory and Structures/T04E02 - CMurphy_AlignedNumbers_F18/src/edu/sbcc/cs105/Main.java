/**
 * CS 105 Theory and Practice I
 * CRN: [39626]
 * Assignment: AlignedNumbers
 *
 * Statement of code ownership: I hereby state that I have written all of this
 * code and I have not copied this code from any other person or source.
 *
 * @author [Conor Murphy]
 */
package edu.sbcc.cs105;
import java.util.*;
/**
 * This class tests the AlignedNumbers object.
 *
 */
public class Main {
    /**
     * Test this code by asking for two numbers, computing the various stats,
     * and then printing it out.
     *
     * @param args
     *            command line values. Not used in this example.
     */
    public static void main(String[] args) {
    	System.out.println("Input first number: ");
    	Scanner scnrOne = new Scanner(System.in);
    	int firstNumber = scnrOne.nextInt(); 
    	
    	System.out.println("Input second number: ");
    	Scanner scnrTwo = new Scanner(System.in);
    	int secondNumber = scnrTwo.nextInt();
    	
    	AlignedNumbers math = new AlignedNumbers(); 
    	math.setFirstNumber(firstNumber);
    	math.setSecondNumber(secondNumber);
    	math.printStats();  
    	
    	scnrOne.close();
    	scnrTwo.close();
    }
}