package com.ds.java.recursion;

public class _06_Number_is_prime {

	public static void main(String[] args) {
		System.out.println(checkPrime(2));

	}
	
	public static boolean checkPrime(int num) {
	        if (num <= 1) {
	            return false; 
	        }
        return isPrime(2, num);
    }
	
	public static boolean isPrime(int i, int num) {
		System.out.println(Math.sqrt(num));
        if(i > Math.sqrt(num)) {
        	return true;
        }
        if(num%i==0) {
        	return false;
        }
        
        return isPrime(i+1, num);
    }
}
