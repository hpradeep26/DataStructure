package com.ds.java.array.multidimension;

import java.util.Arrays;

//https://leetcode.com/problems/find-missing-and-repeated-values/description/
public class _08_FindMissingAndRepeatedValues {
	
	public static void main(String[] args) {
		int[][] matrix = {{9,1,7},{8,9,2},{3,4,6}};
		System.out.println(Arrays.toString(findMissingAndRepeatedValues(matrix)));

	}
	
	public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int length = n*n;
        int freq[] = new int[length+1];
        int duplicate = 0;
        int missing = 0;
        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[i].length;j++){
                freq[grid[i][j]]++;
            }
        }
       for(int i =1;i<freq.length;i++) {
    	   if(freq[i]==2) {
    		   duplicate = i;
    	   }
    	   if(freq[i]==0) {
    		   missing = i;
    	   }
       }
        return new int[] {duplicate,missing};
    }
}
