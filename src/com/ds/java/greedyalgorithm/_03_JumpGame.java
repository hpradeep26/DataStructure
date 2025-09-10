package com.ds.java.greedyalgorithm;

public class _03_JumpGame {

	public static void main(String[] args) {
		int[] nums = {3, 2, 1, 0, 4}; // output - false
		canJump(nums);

	}
	
	public static boolean canJump(int[] nums) {
        int maxIndex = 0;
        for(int i =0;i<nums.length;i++) {
        	if(i>maxIndex) {
        		return false;
        	}
        	maxIndex = Math.max(maxIndex, i+nums[i]);
        }
        return true;
    }

}
