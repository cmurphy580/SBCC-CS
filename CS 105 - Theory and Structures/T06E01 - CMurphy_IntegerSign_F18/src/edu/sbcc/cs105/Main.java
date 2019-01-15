package edu.sbcc.cs105;

public class Main {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub 
    	IntegerSign n1 = new IntegerSign(3);
    	System.out.println("n1 is equal to: " + n1.getNumber());
    	System.out.println("n1 is equal to 0: " + n1.isZero());
    	System.out.println("n1 is positive: " + n1.isPositive());
    	System.out.println("n1 is negative: " + n1.isNegative());
    	
    	IntegerSign n2 = new IntegerSign(-3);
    	System.out.println("n1 is equal to: " + n2.getNumber());
    	System.out.println("n2 is equal to 0: " + n2.isZero());
    	System.out.println("n2 is positive: " + n2.isPositive());
    	System.out.println("n1 is negative: " + n2.isNegative());
    	
    	IntegerSign n3 = new IntegerSign(0);
    	System.out.println("n1 is equal to: " + n3.getNumber());
    	System.out.println("n3 is equal to 0: " + n3.isZero());
    	System.out.println("n3 is positive: " + n3.isPositive());
    	System.out.println("n1 is negative: " + n3.isNegative());
    }
 
}