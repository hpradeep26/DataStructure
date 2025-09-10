package com.ds.java.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _02_LongestSequanceInArray {

	public static void main(String[] args) {
		int[] nums = {17,12,-8,-11,14,-19,9,-4,-11,-12,-8,5,15,14,9,-19,12,5,0,18,13,-1,3,19,16,-13,-11,9};
		System.out.println(longestConsecutive(nums));
	}
	
	public static int longestConsecutive(int[] nums) {
		int count = 1;
		int max = 1;
		Arrays.sort(nums);
		for(int i = 0;i< nums.length - 1;i++) {
			if(nums[i]+1==nums[i+1]) {
				count++;
			}else if(nums[i]==nums[i+1]) {
				continue;
			} else {
				count = 1;
			}
			max = Math.max(max, count);
		}
		return max;   
	}
	
	 public int longestConsecutiveOptimal(int[] nums) {
	        int n = nums.length;
	        // If the array is empty
	        if (n == 0) return 0;

	        // Initialize the longest sequence length
	        int longest = 1; 
	        Set<Integer> st = new HashSet<>();

	        // Put all the array elements into the set
	        for (int i = 0; i < n; i++) {
	            st.add(nums[i]);
	        }

	        /* Traverse the set to 
	           find the longest sequence */
	        for (int it : st) {
	            // Check if 'it' is a starting number of a sequence
	            if (!st.contains(it - 1)) {
	                // Initialize the count of the current sequence
	                int cnt = 1; 
	                // Starting element of the sequence
	                int x = it; 

	                // Find consecutive numbers in the set
	                while (st.contains(x + 1)) {
	                    // Move to the next element in the sequence
	                    x = x + 1; 
	                    // Increment the count of the sequence
	                    cnt = cnt + 1; 
	                }
	                // Update the longest sequence length
	                longest = Math.max(longest, cnt);
	            }
	        }
	        return longest;
	    }

}
