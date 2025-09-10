package com.ds.java.string;

public class _02_PalindromeCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean palindromeCheck(String s) {
        int left = 0;               
        int right = s.length() - 1; 

        // Iterate while start pointer is less than end pointer
        while (left < right) {
            // If characters  don't match, it's not a palindrome
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;   
            right--;  
        }
        return true; 
    }

}
