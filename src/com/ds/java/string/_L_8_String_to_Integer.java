package com.ds.java.string;

public class _L_8_String_to_Integer {

	public static void main(String[] args) {
		String s = "-2147483647";
		System.out.println(myAtoi(s));

	}
	
	public static int myAtoi(String s) {
		int i = 0;
        int n = s.length();
        //skip whitespaces
        while(i < n && s.charAt(i) == ' '){
            i++;
        }
        int sign = 1;
        if(i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')){
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        long result = 0;
        while(i<n && Character.isDigit(s.charAt(i))){
            result = result*10 + (s.charAt(i) - '0');
            //to control overflow
            System.out.println(sign*result);
            if(sign*result > Integer.MAX_VALUE) return Integer.MAX_VALUE;//(2^31 - 1)
            if(sign*result < Integer.MIN_VALUE) return Integer.MIN_VALUE;//(-2^31)
            i++;
        }
        return (int)(sign*result);
    }

}
