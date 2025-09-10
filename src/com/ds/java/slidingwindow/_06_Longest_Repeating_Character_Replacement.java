package com.ds.java.slidingwindow;

public class _06_Longest_Repeating_Character_Replacement {

	public static void main(String[] args) {
		String s ="BAABAABBBAAA"; int k = 2;
		System.out.println(characterReplacement(s, k));

	}
	
	
	 public static int characterReplacementBrute(String s, int k) {
		 int maxLen = 0;
		 int maxFreq = 0;
		 for (int i = 0; i < s.length(); ++i) {
			    int[] hash = new int[26];
			    for (int j = i; j < s.length(); ++j) {
			    	 hash[s.charAt(j) - 'A']++;
			    	 maxFreq = Math.max(maxFreq, hash[s.charAt(j) - 'A']);
			    	 int changes = (j - i + 1) - maxFreq;
			    	  if (changes <= k) {
		                    maxLen = Math.max(maxLen, j - i + 1);
		                } else {
		                    break;
		                }
			    }
			 
		 }
		 return maxLen;
	 
	 }
	
	
	 public static int characterReplacement(String s, int k) {
		 int maxLen = 0;
	        
	        /* Variable to track the maximum frequency
	        of any single character in the current window*/
	        int maxFreq = 0;
	        
	        // Pointers to maintain the current window [l, r]
	        int l = 0, r = 0;
	        
	        // Hash array to count frequencies of characters
	        int[] hash = new int[26];
	        
	        while (r < s.length()) {
	        	  hash[s.charAt(r) - 'A']++;
	        	  maxFreq = Math.max(maxFreq, hash[s.charAt(r) - 'A']);
	        	  if ((r - l + 1) - maxFreq > k) {
	        		  hash[s.charAt(l) - 'A']--;
	        		  l++;
	        	  }
	        	  
	        	  /* Update maxLen with the length 
	              of the current valid substring*/
	              maxLen = Math.max(maxLen, r - l + 1);
	              
	              // Move right pointer forward to expand window
	              r++;
	        	
	        }
		 
		 return maxLen;
	 
	 }

}
