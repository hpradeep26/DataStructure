package com.ds.java.arrays;

public class _L_334_Increasing_triplet_subsequence {

	public static void main(String[] args) {
		int[] nums = {20,100,10,12,3,15};
		System.out.println(increasingTriplet(nums));

	}
	
	public static boolean increasingTriplet(int[] nums) {
		if (nums == null || nums.length < 3) {
			return false;
		}
		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		for (int num : nums) {
			if (num <= min1) {
				min1 = num;
			} else if (num <= min2) {
				min2 = num;
			} else {
				return true;
			}
		}
		return false;	
	}

}
