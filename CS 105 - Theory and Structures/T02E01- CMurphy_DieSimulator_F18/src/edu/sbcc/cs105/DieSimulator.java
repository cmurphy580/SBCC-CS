/**
 * CS 105 Theory and Practice I
 * CRN: [39626]
 * Assignment: DieSimulator
 *
 * Statement of code ownership: I hereby state that I have written all of this
 * code and I have not copied this code from any other person or source.
 *
 * @author [Conor Murphy]
 */
package edu.sbcc.cs105;
 
import java.util.*;
 
/**
 * This class simulates rolling a die by generating a random number between 1
 * and 6 inclusive.
 *
 */
public class DieSimulator {
 
    /**
     * Simulates the die roll.
     *
     * @return a random integer from 1 to 6 inclusive.
     */
    public int rollTheDie() {
        int randomDieRoll = 0;
 
        // YOUR CODE GOES FROM HERE 
        
        Random rnd  = new Random();
        randomDieRoll = rnd.nextInt(6) + 1;
 
        // TO HERE 
 
        return randomDieRoll;
    }
}
