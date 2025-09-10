package com.ds.java.slidingwindow;

public class _L_1493_Longest_Subarray1s_after_one_element_delete {

	public static void main(String[] args) {
		int[] nums = {1,1,1};
		//output - 2
		System.out.println(longestSubarray(nums));

	}
	
	public static int longestSubarray(int[] nums) {
        int length = nums.length;
        int maxLength = 0;
        int left = 0;
        int right =0;
        int zeros = 0;
        while(right < length) {
        	if(nums[right]==0) {
        		zeros++;
        	}
        	while(zeros>1) {
        		if(nums[left]==0) {
        			zeros--;
        		}
        		left++;
        	}
        	
        	int size = right - left;
        	maxLength = Math.max(maxLength, size);
        	right++;
        }
        
        return maxLength;
    }

}
