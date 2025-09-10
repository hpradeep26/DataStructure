package com.ds.java.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _18_TwoSum {

	public static void main(String[] args) {
		int[] nums = {-6, 7, 1, -7, 6, 2}; int target = 0;
		int[] twoSum = twoSumOptimal(nums, target);
		System.out.println(Arrays.toString(twoSum));
	}
	
	public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for(int i =0;i<nums.length;i++) {
        	for(int j = i+1;j< nums.length;j++) {
        		if(target == nums[i]+nums[j]) {
        			return new int[] {i,j};
        		}
        	}
        }
        return res;
    }
	
	public static int[] twoSumOptimal(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++) {
        	int rem = target - nums[i];
        	if(map.containsKey(rem)) {
        		return new int[] {map.get(rem),i};
        	}
        	map.put(nums[i], i);
        }
        return null;
    }

}
