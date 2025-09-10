package com.ds.java.string;

public class _L_1071_GCD_Of_String {
	
	//https://leetcode.com/problems/greatest-common-divisor-of-strings/

	public static void main(String[] args) {
		//Input: str1 = "ABCABC", str2 = "ABC"
			//	Output: "ABC"
		//Input: str1 = "ABABAB", str2 = "ABAB"
			//	Output: "AB"
		//Input: str1 = "LEET", str2 = "CODE"
				//Output: ""
	}
	
	public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int lenGCD = gcd(str1.length(), str2.length());
        return str1.substring(0, lenGCD);   
    }

     private int gcd(int len1, int len2) {
        while (len2 != 0) {
            int temp = len1 % len2;
            len1 = len2;
            len2 = temp;
        }
        return len1;
    }

}
