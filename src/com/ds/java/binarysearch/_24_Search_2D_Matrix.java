package com.ds.java.binarysearch;

public class _24_Search_2D_Matrix {

	public static void main(String[] args) {
		 int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
	        int target = 8;
	        System.out.println(searchMatrixOptimal(matrix, target));

	}
	
	public static boolean searchMatrixOptimal(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0, high = n * m - 1;
        
        // Perform binary search
        while (low <= high) {
            int mid = (low + high) / 2;
            
            // Calculate the row and column
            int row = mid / m;
            int col = mid % m;
            
            // If target is found return true
            if (mat[row][col] == target) return true;
            else if (mat[row][col] < target) low = mid + 1;
            else high = mid - 1;
        }
        
        // Return false if target is not found
        return false; 
    }
	
	public boolean searchMatrix(int[][] mat, int target) {
        for(int i = 0;i<mat.length;i++){
            for(int j=0 ; j<mat[i].length;j++){
                if(mat[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }
	
	public static boolean searchMatrixBS(int[][] mat, int target) {
		  int n = mat.length;
	       int m = mat[0].length;
		for(int i = 0;i<mat.length;i++){
			if (mat[i][0] <= target && target <= mat[i][m - 1]) {
				return binarySearch(mat[i],target);
			}
		}
		return false;
	}

	private static boolean binarySearch(int[] arr, int target) {
		int low = 0;int high = arr.length-1;
		while(low <= high) {
			int mid = (low + high)/2;
			if(arr[mid]==target) {
				return true;
			}
			if(arr[mid]>target) {
				high = mid - 1;
			}else {
				low = mid + 1;
			}
		}
		return false;
	}

}
