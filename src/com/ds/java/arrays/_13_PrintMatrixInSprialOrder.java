package com.ds.java.arrays;

import java.util.ArrayList;
import java.util.List;

public class _13_PrintMatrixInSprialOrder {

	public static void main(String[] args) {
		int[][] mat = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}
		};
		List<Integer> spiralOrder = spiralOrder(mat);
		System.out.println(spiralOrder);
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		//No of rows	
		int rows = matrix.length;

		// Number of columns
		int col = matrix[0].length;
		// Initialize pointers for traversal
		int left = 0,top =0;
		int right = col-1,bottom = rows-1;
		  // Traverse the matrix in spiral order
		while (top <= bottom && left <= right) {
			// Traverse from left to right
			for(int i = left;i<=right;i++) {
				list.add(matrix[top][i]);
			}
			top++;
			// Traverse from top to bottom
			for(int i = top;i<=bottom;i++) {
				list.add(matrix[i][right]);
			}
			right--;
			// Traverse from right to left
			if(top<=bottom) {// special case if only one row present 
				for(int i = right;i>=left;i--) {
					list.add(matrix[bottom][i]);
				}
				bottom--;
			}
			 // Traverse from bottom to top
			if(left<=right) {// special case only one column present
				for(int i = bottom;i>=top;i--) {
					list.add(matrix[i][left]);
				}
				left++;
			}
		}
		return list;
	}

}
