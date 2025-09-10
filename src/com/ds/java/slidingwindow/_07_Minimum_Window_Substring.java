package com.ds.java.slidingwindow;

public class _07_Minimum_Window_Substring {

	public static void main(String[] args) {
		//Input : s = "ADOBECODEBANC" , t = "ABC"
        //Output : "BANC"
		//aAbBDdcC  t = "Bc"
		//Output:"BDdc"
		String s = "ADOBECODEBANC"; String t = "ABC";
		System.out.println(minWindow(s, t));
	}
	
	 public static String minWindow(String s, String t) {
	        
	        /* Variable to store the minimum
	        length of substring found*/
	        int minLen = Integer.MAX_VALUE;
	        
	        /* Variable to store the starting index
	        of the minimum length substring*/
	        int sIndex = -1;
	        
	        // Iterate through string s
	        for (int i = 0; i < s.length(); ++i) {
	            
	            // Array to count frequencies of characters in t
	            int[] hash = new int[256];
	            for (char c : t.toCharArray()) {
	                hash[c]++;
	            }
	            
	            int count = 0;
	            
	            // Iterate through current window 
	            for (int j = i; j < s.length(); ++j) {
	                if (hash[s.charAt(j)] > 0) {
	                    count++;
	                }
	                hash[s.charAt(j)]--;
	                
	                /* If all characters from t 
	                are found in current window*/
	                if (count == t.length()) {
	                    
	                    /* Update minLen and sIndex 
	                    if current window is smaller*/
	                    if (j - i + 1 < minLen) {
	                        minLen = j - i + 1;
	                        sIndex = i;
	                    }
	                    break;
	                }
	            }
	        }
	        
	        // Return the minimum length substring from s
	        return (sIndex == -1) ? "" : s.substring(sIndex, sIndex + minLen);
	    }
	 
	 public String minWindowOptimal(String s, String t) {
	        
	        /* Variable to store the minimum 
	        length of substring found */
	        int minLen = Integer.MAX_VALUE;
	        
	        /* Variable to store the starting index
	        of the minimum length substring */
	        int sIndex = -1;
	        
	        /* Array to count frequencies
	        of characters in string t*/
	        int[] hash = new int[256];
	        
	        // Count the frequencies of characters in t
	        for (char c : t.toCharArray()) {
	            hash[c]++;
	        }
	            
	        int count = 0;
	        int l = 0, r = 0;
	        
	        // Iterate through current window 
	        while (r < s.length()) {
	            // Include the current character in the window
	            if (hash[s.charAt(r)] > 0) {
	                count++;
	            }
	            hash[s.charAt(r)]--;
	                
	            /* If all characters from t 
	            are found in current window */
	            while (count == t.length()) {
	                    
	                /* Update minLen and sIndex
	                if current window is smaller */
	                if (r - l + 1 < minLen) {
	                    minLen = r - l + 1;
	                    sIndex = l;
	                }
	                
	                // Remove leftmost character from window
	                hash[s.charAt(l)]++;
	                if (hash[s.charAt(l)] > 0) {
	                    count--;
	                }
	                l++;
	            }
	            r++;
	        }
	        
	        // Return minimum length substring from s
	        return (sIndex == -1) ? "" : s.substring(sIndex, sIndex + minLen);
	    }

}
