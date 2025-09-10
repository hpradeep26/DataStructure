package com.ds.java.arrays;

import java.util.Arrays;
import java.util.Iterator;

public class _03_SecondLargestElement {

	public static void main(String[] args) {
		int[] nums = {7, 7, 2, 2, 10, 10, 10};
		System.out.println(secondLargestElement(nums));
		

	}

	 public static int secondLargestElement(int[] nums) {
		 int max = nums[0];
		 int secondlargest = -1;
		 
		 for(int i = 1;i<nums.length; i++) {
			 if(nums[i]>max) {
				 secondlargest = max;
				 max = nums[i];
			 }
			 if(nums[i]>secondlargest && nums[i] != max) {
				 secondlargest = nums[i];
			 }
		 }
		 
		 return secondlargest;
	 }
	 
	 public int secondLargestElementBrute(int[] nums) {
	        int n = nums.length;
	        
	        // Check if the array has less than 2 elements
	        if (n < 2) {
	            // Indicating no second largest element is possible
	            return -1; 
	        }
	        
	        // Sort the array in ascending order
	        Arrays.sort(nums);

	        // Largest element will be at last index
	        int largest = nums[n - 1];

	        int secondLargest = -1;

	        // Traverse the sorted array from right to left
	        for (int i = n - 2; i >= 0; i--) {

	            /* If the current element is not
	            equal to the largest element*/
	            if (nums[i] != largest) {

	                /* Assign the current element 
	                as the second largest and break*/
	                secondLargest = nums[i];
	                break;
	            }
	        }

	        // Return the second largest element
	        return secondLargest;
	    }
}
