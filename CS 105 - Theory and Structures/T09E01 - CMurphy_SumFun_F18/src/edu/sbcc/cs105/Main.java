package edu.sbcc.cs105;

public class Main {

	public static void main(String[] args) {
		
		SumFun s = new SumFun();
		for (int i = 0; i < 850; i++) {
			s.addToList(i);
		}
		System.out.print(s.sumOfAllOddNumbers());
		/*
		SumFun s = new SumFun();
		for (int i = 1000; i < 20000; i++) {
			s.addToList(i);
		}
		System.out.println(s.getValue(3));
		System.out.print(s.sumOfOddDigitsForItem(3));
		*/
	}

}
