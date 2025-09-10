package com.ds.java.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _04_MergeSort {

	public static void main(String[] args) {
		int[] arr = {7, 4, 1, 5, 8};
		mergeSort(arr);
	 System.out.println(Arrays.toString(arr));
	}
	
	public static int[] mergeSort(int[] nums) {
        int n = nums.length; // Size of array
        
        // Perform Merge sort on the whole array
        mergeSortHelper(nums, 0, n - 1);
        
        // Return the sorted array
        return nums;
    }
	
	
	private static void mergeSortHelper(int[] arr, int low, int high) {
		System.out.println("low "+low +" high "+high);
		if (low >= high)
	            return;

	        // Find the middle index
	        int mid = (low + high) / 2;
	        System.out.println("low "+low +" mid "+mid+" high "+high);
	        // Recursively sort the left half
	        mergeSortHelper(arr, low, mid);
	        // Recursively sort the right half
	        mergeSortHelper(arr, mid + 1, high);
	        // Merge the sorted halves
	        merge(arr, low, mid, high);
	}


	private static void merge(int[] arr, int low, int mid, int high) {
		 List<Integer> temp = new ArrayList<>();
	        int left = low;
	        int right = mid + 1;
	        System.out.println("low "+low +" mid"+mid+" high"+high);
	        
	        // Loop until subarrays are exhausted
	        while (left <= mid && right <= high) {
	        	System.out.println("left "+left +" right"+right);
	            // Compare left and right elements
	            if (arr[left] <= arr[right]) {
	                // Add left element to temp
	                temp.add(arr[left]);
	                // Move left pointer
	                left++;
	            } else {
	                // Add right element to temp
	                temp.add(arr[right]);
	                // Move right pointer
	                right++;
	            }
	        }
	        	
	        System.out.println("left "+left +" right"+right);
	        // Adding the remaining elements of left half
	        while (left <= mid) {
	            temp.add(arr[left]);
	            left++;
	        }
	        	
	        // Adding the remaining elements of right half
	        while (right <= high) {
	            temp.add(arr[right]);
	            right++;
	        }
	        System.out.println(temp);
	        // Transferring the sorted elements to arr
	        for (int i = low; i <= high; i++) {
	            arr[i] = temp.get(i - low);
	        }
		
	}

}
