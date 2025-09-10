package com.ds.java.array.multidimension;

public class _01_AddtwoMatrix {

	public static void main(String[] args) {
		int[][] arr1 = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] arr2 = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] sum = sum(arr1,arr2);
		
		printArray(sum);
	}

	private static void printArray(int[][] sum) {
		int row = sum.length;
		int col = sum[0].length;
		for(int i = 0;i < row; i++) {
			for(int j = 0;j < col; j++) {
				System.out.print(sum[i][j] +",");
			}
			System.out.println();
		}
		
	}

	private static int[][] sum(int[][] arr1, int[][] arr2) {
		int row = arr1.length;
		int col = arr1[0].length;
		int[][] res = new int[row][col];
		for(int i = 0;i < row; i++) {
			for(int j = 0;j < col; j++) {
				res[i][j] = arr1[i][j] + arr2[i][j];
			}
		}
		return res;
	}

}
