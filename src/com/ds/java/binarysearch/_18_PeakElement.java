package com.ds.java.binarysearch;

public class _18_PeakElement {
	//https://leetcode.com/problems/find-peak-element/description/

	public static void main(String[] args) {
		int[] nums = {2,1,3};
		System.out.println(findPeakElementBinarySearch(nums));

	}
	
	public static int findPeakElementLinearSearch(int[] arr) {
		 // Size of array
        int n = arr.length;
        
        /* Iterate through the array
           to find the peak element */
        for (int i = 0; i < n; i++) {
            
            // Check if arr[i] is a peak
            if ((i == 0 || arr[i - 1] < arr[i]) && (i == n - 1 || arr[i] > arr[i + 1])) {
                
                // Return the index of peak element
                return i;
            }
        }
        /* Return -1 if no peak element
           found (dummy return) */
        return -1;
    }
	
	public static int findPeakElementBinarySearch(int[] arr) {
		 int n = arr.length;
	        
	        // Edge cases:
	        if (n == 1) return 0;
	        if (arr[0] > arr[1]) return 0;
	        if (arr[n - 1] > arr[n - 2]) return n - 1;

	        int low = 1, high = n - 2;
	        while (low <= high) {
	            int mid = (low + high) / 2;

	            //If arr[mid] is the peak
	            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1])
	                return mid;

	            // If we are in the left
	            if (arr[mid] > arr[mid - 1]) low = mid + 1;

	            /* If we are in the right
	            Or, arr[mid] is a common point*/
	            else high = mid - 1;
	        }
	        /* Return -1 if no peak element
	        found (dummy return) */
	        return -1;
}

}
