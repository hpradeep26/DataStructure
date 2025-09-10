package com.ds.java.array.multidimension;

import java.util.Arrays;

public class _02_SearchElement {

	public static void main(String[] args) {
		int[][] arr1 = {{1,2,3},{4,5,6},{7,8,9}};
		int[] index = search(arr1,7);
		System.out.println("Element found "+Arrays.toString(index));
	}

	private static int[] search(int[][] arr, int k) {
		int row = arr.length;
		int col = arr[0].length;
		for(int i = 0;i < row; i++) {
			for(int j = 0;j < col; j++) {
				if(k==arr[i][j]) {
					return new int[] {i,j};
				}
			}
		}
		return null;
	}

}
