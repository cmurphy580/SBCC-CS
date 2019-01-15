package edu.sbcc.cs105;

public class AtmPin {
	static private String pin = "1234";
	String attempt; 
	boolean isLockedOut = false;
	int loginAttempts = 0;
	
	public boolean acceptPinCode(String code) {
		attempt = code; 
		if (pin.equals(code) && isLockedOut == false) {
			resetPasswordAttempts();
			return true; 
		} else {
			loginAttempts += 1;
			return false; 
		}
	}
	
	public boolean isBadPassword() {
		return !pin.equals(attempt);
	}
	
	public boolean isBlocked() {
		if (loginAttempts > 3) {
			isLockedOut = true;
			return isLockedOut;
		} else {
			return isLockedOut; 
		}
	}
	
	public void resetPasswordAttempts() {
		isLockedOut = false;
		loginAttempts = 0;
	}
}
