package com.ds.java.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class _05_LongestSubstringWithAtMostKdistinctCharacters {

	public static void main(String[] args) {
		String s = "aababbcaacc"; int k = 2;
		System.out.println(kDistinctCharOptimal(s, k));
	}
	
	
	public static int kDistinctChar(String s, int k) {
        int maxLen =0;
        int n = s.length();
        for(int i = 0 ;i < n; i++) {
			Set<Character> set = new HashSet<>();
			for (int j = i; j < n; j++) {
				set.add(s.charAt(j));
				
				if(set.size()<=k) {
					maxLen = Math.max(maxLen, j-i+1);
				}else {
					break;
				}
			}
        }	
				
        return maxLen;
    }
	
	public static int kDistinctCharBettwr(String s, int k) {
        int maxLen =0;
        int n = s.length();
        int l=0,r=0;
     // Hash map to store character frequencies
        HashMap<Character, Integer> mpp = new HashMap<>();
        while(r < n) {
        	 char currentChar = s.charAt(r);
             mpp.put(currentChar, mpp.getOrDefault(currentChar, 0) + 1);
         
             while (mpp.size() > k) {
            	 char leftChar = s.charAt(l);
            	 mpp.put(leftChar, mpp.get(leftChar) - 1);
            	 if (mpp.get(leftChar) == 0) {
                     
                     /* Remove character from map 
                    if its frequency becomes zero*/
                    mpp.remove(leftChar);
                }
                // Move left pointer to the right
                l++;
             }
         
         if(mpp.size()<=k) {
        	 maxLen = Math.max(maxLen, r-l+1);
         }
         r++;
         
        }
        return maxLen;
    }
	
	public static int kDistinctCharOptimal(String s, int k) {
        int maxLen =0;
        int n = s.length();
        int l=0,r=0;
     // Hash map to store character frequencies
        HashMap<Character, Integer> mpp = new HashMap<>();
        while(r < n) {
        	 char currentChar = s.charAt(r);
             mpp.put(currentChar, mpp.getOrDefault(currentChar, 0) + 1);
         
             if (mpp.size() > k) {
            	 char leftChar = s.charAt(l);
            	 mpp.put(leftChar, mpp.get(leftChar) - 1);
            	 if (mpp.get(leftChar) == 0) {
                     
                     /* Remove character from map 
                    if its frequency becomes zero*/
                    mpp.remove(leftChar);
                }
                // Move left pointer to the right
                l++;
             }
         
         if(mpp.size()<=k) {
        	 maxLen = Math.max(maxLen, r-l+1);
         }
         r++;
         
        }
        return maxLen;
    }

}
