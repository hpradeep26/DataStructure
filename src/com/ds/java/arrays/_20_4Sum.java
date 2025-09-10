package com.ds.java.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _20_4Sum {

	public static void main(String[] args) {
		int[] nums = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
        int target = 9;
        System.out.println(fourSumOptimal(nums,target));

	}
	
	 public static List<List<Integer>> fourSum(int[] nums, int target) {
		 int n = nums.length;
	        
	        // Set to store unique quadruplets
	        Set<List<Integer>> set = new HashSet<>();
	        
	        // Checking all possible quadruplets
	        for (int i = 0; i < n-3; i++) {
	            for (int j = i + 1; j < n-2; j++) {
	                for (int k = j + 1; k < n-1; k++) {
	                    for (int l = k + 1; l < n; l++) {
	                        // Calculate the sum of the current quadruplet
	                        long sum = nums[i] + nums[j] + nums[k] + nums[l];
	                        
	                        // Check if the sum matches the target
	                        if (sum == target) {
	                            List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
	                            // Sort the quadruplet to ensure uniqueness
	                            Collections.sort(temp);
	                            set.add(temp);
	                        }
	                    }
	                }
	            }
	        }
	        
	        // Convert set to list (unique quadruplets)
	        return new ArrayList<>(set);
	    }
	 
	 public static List<List<Integer>> fourSumBetter(int[] nums, int target) {
	        int n = nums.length;
	        // Set to store unique quadruplets
	        Set<List<Integer>> set = new HashSet<>();
	        
	        for (int i = 0; i < n-3; i++) {
	            for (int j = i + 1; j < n-2; j++) {
	            	 // Set to store elements seen so far in the loop
	                Set<Long> hashset = new HashSet<>();
	                for (int k = j + 1; k < n; k++) {
	                	long sum = (long) nums[i] + nums[j] + nums[k];
	                    long fourth = target - sum;
	                    if (hashset.contains(fourth)) {
	                        // Found a quadruplet that sums up to target
	                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], (int) fourth);
	                        Collections.sort(temp);
	                        set.add(temp);
	                    }
	                    hashset.add((long)nums[k]);
	                }
	            }
	        } 
	        
	    return new ArrayList<>(set);
	 }
	 
	 public static List<List<Integer>> fourSumOptimal(int[] nums, int target) {
		 List<List<Integer>> ans = new ArrayList<>();
	        int n = nums.length;
	        
	        // Sort the input array nums
	        Arrays.sort(nums);
	        
	        // Iterate through the array to find quadruplets
	        for (int i = 0; i < n; i++) {
	            // Skip duplicates for i
	            if (i > 0 && nums[i] == nums[i - 1])
	                continue;
	            
	            for (int j = i + 1; j < n; j++) {
	                // Skip duplicates for j
	                if (j > i + 1 && nums[j] == nums[j - 1])
	                    continue;
	                
	                // Two pointers approach
	                int k = j + 1;
	                int l = n - 1;
	                
	                while (k < l) {
	                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
	                    
	                    if (sum == target) {
	                        // Found a quadruplet that sums up to target
	                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
	                        ans.add(temp);
	                        
	                        // Skip duplicates for k and l
	                        k++;
	                        l--;
	                        while (k < l && nums[k] == nums[k - 1]) k++;
	                        while (k < l && nums[l] == nums[l + 1]) l--;
	                    } else if (sum < target) {
	                        k++;
	                    } else {
	                        l--;
	                    }
	                }
	            }
	        }
	        
	        return ans;
	 }

}
