package com.ds.java.arrays;

import java.util.Arrays;

public class _05_LeftRotateArrayByOne {

	public static void main(String[] args) {
		int[] nums = {-1, 0, 3, 6};
		rotateArrayByOne(nums);
		System.out.println(Arrays.toString(nums));

	}
	
	public static void rotateArrayByOne(int[] nums) {
        int left = nums[0];
        for(int i = 0; i< nums.length - 1; i++) {
        	nums[i] = nums[i+1];
        }
        nums[nums.length-1] = left;
    }

}
