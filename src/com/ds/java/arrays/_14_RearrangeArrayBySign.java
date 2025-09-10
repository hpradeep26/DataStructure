package com.ds.java.arrays;

import java.util.Arrays;

public class _14_RearrangeArrayBySign {

	public static void main(String[] args) {
		int[] nums = {-4, 4, -4, 4, -4, 4};
		int[] rearrangeArray = rearrangeOptimal(nums);
		System.out.println(Arrays.toString(rearrangeArray));

	}
	
	public static int[] rearrangeArray(int[] nums) {
		int length = nums.length;
		int[] positive = new int[length/2];
		int[] negative = new int[length/2];
		int p =0,n=0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]<0) {
				negative[n++] = nums[i];
			}else {
				positive[p++] = nums[i];
			}
		}
		int i = 0;
		int index = 0;
		while(i<length) {
			nums[i++] = positive[index];
			nums[i++] = negative[index];
			index++;
		}

		return nums;
	}
	
	
	public static int[] rearrangeOptimal(int[] nums) {
		int length = nums.length;
		int[] ans = new int[length];
		
		int posIndex =0 , negIndex = 1;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]<0) {
				ans[negIndex] = nums[i];
				negIndex = negIndex + 2;
			}else {
				ans[posIndex] = nums[i];
				posIndex = posIndex + 2;
			}
		}
		return nums;
	}

}
