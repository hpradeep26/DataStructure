package com.ds.java.binarysearch;

public class _01_BinarySearch {

	public static void main(String[] args) {
		int[] nums = {-1,0,3,5,9,12};
		int target = 9;
		//System.out.println(search(nums, target));
		System.out.println(binarySearch(nums, 0, nums.length-1, target));
	}
	
	//using iterative
	public static int search(int[] nums, int target) {
		 int n = nums.length; // Size of array 
	        
	        // Pointers to define the search space
	        int low = 0, high = n - 1;

	        // Until the search space is not empty
	        while (low <= high) {
	            // Find the middle element
	            int mid = (low + high) / 2;

	            // If it matches the target
	            if (nums[mid] == target) 
	                return mid; 
	                
	            // If the target is greater than middle element 
	            else if (target > nums[mid]) 
	                low = mid + 1; 
	                
	            // Otherwise
	            else 
	                high = mid - 1; 
	        }

	        // If the target is not found
	        return -1; 
    }
	
	//using recursive
	public static int binarySearch(int[] nums, int low,int high,int target) {
		
		if(low<=high) {
			 int mid = (low + high) / 2;
			 
			 if (nums[mid] == target) 
	                return mid; 
			 
			 else if (target > nums[mid]) 
	                return binarySearch(nums, mid+1, high, target); 
	                
	            // Otherwise
	            else 
	            	return binarySearch(nums, low, mid-1, target); 
		}
		
		return -1;
	}


}
