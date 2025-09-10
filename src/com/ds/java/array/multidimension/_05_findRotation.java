package com.ds.java.array.multidimension;

public class _05_findRotation {

	public static void main(String[] args) {
		int[][] mat = {{0,1},{1,1}};
		int[][] target = {{1,0},{0,1}};
		System.out.println(findRotation(mat, target));

	}

	public static boolean findRotation(int[][] mat, int[][] target) {
		for(int i = 0; i<4 ; i++) {
			rotateMatrix(mat);
			boolean flag = false;
			for (int j = 0; j < mat.length; j++) {
				for (int k = 0; k < mat[0].length; k++) {
					if(mat[j][k]!=target[j][k]) {
						flag = true;
						break;
					}
				}
			}
			if(!flag) {
				return true;
			}
		}

		return false;
	}

	private static void rotateMatrix(int[][] matrix) {
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
		//reverse a matrix
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
