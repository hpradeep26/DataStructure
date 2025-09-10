package com.ds.java.binarysearch;

public class _03_UpperBound {

	public static void main(String[] args) {
		int[] nums = {1,2,2,2,3};
		int target = 2;
		System.out.println(upperBound(nums, target));

	}
	
	 public static int upperBound(int[] nums, int x) {
		 int ans = -1;
		 int left = 0;
		 int right = nums.length - 1;
		 while(left<=right) {
			 int mid = (left + right) / 2;
			 if (nums[mid] > x) {
	                ans = mid;
	                right = mid - 1;
	            } 
	            // Otherwise, move to the right half
	            else {
	                left = mid + 1;
	            }
		 }
		 return ans;
	 }

}
