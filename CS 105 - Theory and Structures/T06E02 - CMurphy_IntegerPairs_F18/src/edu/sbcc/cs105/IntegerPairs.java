package edu.sbcc.cs105;
 
import java.util.*;
 
public class IntegerPairs {
	private String str; 
	
    public void setPairString(String str) {
    	this.str = str;  
    }
    
    public boolean hasTwoPairs() {
    	if (str == null) {
    		return false;
    	}
    	
    	Scanner string = new Scanner(str);
    	int first = string.nextInt();
    	int second = string.nextInt();
    	int third = string.nextInt(); 
    	int fourth = string.nextInt();
    	string.close();
    	
    	if (first == second && third == fourth) {
    		return true;
    	} else if (first == third && second == fourth) {
    		return true;
    	} else if (first == fourth && second == third) {
    		return true;
    	} else {
    		return false;
    	}
    }
}
