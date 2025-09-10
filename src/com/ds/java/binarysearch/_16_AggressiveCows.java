package com.ds.java.binarysearch;

import java.util.Arrays;

public class _16_AggressiveCows {

	public static void main(String[] args) {
		int[] nums = {4, 2, 1, 3, 6};
		int k = 2;
		System.out.println(aggressiveCowsBinarySearch(nums, k));
	}
	  /* Function to find the maximum possible minimum
    distance 'k' cows can have between them in nums */
	public static int aggressiveCowsLinearSearch(int[] nums, int k) {
		  // Size of array
        int n = nums.length;
        // Sort the nums
        Arrays.sort(nums);
        int limit = nums[n - 1] - nums[0];
        for (int i = 1; i <= limit; i++) {
            if (!canWePlace(nums, i, k)) {
                return (i - 1);
            }
        }
        // Return the answer
        return limit;
	}
	
	public static int aggressiveCowsBinarySearch(int[] nums, int k) {
		  // Size of array
      int n = nums.length;
      // Sort the nums
      Arrays.sort(nums);
      int low = nums[0];
      int high = nums[n-1];
       
      while(low<=high) {
    	  int mid = low + (high-low)/2;
    	  if(!canWePlace(nums, mid, k)) {
    		  high = mid - 1;
    	  }else {
    		  low = mid + 1;
    	  }
    	 
      }
      
      // Return the answer
      return high;
	}
	
	 /* Function to check if we can place 'cows' cows
    with at least 'dist' distance apart */
	private static boolean canWePlace(int[] nums, int dist, int k) {
		 // Number of cows placed
		int noOfCows = 1;
		// Position of last placed cow
		int last = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if(nums[i]-last>=dist) {
				 // Place next cow
				noOfCows++;
				// Update the last location
				last = nums[i];
			}
			if(noOfCows>=k) {
				return true;
			}
		}
		return false;
	}

}
