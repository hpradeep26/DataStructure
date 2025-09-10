package com.ds.java.arrays;

import java.util.Arrays;

public class _06_LeftRotateArrayByKPlaces {

	public static void main(String[] args) {
		int[] nums = {3, 4, 1, 5, 3, -5};
		rotateArrayOptimal(nums,8);
		System.out.println(Arrays.toString(nums));

	}
	
	public static void rotateArray(int[] nums,int k) {
		int times = k;
		if(k > nums.length ) {
			times = k % nums.length;
		}
		// rotate logic k times
		for(int j =0 ; j<times;j++) {
			int left = nums[0];
			for(int i = 0; i< nums.length - 1; i++) {
				nums[i] = nums[i+1];
			}
			nums[nums.length-1] = left;
		}
	}
	
	public static void rotateArrayOptimal(int[] nums,int k) {
		int times = k;
		if(nums.length < k ) {
			 times = k % nums.length;
		}
		reverse(0, times-1, nums);
		//System.out.println(Arrays.toString(nums));
		reverse(times, nums.length-1, nums);
		//System.out.println(Arrays.toString(nums));
		reverse(0, nums.length-1, nums);
		//System.out.println(Arrays.toString(nums));
    }
	
	private static void reverse(int left,int right,int[] nums) {
		while(left<=right) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}
		
	}

}
