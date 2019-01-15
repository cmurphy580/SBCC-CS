package edu.sbcc.cs105;
/*
 *@author Conor Murphy
 * */
public class Main {
	/*
	 * @params string array of colors
	 * */
	public static void main(String[] args) {
		ResistorDecoder r = new ResistorDecoder();
		String[] resistor0 = { "Black", "Brown", "Black", "Gold" };
		System.out.println("Expected output: 1Ω, ±5% Actual output: " + r.decodeResistor(resistor0));
	}

}
