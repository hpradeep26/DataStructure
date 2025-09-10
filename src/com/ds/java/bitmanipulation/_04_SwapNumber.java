package com.ds.java.bitmanipulation;

public class _04_SwapNumber {
	
	public static void main(String[] args) {
		swapNumber(5,6);
	}

	private static void swapNumber(int a, int b) {
		System.out.println("Before Swap a = "+a+ " b= "+b);
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("After Swap a = "+a+ " b= "+b);
		
	}

}
