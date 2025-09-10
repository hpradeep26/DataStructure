package com.ds.java.arrays;

import java.util.Arrays;

public class _17_RotateMatrixBy90 {

	public static void main(String[] args) {
		
		//Input: matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
		//Output: matrix = [[7, 4, 1], [8, 5, 2], [9, 6, 3]]
		 int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		 int[][] rotateMatrix1 = rotateMatrix1(arr);
		 printArray(rotateMatrix1);
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

	private static int[][] rotateMatrix1(int[][] arr) {
		int n = arr.length;
		int[][] res = new int[n][n];
		for(int i = 0;i < n ; i++) {
			for (int j = 0; j < n; j++) {
				res[j][n-i-1] = arr[i][j];
			}
		}
		return res;
	}
	
	// Transpose the matrix --> Reverse the matrix
	
	private static void rotateMatrix2(int[][] matrix) {
		 int n = matrix.length;
	        
	        // Transpose the matrix
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < i; j++) {
	                
	                // Swap elements across the diagonal
	                int temp = matrix[i][j];
	                matrix[i][j] = matrix[j][i];
	                matrix[j][i] = temp;
	                
	            }
	        }
	        
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n / 2; j++) {
	                
	                // Swap elements symmetrically
	                int temp = matrix[i][j];
	                matrix[i][j] = matrix[i][n - 1 - j];
	                matrix[i][n - 1 - j] = temp;
	                
	            }
	        }
	}
}
