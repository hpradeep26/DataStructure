package com.ds.java.binarysearch;

public class _23_Find_Row_With_Max1s {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int rowWithMax1s(int[][] mat) {
        int index = -1;
        int maxCount = 0;
        for(int i = 0;i<mat.length;i++){
            int count_ones = 0;
            for(int j=0 ; j<mat[i].length;j++){
                if(mat[i][j]==1){
                    count_ones++;
                }
               
            }
            if(count_ones>maxCount){
                maxCount = count_ones;
                index = i;
            }
            
        }
        return index;
    }
	
	public int rowWithMax1sOptimal(int[][] mat) {
        int index = -1;
        int maxCount = 0;
        int n = mat.length;
        int m = mat[0].length;
        for(int i = 0;i<mat.length;i++){
        	int count_ones = m - lowerBound(mat[i], 1);
        	if(count_ones>maxCount){
                maxCount = count_ones;
                index = i;
            }
        }
        return index;
    }
	
	public static int lowerBound(int[] nums, int x) {
	    int index = 0;
	    
	    int low = 0;
	    int high = nums.length - 1;
	    while(low <= high) {
	    	int mid = (low + high)/2;
	    	
	    	 if (nums[mid] >= x) {
	    		index = mid;
	    		high = mid - 1;
	    	}else {
	    		low = mid + 1;
	    	}
	    }
	   return index;  
    }

}
