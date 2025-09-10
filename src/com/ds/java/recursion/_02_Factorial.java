package com.ds.java.recursion;

import java.util.Scanner;

public class _02_Factorial {

	public static void main(String[] args) {
		System.out.println("Enter Input");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int output = factorial(n);
		System.out.println("Factorial of "+n+"is "+output );
	}

	private static int factorial(int n) {
		if(n==0||n==1) {
			return 1;
		}
		System.out.println(n);
		return n * factorial(n-1);
	}

}
