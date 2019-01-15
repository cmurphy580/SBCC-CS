package edu.sbcc.cs105;

public class Main {

	public static void main(String[] args) throws Exception {
		/*
		Dedup smallText = new Dedup("small.txt");
		System.out.println(smallText.howMany(2));
		System.out.println(smallText.returnUnique());
		*/
		
		Dedup largeText = new Dedup("large.txt");
		System.out.println(largeText.howMany(639));
		System.out.println(largeText.howMany(308));
		System.out.println(largeText.returnUnique());
	}

}
