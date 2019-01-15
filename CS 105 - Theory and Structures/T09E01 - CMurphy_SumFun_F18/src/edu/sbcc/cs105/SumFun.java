package edu.sbcc.cs105;
import java.util.ArrayList; 

public class SumFun {
	private ArrayList<Integer> allNumbers = new ArrayList<Integer>(); 

	public void addToList(int i) {
		allNumbers.add(i);
	}
	public int sumOfAllEvenNumbers() {
		int sumEvens = 0;
		for (int i = 0; i < allNumbers.size(); i++) {
			if (allNumbers.get(i) % 2 == 0) {
				sumEvens += allNumbers.get(i);
			}
		}
		return sumEvens;
	}
	public int sumOfEvenNumbers(int start, int end) {
		int sumEvens = 0;
		for (int i = start; i <= end; i++) {
			if (allNumbers.get(i) % 2 == 0) {
				sumEvens += allNumbers.get(i);
			}
		}
		return sumEvens;
	}
	public int sumOfAllOddNumbers() {
		int sumOdds = 0;
		for (int i = 0; i < allNumbers.size(); i++) {
			if (allNumbers.get(i) % 2 != 0) {
				sumOdds += allNumbers.get(i);
			}
		}
		return sumOdds; 
	}
	public int sumOfOddNumbers(int start, int end) {
		int sumOdds = 0;
		for (int i = start; i <= end; i++) {
			if (allNumbers.get(i) % 2 != 0) {
				sumOdds += allNumbers.get(i);
			}
		}
		return sumOdds;
	}
	public int sumOfOddDigitsForItem(int itemIndex) {
		int number = allNumbers.get(itemIndex);
		//String.valueOf = returns the string representation of the number.
		String stringNumber = String.valueOf(number); 
		int sumOfOddDigits = 0;
		for (int i = 0; i < stringNumber.length(); i++) {
			int n = Integer.parseInt(String.valueOf(stringNumber.charAt(i)));
			if (n % 2 != 0) {
				//Integer.parseInt(value); = convert string into number
				sumOfOddDigits += n;
			}
		}
		return sumOfOddDigits;
	}
}
