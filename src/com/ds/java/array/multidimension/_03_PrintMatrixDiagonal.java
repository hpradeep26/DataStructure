package com.ds.java.array.multidimension;

public class _03_PrintMatrixDiagonal {

	public static void main(String[] args) {
		int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
		//00,11,22 
		//02,11,20
		printDiagonal(arr);

	}

	private static void printDiagonal(int[][] arr) {
		int row = arr.length;
		int col = arr[0].length;
		int i = 0;
		while(i<col) {
			System.out.print(arr[i][i] +", ");
			i++;
		}
		System.out.println();
		int first = 0;
		int second = col-1;
		int k = 0;
		while(first<row) {
			System.out.print(arr[first][second] +", ");
			first++;
			second--;
		}
		System.out.println();
		
	}

}
