package edu.sbcc.cs105;

import java.util.ArrayList;

public class Factors {
	private int numberToFactor; 
	private ArrayList <Integer> factors = new ArrayList<Integer>();
	private int factorIndex = 0; 
	private int factor = 2;
	
	public Factors(int numberToFactor) {
		this.numberToFactor = numberToFactor; 
		getFactors();
	}
	public void getFactors() { 
		while (factor <= numberToFactor) {
			if (numberToFactor % factor == 0) {
				numberToFactor /= factor; 
				factors.add(factor);
			} else {
				factor++;
			}
		}
	}

	public boolean hasMoreFactors() {
		if (factorIndex >= factors.size()) {
			return false; 
		} else {
			return true; 
		}
	}

	public int nextFactor() {
		int value = factors.get(factorIndex);
		factorIndex++;
		return value;
		
	}
	/*
	public ArrayList getList() {
		return factors; 
	}
	*/
}
