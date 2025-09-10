package com.ds.java.sorting;

import java.util.Arrays;

public class _02_Bubble_Sort {
	
	public static void main(String[] args) {
		int[] nums = {28,6,4,2,24};
		bubbleSort(nums);
		System.out.println(Arrays.toString(nums));
	}
	//next element is small than j 
	 public static int[] bubbleSort(int[] nums) {
		 for(int i =0;i<nums.length;i++) {
			 for(int j = 0;j<nums.length-1;j++) {
				 if(nums[j]>nums[j+1]) {
					 int temp = nums[j];
						nums[j] = nums[j+1];
						nums[j+1] = temp;
				 }
				 System.out.println(Arrays.toString(nums));
			 }
		 }
		 return nums;

	  }
	 
	 public int[] bubbleSort1(int[] nums) {
	        int n = nums.length;
	        // Traverse through the array
	        for (int i = n - 1; i >= 0; i--) {
	            // Track if swaps are made
	            boolean isSwapped = false;
	            for (int j = 0; j <= i - 1; j++) {
	                // Swap if next element is smaller
	                if (nums[j] > nums[j + 1]) {
	                    int temp = nums[j];
	                    nums[j] = nums[j + 1];
	                    nums[j + 1] = temp;
	                    isSwapped = true;
	                }
	            }
	            /** Break out of loop 
	          if no swaps done*/
	            if (!isSwapped) {
	                break;
	            }
	        }
	        return nums;
	    }
}
