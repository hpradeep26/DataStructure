package com.ds.java.binarysearch;

public class _04_InsertSearchPosition {

	public static void main(String[] args) {
		   int[] nums = {1, 3, 5, 6};
	        int target = 5;
	       System.out.println(searchInsertOptimal(nums, target));

	}
	
	public static int searchInsert(int[] nums, int target) {
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            /* If current element is greater than 
                 or equal to the target */
            if (nums[i] >= target) {
                // Return the current index
                return i;
            }
        }
        /* If target is greater than all elements, 
             return the length of the array */
        return nums.length;
    }
	
	public static int searchInsertOptimal(int[] nums, int target) {
		int n = nums.length;
		int low = 0, high = n - 1;
		int ans = n;

		// Applying Binary Search Algorithm
		while (low <= high) {
			int mid = (low + high) / 2;

			/* If mid element is greater than 
	               or equal to target, update ans 
	               and search the left half */
			if (nums[mid] >= target) {
				ans = mid;
				high = mid - 1;
			} 
			// Otherwise, search the right half
			else {
				low = mid + 1;
			}
		}
		return ans;
	}


}
