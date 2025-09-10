package com.ds.java.bitmanipulation;

public class _L_1318_Minimum_Flips_aorb_equals_c {

	public static void main(String[] args) {
		int a = 2, b = 6, c = 5;
		minFlips(a, b, c);
		//Explanation: After flips a = 1 , b = 4 , c = 5 such that (a OR b == c)

	}
	
	 public static int minFlips(int a, int b, int c) {
	        int count = 0;
	        while (a != 0 || b != 0 || c != 0) {
	            int abit = a & 1;
	            int bbit = b & 1;
	            int cbit = c & 1;

	            if (cbit == 0) {
	                if (abit == 1) count++;
	                if (bbit == 1) count++;
	            } else {
	                if (abit == 0 && bbit == 0) count++;
	            }

	            a >>= 1;
	            b >>= 1;
	            c >>= 1;
	        }
	        return count;

	    }

}
