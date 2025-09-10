package com.ds.java.array.multidimension;

public class _07_TransposeMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		transposeMatrix(matrix);
		printArray(matrix);
	}
	
	private static void printArray(int[][] sum) {
		int row = sum.length;
		int col = sum[0].length;
		for(int i = 0;i < row; i++) {
			for(int j = 0;j < col; j++) {
				System.out.print(sum[i][j] +" ");
			}
			System.out.println();
		}
		
	}
    //00,01,02 -- 00 10 20
	//10,11,12 -- 01 11 21
	//20,21,22 -- 02 12 22
	public static int[][] transposeMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] res = new int[col][row];
        for(int i =0; i<row; i++){
            for(int j = 0; j < col ;j++){
               res[j][i] = matrix[i][j];
            }
        }
        return res;
    }

}
