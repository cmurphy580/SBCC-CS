package edu.sbcc.cs105;

import sbccutils.*;
/*
 * The project name of this exercise is Instafilter.
 * The purpose of this assignment is to learn how to work with Interfaces, iteration, 2-D Arrays, and image processing. You get more practice on how to write all of your own code and Javadoc comments.
 * @author Conor Murphy
 * */
public class Main {
	/* Used to test Instafilter code.
	 * Where we are implementing the user interface.
	 * @param String array of arguments
	 * */
	public static void main(String[] args) {
		Instafilter instafilter = new Instafilter();
		
		 
		instafilter.addFilter(new Sepia());
		instafilter.run();
	}

}
