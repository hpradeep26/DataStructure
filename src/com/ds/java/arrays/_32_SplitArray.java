package com.ds.java.arrays;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/split-the-array/
public class _32_SplitArray {

	public static void main(String[] args) {
		int[] nums = {1,1,2,2,3,4};
		isPossibleToSplit(nums);

	}

	public static boolean isPossibleToSplit(int[] nums) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int i =0;i<nums.length;i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
			
			Integer value = map.get(nums[i]);
			
			if(value>2) return false;
		}

		return true;

	}
	
	 public boolean isPossibleToSplit1(int[] nums) {
	        int[] numbers = new int[101];

	        for (int i: nums) { 
	            if (numbers[i]++ >= 2) 
	                return false; 
	        }

	        return true;
	    }
	

}
