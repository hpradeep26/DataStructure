package com.ds.java.binarysearch;

public class _02_LowerBound {

	public static void main(String[] args) {
		int[] nums = {1,2,2,2,3};
		int target = 2;
		System.out.println(lowerBound(nums, target));
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
