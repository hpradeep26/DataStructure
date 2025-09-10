package com.ds.java.binarysearch;

public class _25_Search_Matrix_II {

	public static void main(String[] args) {
		int[][] matrix = {
	            {1, 4, 7, 11, 15},
	            {2, 5, 8, 12, 19},
	            {3, 6, 9, 16, 22},
	            {10, 13, 14, 17, 24},
	            {18, 21, 23, 26, 30}
	        };
	        int target = 24;
	        searchMatrix(matrix, target);

	}
	
	public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        // Initialize the row and col
        int row = 0, col = m - 1;

        // Traverse the matrix from (0, m-1):
        while (row < n && col >= 0) {
            
            // Return true if target is found
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] < target) row++;
            else col--;
        }
        // Return false if target not found
        return false;
    }

}
