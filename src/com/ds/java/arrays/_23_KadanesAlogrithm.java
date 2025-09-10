package com.ds.java.arrays;

public class _23_KadanesAlogrithm {

	public static void main(String[] args) {
		int[] nums = {-1, 2, 3, -1, 2, -6, 5};
		System.out.println(maxSubArrayOptimal(nums));

	}
	
	public static int maxSubArray(int[] nums) {
        int max = nums[0];
        for(int i = 0;i< nums.length; i++) {
        	 long sum = 0;
        	for(int j = i; j <nums.length;j++) {
        		sum = sum + nums[j];
        		max = (int) Math.max(max, sum);
        	}
        }
        return max;
    }
	
	public static int maxSubArrayOptimal(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0;i< nums.length; i++) {
        	sum += nums[i];
        	
        	if(sum>max) {
        		max = sum;
        	}
        	
        	if(sum < 0) {
        		sum = 0;
        	}
        }
        return max;
    }
}
