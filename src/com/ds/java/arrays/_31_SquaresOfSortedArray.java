package com.ds.java.arrays;

public class _31_SquaresOfSortedArray {
	
	//https://leetcode.com/problems/squares-of-a-sorted-array/description/
	public static void main(String[] args) {
		int[] nums = {-4,-1,0,3,10};
		sortedSquaresOptimal(nums);
		//Input: nums = [-4,-1,0,3,10]
		//Output: [0,1,9,16,100]

	}
	
	
	public static int[] sortedSquaresOptimal(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                res[i] = nums[left] * nums[left];
                left++;
            } else {
                res[i] = nums[right] * nums[right];
                right--;
            }
        }
        return res;        
    }

}
