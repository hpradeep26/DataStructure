package com.ds.java.leetcode75.twopointer;

import java.util.Arrays;

public class _L_283_MoveZerosToEnd {

	public static void main(String[] args) {
		int[] nums = {1, 0, 4, 0, 5, 2};
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}

	public static void moveZeroes(int[] nums) {
		int index = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i]!=0) {
				int temp = nums[index];
				nums[index] = nums[i];
				nums[i] = temp;
				index++;
			}
		}
		
	}

}
