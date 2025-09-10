package com.ds.java.string;

public class _L_1768_Merge_String_Alternately {

	public static void main(String[] args) {
		//Input: word1 = "abc", word2 = "pqr"
				//Output: "apbqcr"
		String s1 = "abcd", s2 = "p";
		System.out.println(mergeAlternately(s1, s2));

	}
	
	
	public static String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        
       int minLength = Math.min(word1.length(), word2.length());
       for(int i = 0; i<minLength ;i++) {
    	   sb.append(word1.charAt(i));
    	   sb.append(word2.charAt(i));
       }
        
       if(word2.length()>minLength) {
    	   sb.append(word2.substring(minLength));
       }
       if(word1.length()>minLength) {
    	   sb.append(word1.substring(minLength));
       }
        return sb.toString();
    }
	
	public String mergeAlternately2(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < word1.length() || i < word2.length()) {
            if (i < word1.length()) {
                result.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                result.append(word2.charAt(i));
            }
            i++;
        }
        return result.toString();
    }

}
