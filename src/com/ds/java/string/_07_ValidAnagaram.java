package com.ds.java.string;

import java.util.Arrays;

public class _07_ValidAnagaram {

	public static void main(String[] args) {
		anagram("anagram", "nagarma");

	}
	
	public static boolean anagramStrings(String s, String t) {
        if (s.length() != t.length()) return false;

       // Convert strings to char arrays and sort them
       char[] sArray = s.toCharArray();
       char[] tArray = t.toCharArray();
       Arrays.sort(sArray);
       Arrays.sort(tArray);

       // Compare sorted arrays
       return Arrays.equals(sArray, tArray);
   }
	
	public static boolean anagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        char[] cArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        
        int[] count = new int[26];
        
        for (char c : cArray) {
			count[c - 'a']++;
		}
        
        for (char c : tArray) {
			count[c - 'a']--;
		}
        
        for (int i : count) {
			if(i!=0) {
				return false;
			}
		}
        
      return true;
   }

}
