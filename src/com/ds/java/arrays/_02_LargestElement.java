package com.ds.java.arrays;

public class _02_LargestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int largestElement(int[] nums) {
	    int max = nums[0];
	    for(int i= 1;i<nums.length; i++) {
	    	max = Math.max(max, nums[i]);
	    }
	    return max;
    }

}
