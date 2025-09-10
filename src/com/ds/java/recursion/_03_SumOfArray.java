package com.ds.java.recursion;

public class _03_SumOfArray {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		int n = arraySum(arr);
		System.out.println(n);
	}

	private static int arraySum(int[] arr) {
		return sum(0,arr);
	}

	private static int sum(int index, int[] arr) {
		if(index>=arr.length) {
			return 0;
		}
		return arr[index] + sum(index+1,arr);
	}

}
