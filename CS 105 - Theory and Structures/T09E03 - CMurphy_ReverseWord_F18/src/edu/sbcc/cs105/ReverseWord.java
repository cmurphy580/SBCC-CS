package edu.sbcc.cs105;

public class ReverseWord {
	//private instance variable.
	private String word = "";
	
	public void setWord(String word) {
		//Set the word to the private instance variable.
		this.word = word; 
	}
	
	public String getWord() {
		//Getter Method.
		return word; 
	}
	
	public String getReversedWord() {
		//Put characters in reversed order into an empty string.
		String result = "";
		//For loop starts at the end of the string and iterates in reverse order. 
		for (int i = word.length()-1; i >= 0; i--) {
			//add the character at the index to the empty string.
			result += word.charAt(i);
		}
		//return the string that should be the word in reverse.
		return result;  
	}
}
