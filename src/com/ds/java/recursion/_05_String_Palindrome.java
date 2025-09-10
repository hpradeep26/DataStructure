package com.ds.java.recursion;

public class _05_String_Palindrome {

	public static void main(String[] args) {

		String s ="gadag";
		System.out.println(palindromeCheck(s));

	}
	
	public static boolean palindromeCheck(String s) {
		return isPalindrome(0, s.length()-1, s);
    }
	
private static boolean isPalindrome(int left, int right, String s) {
	
		if(left>=right) {
			return true;
		}
		
		if(s.charAt(left) != s.charAt(right)) {
			return false;
		}
		
		return isPalindrome(left+ 1, right-1, s);
	}

}
