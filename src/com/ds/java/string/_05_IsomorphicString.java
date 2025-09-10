package com.ds.java.string;

import java.util.HashMap;

public class _05_IsomorphicString {

	public static void main(String[] args) {
		//Input : s = "egg" , t = "add" Output = false;
		//Input : s = "apple" , t = "bbnbm"
		isomorphicString("apple", "bbnbm");

	}
	
	public static boolean isomorphicString(String s, String t) {
        // Arrays to store the last seen positions of characters in s and t
        int[] m1 = new int[256], m2 = new int[256];
        
        // Length of the string
        int n = s.length();
        
        // Iterate through each character in the strings
        for (int i = 0; i < n; ++i) {
            // If the last seen positions of the current characters don't match, return false
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
            
            // Update the last seen positions
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        
        // If all characters match, return true
        return true;
    }
	
	 public boolean isIsomorphic(String s, String t) {
	        HashMap<Character, Character> charMap = new HashMap<>();

	        for (int i = 0; i < s.length(); i++) {
	            char sc = s.charAt(i);
	            char tc = t.charAt(i);

	            if (charMap.containsKey(sc)) {
	                if (charMap.get(sc) != tc) {
	                    return false;
	                }
	            } else if (charMap.containsValue(tc)) {
	                return false;
	            }

	            charMap.put(sc, tc);
	        }

	        return true;
	    }

}
