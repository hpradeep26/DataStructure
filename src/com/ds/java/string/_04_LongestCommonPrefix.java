package com.ds.java.string;

import java.util.Arrays;

public class _04_LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String longestCommonPrefix(String[] texts) {
        // Use StringBuilder to build the result
        StringBuilder commonPrefix = new StringBuilder();
        
        // Sort the array to get the lexicographically smallest and largest strings
        Arrays.sort(texts);
        // First string (smallest in sorted order)
        String first = texts[0]; 
        // Last string (largest in sorted order)
        String last = texts[texts.length - 1];
        
        // Compare characters of the first and last strings
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            // If characters don't match, return the current prefix
            if (first.charAt(i) != last.charAt(i)) {
                return commonPrefix.toString();
            }
            // Append the matching character to the result
            commonPrefix.append(first.charAt(i));
        }
        
        // Return the longest common prefix found
        return commonPrefix.toString();
    }

}
