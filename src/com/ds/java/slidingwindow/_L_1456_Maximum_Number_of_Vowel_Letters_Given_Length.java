package com.ds.java.slidingwindow;

public class _L_1456_Maximum_Number_of_Vowel_Letters_Given_Length {

	public static void main(String[] args) {
		String s = "leetcode"; int k = 3;
		System.out.println(maxVowels(s, k));

	}
	
	
	public static int maxVowels(String s, int k) {
        String vowels = "aeiou";
        int maxCount = 0;
        int count = 0;
        for(int i=0;i<k;i++){
           char ch = s.charAt(i); 
           if(vowels.indexOf(ch) != -1) {
        	   count++;
           }
        }
        maxCount = Math.max(count,maxCount);
        for(int i = k;i<s.length();i++){
             char removeChar = s.charAt(i-k);
             if(vowels.indexOf(removeChar)!=-1) {
            	 count--;
             }
             char addChar = s.charAt(i);
             if(vowels.indexOf(addChar)!=-1) {
            	 count++;
             }
             maxCount = Math.max(count,maxCount);
        }
        return maxCount;
    }

}
