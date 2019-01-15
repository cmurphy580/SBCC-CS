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
 * This class creates letters in an automated fashion.
 *
 */
public class Letter {
	private String from;
	private String to;
	private String message;
    /**
     * Constructor that sets the letter writer and recipient.
     *
     * @param from
     *            Person who is writing the letter.
     * @param to
     *            Person to whom the letter is addressed.
     */
    public Letter(String from, String to) {
    	this.from = from; 
    	this.to = to;
    	this.message = ""; 
    }
 
    /**
     * Add a line of text to the body of the letter.
     *
     * @param line
     */
    public void addLine(String line) {
    	line = line + "\n";
    	message += line ; 
    }
 
    /**
     * Creates a letter using the designated sender and recipient. The format of
     * the letter is:
     *
     * Dear recipient name: blank line first line of the body second line of the
     * body ... last line of the body blank line Sincerely, blank line sender
     * name
     *
     * @return the formatted letter.
     */
    public String getText() {
    	String firstLine = "Dear " + to + ":\n\n"; 
    	String lastLine = "\nSincerely,\n\n" + from;
    	return firstLine + message + lastLine; 
    }
}