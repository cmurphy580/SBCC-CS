package edu.sbcc.cs105;

public class Main {

	public static void main(String[] args) {
		IntegerPairs ints = new IntegerPairs();
		ints.setPairString("0 1 1 0");
		System.out.println(ints.hasTwoPairs());
		
		IntegerPairs ints_two = new IntegerPairs();
		ints_two.setPairString("1 2 3 4");
		System.out.println(ints_two.hasTwoPairs()); 
		
		IntegerPairs ints_three = new IntegerPairs();
		ints_three.setPairString("1 1 1 1");
		System.out.println(ints_three.hasTwoPairs()); 
	}

}
