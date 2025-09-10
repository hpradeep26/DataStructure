package com.ds.java.array.multidimension;

public class _04_ReverseMatrix {

	public static void main(String[] args) {
		int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] reverseRow = reverseRow(arr);
		printArray(reverseRow);
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

	private static int[][] reverseRow(int[][] arr) {
		//00 01 02 03
		//10 11 12 13
		//20 21 22 23
		
		int row = arr.length;
		int col = arr[0].length;
		for(int i = 0;i<row;i++) {
			int start = i;
			int end = col-1;
			while(start<end) {
				int temp = arr[i][start];
				arr[i][start] = arr[i][end];
				arr[i][end] = temp;
				start++;end--;
			}
		}
		
		return arr;
		
	}

}
