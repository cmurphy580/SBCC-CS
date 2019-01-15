package edu.sbcc.cs105;

import java.util.Scanner;
import java.io.File; //see ZyBook for different approach
import java.io.IOException;
import java.io.FileNotFoundException;

public class DocStats {
	public String fileName;
	private File file;
	private Scanner scnr;
	private int numberOfCharacters = 0; 
	private int numberOfWords = 0;
	private int numberOfLines = 0; 
	
	public DocStats(String fileName) throws FileNotFoundException {
		this.fileName = fileName;
		
		try {
			file = new File(fileName);
			scnr = new Scanner(file);
			numberOfCharacters = (int)file.length();
			/*
			while (scnr.hasNextLine()) {
				String line = scnr.nextLine(); 
				numberOfCharacters += line.length();
			}
			*/
			while (scnr.hasNext()) {
				numberOfWords++;
				scnr.next();
			}
			while (scnr.hasNextLine()) {
				numberOfLines++;
				scnr.nextLine();
			}
			scnr.close();
		} catch(IOException message) {
			System.out.println(message.getMessage());
		}
	}
	
	public int getNumberOfCharacters() {
		return numberOfCharacters; 
	}
	
	public int getNumberOfWords() {
		return numberOfWords; 
	}
	
	public int getNumberOfLines() {
		return numberOfLines;
	}
}
