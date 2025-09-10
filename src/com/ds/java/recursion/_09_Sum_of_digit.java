package com.ds.java.recursion;

public class _09_Sum_of_digit {

	public static void main(String[] args) {
		System.out.println(addDigits(567));

	}
	
	public static int addDigits(int num) {
       if (num < 10) {
    	   return num;
       }
       
       int sum =0;
       while(num>0) {
    	   int d = num % 10;
    	   sum = sum + d;
    	   num = num / 10;
       }
       
       return addDigits(sum);
    }

}
