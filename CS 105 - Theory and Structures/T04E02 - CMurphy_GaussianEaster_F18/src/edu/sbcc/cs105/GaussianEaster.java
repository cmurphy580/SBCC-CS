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
/**
 * This class computes the month and day of Easter given the year. The only
 * instance variables allowed are n (the month) and p (the day).
 *
 */
public class GaussianEaster {
	private int n;
	private int p;
	
    public GaussianEaster(int y) {
    	int a = y % 19; 
    	int b = y / 100;
    	int c = y % 100; 
    	int d = b / 4; 
    	int e = b % 4; 
    	int g = (8 * b + 13) / 25;
    	int h = (19 * a + b - d - g + 15) % 30; 
    	int j = c / 4;
    	int k = c % 4; 
    	int m = (a + 11 * h) / 319; 
    	int r = (2 * e + 2 * j - k - h + m + 32) % 7;
    	
    	n = (h - m + r + 90) / 25;
    	p = (h - m + r + n + 19) % 32; 
    }
    public int getN() {
    	return n;
    }
    public int getP() {
    	return p; 
    }
}