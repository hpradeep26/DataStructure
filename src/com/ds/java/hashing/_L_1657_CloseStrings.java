package com.ds.java.hashing;

import java.util.Arrays;

public class _L_1657_CloseStrings {

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "bca";
		closeStrings(s1, s2);

	}
	
	 public static boolean closeStrings(String word1, String word2) {
	       int[] freq1 = new int[26];
	       int[] freq2 = new int[26];
	       
	       for (char ch : word1.toCharArray()) {
	    	   freq1[ch - 'a']++;
	       }
	       
	       for (char ch : word2.toCharArray()) {
	    	   freq2[ch - 'a']++;
	       }
	       
	       for(int i = 0 ; i<26;i++) {
	    	   if(freq1[i]>0 && freq2[i]==0 || freq1[i]==0 && freq2[i]>0) {
	    		   return false;
	    	   }
	       }
	       
	       Arrays.sort(freq1);
	       Arrays.sort(freq2);
	       
	       for(int i = 0; i < 26;i++) {
	    	   if(freq1[i] != freq2[i] ) {
	    		   return false;
	    	   }
	       }
	       
	       return true;
	  }

}
