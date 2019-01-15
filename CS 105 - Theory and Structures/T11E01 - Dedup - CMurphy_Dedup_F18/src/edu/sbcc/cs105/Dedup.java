package edu.sbcc.cs105;

import java.io.*;
import java.util.*;

public class Dedup {
	private String filename;

	public Dedup(String filename) throws Exception {
		//pass file name to instance variable
		this.filename = filename;
	}

	public int howMany(int ofThisValue) {
		int occurences = 0;
		//open scanner
		Scanner scnr;
		//try to open file and pass data to scanner if exception is thrown, catch it and print message.
		try {
			scnr = new Scanner(new File(filename));
			//while there is another integer
			while (scnr.hasNextInt()) {
				//compare that integer with the argument
				if (scnr.nextInt() == ofThisValue)
					//if matched increment occurrences
					occurences++;
			}
			//close scanner so file can be read from the beginning if another method is ran. 
			scnr.close();
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
		return occurences;
	}

	public ArrayList<Integer> returnUnique() {
		//create ArrayList of integers.
		ArrayList<Integer> uniqueValues = new ArrayList<Integer>();
		//open scanner
		Scanner scnr;
		//try to open file and pass data to scanner if exception is thrown, catch it and print message.v
		try {
			scnr = new Scanner(new File(filename));
			// while next integer in file. 
			while (scnr.hasNextInt()) {
				int value = scnr.nextInt();
				//if the value is not already in the array, add it to the ArrayList. 
				if (uniqueValues.indexOf(value) < 0)
					uniqueValues.add(value);
			}
			// close the scanner so if new new scanner is open, it starts from the beginning of the file.
			scnr.close();
			// sort the array in place.
			Collections.sort(uniqueValues);
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
		return uniqueValues;
	}
}
