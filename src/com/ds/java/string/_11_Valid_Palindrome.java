package com.ds.java.string;

public class _11_Valid_Palindrome {
	//https://leetcode.com/problems/valid-palindrome/
	public static void main(String[] args) {
		//Input: s = "A man, a plan, a canal: Panama"
		// output = "amanaplanacanalpanama" is a palindrome.
	}
	
	 public boolean isPalindrome(String s) {
	        s = s.toLowerCase();
	        s = retainAlphaNumneric(s);
	        int length = s.length();
	        for(int i=0;i<length/2;i++){
	            if(s.charAt(i) != s.charAt(length-i-1))
	               return false; 
	        }
	        return true;

	    }

	    private String retainAlphaNumneric(String s){
	        StringBuilder builder = new StringBuilder();
	        for(int i=0;i<s.length();i++){
	            if(Character.isLetterOrDigit(s.charAt(i))){
	                builder.append(s.charAt(i));
	            }
	        }
	        return builder.toString();
	    }
	    
	    
	    public boolean isPalindromeOptimal(String s) {
	        if (s.isEmpty()) {
	        	return true;
	        }
	        int start = 0;
	        int last = s.length() - 1;
	        while(start <= last) {
	        	char currFirst = s.charAt(start);
	        	char currLast = s.charAt(last);
	        	if (!Character.isLetterOrDigit(currFirst )) {
	        		start++;
	        	} else if(!Character.isLetterOrDigit(currLast)) {
	        		last--;
	        	} else {
	        		if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
	        			return false;
	        		}
	        		start++;
	        		last--;
	        	}
	        }
	        return true;
	    }

}
