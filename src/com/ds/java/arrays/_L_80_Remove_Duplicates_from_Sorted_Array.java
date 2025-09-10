package com.ds.java.arrays;

public class _L_80_Remove_Duplicates_from_Sorted_Array {

	public static void main(String[] args) {
		//Input: nums = [1,1,1,2,2,3]
		//Output: 5, nums = [1,1,2,2,3,_]
		int[] nums = {0,0,1,1,1,1,2,3,3};
		System.out.println(removeDuplicates(nums));
	}
	
	//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/solutions/5792415/video-using-two-pointers-coding-exercise-twyg/
	
	public static int removeDuplicates(int[] nums) {
		int k = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;        
    }
	
	

}
