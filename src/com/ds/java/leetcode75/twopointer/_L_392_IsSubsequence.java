package com.ds.java.leetcode75.twopointer;

public class _L_392_IsSubsequence {

	public static void main(String[] args) {
		String s = "abc";
		String t = "ahbgdc";
		System.out.println(IsSubsequence(s, t));

	}
	
	public static boolean IsSubsequence(String s, String t) {
        int i =0;
        int j =0;
        int slen = s.length();
        int tlen = t.length();
        while(i<slen && j<tlen){
            if(s.charAt(i)==t.charAt(j)){
                i++;
            }
            j++;
        }
        return i == slen;
    }

}
