package com.ds.java.binarysearch;

public class _08_SearchInRotatedSortedArray_II {

	public static void main(String[] args) {
		int[] nums = {39,45,48,52,74,-82,-81,-77,-74,-70,-46,-37,-29,-28,-15,15,19,27,33};
		System.out.println(search(nums, 5));

	}
	
	
	public static int search(int[] nums, int target) {
		int low = 0, high = nums.length - 1;

        // Applying binary search algorithm 
        while (low <= high) {
            int mid = (low + high) / 2;
            	
            // Check if mid points to the target
            if (nums[mid] == target) return mid;
            
            // Handle duplicates: if arr[low], arr[mid], and arr[high] are equal
            if (nums[low]==nums[mid] && nums[mid]==nums[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }

            // Check if the left part is sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    // Target exists in the left sorted part
                    high = mid - 1;
                } else {
                    // Target does not exist in the left sorted part
                    low = mid + 1;
                }
            } else {
                // Check if the right part is sorted
                if (nums[mid] <= target && target <= nums[high]) {
                    // Target exists in the right sorted part
                    low = mid + 1;
                } else {
                    // Target does not exist in the right sorted part
                    high = mid - 1;
                }
            }
        }
        // If target is not found
        return -1;
    }

}
