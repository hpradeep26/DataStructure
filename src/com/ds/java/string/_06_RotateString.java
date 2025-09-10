package com.ds.java.string;

public class _06_RotateString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean rotateString(String s, String goal) {
        // Strings must be same length to be rotations of each other
        if (s.length() != goal.length()) {
            return false; 
        }
        // Try all possible rotations of s
        for (int i = 0; i < s.length(); i++) {
            String rotated = s.substring(i) + s.substring(0, i); 
            if (rotated.equals(goal)) {
                return true;  // Return true if a match is found
            }
        }
        return false;  
    }
	
	 public boolean rotateString1(String s, String goal) {
	        if (s.length() != goal.length()) {
	            return false;  
	        }
	        String doubledS = s + s;  // Concatenate s with itself
	        return doubledS.contains(goal);  // Check if goal is a substring of s + s
	    }


}
