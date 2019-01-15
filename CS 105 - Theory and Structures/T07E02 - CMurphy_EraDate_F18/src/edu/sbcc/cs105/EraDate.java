package edu.sbcc.cs105;

import java.util.*;

public class EraDate {
	int year; 
	int month;
	int day; 
	
	public EraDate(int year, int month, int day) {
		this.year = year; 
		this.month = month;
		this.day = day; 
	}
	
	public String getIso8601Date() {
		return String.format("%d-%02d-%02d", year, month, day);
	}
	
	public void printJapaneseEraName() {
		GregorianCalendar date = new GregorianCalendar(year, month-1, day);
		boolean meiji = date.getTimeInMillis() >= new GregorianCalendar(1868, 0, 25).getTimeInMillis() && date.getTimeInMillis() <= new GregorianCalendar(1912, 6, 30).getTimeInMillis();
		boolean taisho = date.getTimeInMillis() >= new GregorianCalendar(1912, 7, 1).getTimeInMillis() && date.getTimeInMillis() <= new GregorianCalendar(1926, 11, 25).getTimeInMillis();
		boolean showa = date.getTimeInMillis() >= new GregorianCalendar(1926, 11, 26).getTimeInMillis() && date.getTimeInMillis() <= new GregorianCalendar(1989, 0, 7).getTimeInMillis();
		boolean heisei = date.getTimeInMillis() >= new GregorianCalendar(1989, 0, 8).getTimeInMillis() && date.getTimeInMillis() <= new GregorianCalendar().getTimeInMillis();;
		
		if (meiji) {
			System.out.println("Meiji");
		}
		if (taisho) {
			System.out.println("Taisho");
		}
		if (showa) {
			System.out.println("Showa");
		}
		if (heisei) {
			System.out.println("Heisei");
		}
	
	}
}
