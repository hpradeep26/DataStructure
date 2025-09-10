package com.ds.java.arrays;

public class _01_LinearSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int linearSearch(int[] nums, int target) {
        // Traverse the entire array
        for (int i = 0; i < nums.length; i++) {

            // Check if current element is target
            if (nums[i] == target) {

                // Return if target found
                return i;

            }
        }
        // If target not found
        return -1;
    }

}
