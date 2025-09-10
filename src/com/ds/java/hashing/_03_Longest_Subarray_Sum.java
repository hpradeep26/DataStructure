package com.ds.java.hashing;

import java.util.HashMap;
import java.util.Map;


//https://takeuforward.org/plus/dsa/hashing/faqs/longest-subarray-with-sum-k
public class _03_Longest_Subarray_Sum {

	public static void main(String[] args) {
		int[] nums = {-38,534,204,-848,-223,-762,767,277,-717};
		System.out.println(longestSubarrayOpt(nums, -1066));
		
	}
	
	 public static int longestSubarray(int[] arr, int k) {
		 int maxCount = 0;
		 for (int i = 0; i < arr.length; i++) {
			 int sum = 0;
			for (int j = i; j < arr.length; j++) {
				sum += arr[j];
				if(sum==k) {
					maxCount =  Math.max(maxCount, j-i+1);
				}
			}
		}
		 return maxCount;
	 }
	 
	 public static int longestSubarrayOpt(int[] nums, int k) {
		   int n = nums.length;

	        Map<Integer, Integer> preSumMap = new HashMap<>();
	        int sum = 0;
	        int maxLen = 0;
	        for (int i = 0; i < n; i++) {
	            // calculate the prefix sum till index i
	            sum += nums[i];

	            // if the sum equals k, update maxLen
	            if (sum == k) {
	                maxLen = Math.max(maxLen, i + 1);
	            }

	            // calculate the sum of remaining part i.e., sum - k
	            int rem = sum - k;

	            // calculate the length and update maxLen
	            if (preSumMap.containsKey(rem)) {
	                int len = i - preSumMap.get(rem);
	                maxLen = Math.max(maxLen, len);
	            }

	            // update the map if sum is not already present
	            if (!preSumMap.containsKey(sum)) {
	                preSumMap.put(sum, i);
	            }
	        }

	        return maxLen;
	    }

}
