package com.ds.java.array.multidimension;

public class _06_WaveForm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = null;
		wave(arr);
	}

	private static void wave(int[][] arr) {
		int row = arr.length;
		int col = arr[0].length;
		for (int i = 0; i < col; i++) {
			if(i%2==0) { // even start asecnding 
				for (int j = 0; j < row; j++) {
					System.out.println(arr[i][j]);
				}
			}else {
				for (int j = row-1; j >=0; j--) {// descending order
					System.out.println(arr[i][j]);
				}
			}
		}
	}
	

}
