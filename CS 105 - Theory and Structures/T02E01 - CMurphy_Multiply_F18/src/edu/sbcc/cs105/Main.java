/**
 * CS 105 Theory and Practice I
 * CRN: [39626]
 * Assignment: Multiply
 *
 * Statement of code ownership: I hereby state that I have written all of this
 * code and I have not copied this code from any other person or source.
 *
 * @author [Conor Murphy]
 */
package edu.sbcc.cs105;
 
/**
 * This class tests the Multiply object.
 *
 */
public class Main {
 
    /**
     * This method creates a Multiply object and then uses it to multiply 2 by
     * 3. It prints out this result along with the expected result for error
     * checking.
     *
     * @param args
     *            command line values. Not used in this example.
     */
    public static void main(String[] args) {
        Multiply multiply = new Multiply();
 
        int shouldBeSix = multiply.byTwo(3);
 
        System.out.println("If you double 3 you should get 6 and we get "
                + shouldBeSix + ".");
 
    }
 
}
