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
import java.lang.Math;
/**
 * This class computes the statistics of two integers and prints them out.
 *
 */
public class AlignedNumbers {
    private int firstNumber;
    private int secondNumber;
    
    public void setFirstNumber(int firstNumber) {
    	this.firstNumber = firstNumber; //this. used only when variable name is equal to instance name
    }
    public void setSecondNumber(int secondNumber) {
    	this.secondNumber = secondNumber;
    }
    public int getSum() {
    	return firstNumber + secondNumber; 
    }
    public double getAverage() {
    	return (firstNumber + secondNumber) / 2.0;
    }
    public int getDifference() {
    	return secondNumber - firstNumber; 
    }
    public int getProduct() {
    	return firstNumber * secondNumber;
    }
    public int getDistance() {
    	return Math.abs(firstNumber - secondNumber);
    }
    public int getMaximum() {
    	return Math.max(firstNumber, secondNumber); 
    }
    public int getMinimum() {
    	return Math.min(firstNumber, secondNumber);
    }
    public void printStats() {
    	System.out.printf("Sum:  %24d\n", getSum());
    	System.out.printf("Average:  %23.2f\n", getAverage());
    	System.out.printf("Difference:  %17d\n", getDifference());
    	System.out.printf("Product:  %20d\n", getProduct());
    	System.out.printf("Distance:  %19d\n", getDistance());
    	System.out.printf("Maximum:  %20d\n", getMaximum());
    	System.out.printf("Minimum:  %20d\n", getMinimum());
    }
}