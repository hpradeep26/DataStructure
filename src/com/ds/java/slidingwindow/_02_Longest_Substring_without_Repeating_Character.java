package com.ds.java.slidingwindow;

import java.util.Arrays;
import java.util.HashSet;

public class _02_Longest_Substring_without_Repeating_Character {

	public static void main(String[] args) {
		 String input = "aaaabcc";
		 lengthOfLongestSubstring(input);

	}
	
	
	public static int longestNonRepeatingSubstring1(String s) {
        int n = s.length();
        
        // Assuming all ASCII characters
        int HashLen = 256; 
        
        /* Hash table to store last
           occurrence of each character */
        int[] hash = new int[HashLen];
        
        /* Initialize hash table with
           -1 (indicating no occurrence) */
        Arrays.fill(hash, -1);

        int l = 0, r = 0, maxLen = 0;
        while (r < n) {
            /* If current character s.charAt(r) 
               is already in the substring */
            if (hash[s.charAt(r)] != -1) {
                /* Move left pointer to the right
                   of the last occurrence of s.charAt(r) */
                l = Math.max(hash[s.charAt(r)] + 1, l);
            }
            
            // Calculate the current substring length
            int len = r - l + 1;
            
            // Update maximum length found so far
            maxLen = Math.max(len, maxLen);
            
            /* Store the index of the current
               character in the hash table */
            hash[s.charAt(r)] = r;
            
            // Move right pointer to next position
            r++;
        }
       
        // Return the maximum length found
        return maxLen;
    }
	
	
	public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = 0;
        HashSet<Character> charSet = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }

            charSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;       
    }
	
	 public static int longestNonRepeatingSubstring(String s) {
	        int maxLen = 0;
	        int n = s.length();
	        for(int i=0; i<n ; i++) {
	        	
	        	int[] hash = new int[256];
	        	Arrays.fill(hash, 0);
	        	for(int j=i;j<n;j++) {
	        		
	        		if (hash[s.charAt(j)] == 1) break;
	        		
	        		hash[s.charAt(j)] = 1;
	        		
	        		int len = j - i + 1;
	        		
	        		maxLen = Math.max(maxLen, len);
	        	}
	        }
	        
	        return maxLen;
	    }

}
