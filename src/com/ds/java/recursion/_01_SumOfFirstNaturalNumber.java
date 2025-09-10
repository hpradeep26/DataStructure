package com.ds.java.recursion;

import java.util.Scanner;

public class _01_SumOfFirstNaturalNumber {

	public static void main(String[] args) {
		System.out.println("Enter Input");
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		int n = sum(number);
		System.out.println("Sum of Natural Number - "+n);
	}

	private static int sum(int n) {
		if(n==1)
			return 1;
		return n + sum(n-1);
	}

}
