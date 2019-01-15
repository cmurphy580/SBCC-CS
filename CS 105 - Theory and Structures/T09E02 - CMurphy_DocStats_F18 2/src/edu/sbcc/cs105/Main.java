package edu.sbcc.cs105;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		//Test the Goblin text and print out the number of characters, words, and lines.
		DocStats text = new DocStats("goblin.txt");
		System.out.printf("Number of Characters: %d", text.getNumberOfCharacters());
		System.out.printf("Number of Words: %d", text.getNumberOfWords());
		System.out.printf("Number of Lines: %d", text.getNumberOfLines());

	}

}
