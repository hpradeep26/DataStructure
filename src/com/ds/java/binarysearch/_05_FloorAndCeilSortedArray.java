package com.ds.java.binarysearch;

import java.util.Arrays;

public class _05_FloorAndCeilSortedArray {

	public static void main(String[] args) {
		int[] nums = {3, 4, 4, 7, 8, 10};
		int x = 12;
		System.out.println(Arrays.toString(getFloorAndCeil(nums, x)));

	}
	
	public static int[] getFloorAndCeil(int[] nums, int x) {
			int floor = getFloor(nums, x);
			
			int ceil = getCeil(nums, x);
			
			return new int[] {floor,ceil};
	}
	
	public static int getFloor(int[] nums, int x) {
		int low = 0;
		int high = nums.length - 1;
		int ans = -1;
		while(low<=high) {
	    	   int mid = (low + high)/2;
	    	   if(nums[mid]<=x) {
	    		   ans = nums[mid];
	    		   low = mid + 1;
	    	   }else {
	    		   high = mid - 1;
	    		   
	    	   }
	       }
		return ans;
	}
	
	public static int getCeil(int[] nums, int x) {
		int low = 0 ;
		int high = nums.length - 1;
		int ans = -1;
		while(low<=high) {
	    	   int mid = (low + high)/2;
	    	   if(nums[mid]>=x) {
	    		   ans = nums[mid];
	    		   high = mid - 1;
	    	   }else {
	    		   low = mid + 1;
	    		   
	    	   }
	       }
		return ans;
	}

}
