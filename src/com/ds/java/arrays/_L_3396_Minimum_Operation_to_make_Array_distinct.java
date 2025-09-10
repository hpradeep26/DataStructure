package com.ds.java.arrays;

import java.util.HashSet;
import java.util.Set;
// https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/description/
public class _L_3396_Minimum_Operation_to_make_Array_distinct {
	//Remove 3 elements from the beginning of the array. If the array has fewer than 3 elements, remove all remaining elements.
	public static void main(String[] args) {
		//Input: nums = [1,2,3,4,2,3,3,5,7]
		//Output: 2
		//In the first operation, the first 3 elements are removed, resulting in the array [4, 2, 3, 3, 5, 7].
		//In the second operation, the next 3 elements are removed, resulting in the array [3, 5, 7], which has distinct elements.
		int[] nums = {1,2,3,4,2,3,3,5,7};
		minimumOperations(null);
	}
	
	
	public static int minimumOperations(int[] nums) {
        int n = nums.length;
        Set<Integer> seen = new HashSet<>();
        for (int i = n - 1; i >= 0; i--) {
            if (seen.contains(nums[i])) {
                return i / 3 + 1;
            }
            seen.add(nums[i]);
        }
        return 0;
    }

}
