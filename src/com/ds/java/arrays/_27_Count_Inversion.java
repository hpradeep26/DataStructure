package com.ds.java.arrays;

public class _27_Count_Inversion {

	public static void main(String[] args) {
		int[] nums = {9, 5, 4, 2, 8};
		System.out.println(numberOfInversionsOptimal(nums));

	}
	
	public static long numberOfInversions(int[] nums) {
		long count = 0;
		int n = nums.length;
		for(int i = 0 ; i< n; i++){
			for(int j = i + 1 ; j< n ; j++){
				if(nums[i]>nums[j]){
					count++;
				}
			}
		}
		return count;
	}
	
	 public static long numberOfInversionsOptimal(int[] nums) {
	        
	        // Size of the array
	        int n = nums.length;

	        // Count the number of pairs
	        return mergeSort(nums, 0, n - 1);
	    }
	 
	// Merge sort function to recursively sort and count inversions
	    private static long mergeSort(int[] arr, int low, int high) {
	        long cnt = 0;
	        if (low < high) {
	            int mid = low + (high - low) / 2;
	            
	            // Sort left half
	            cnt += mergeSort(arr, low, mid);
	            
	            // Sort right half
	            cnt += mergeSort(arr, mid + 1, high);
	            
	            // Merge and count inversions
	            cnt += merge(arr, low, mid, high);
	        }
	        return cnt;
	    }
	    
	    private static long merge(int[] arr, int low, int mid, int high) {
	        
	        // Temporary array for merging
	        int[] temp = new int[high - low + 1];
	        
	        // Starting indices of left and right halves
	        int left = low;
	        int right = mid + 1;
	        int index = 0;

	        // Count variable to count the pairs
	        long cnt = 0;

	        // Merge sorted halves into temp array
	        while (left <= mid && right <= high) {
	            if (arr[left] <= arr[right]) {
	                temp[index++] = arr[left++];
	            } else {
	                temp[index++] = arr[right++];
	                
	                // Count inversions
	                cnt += (mid - left + 1);
	            }
	        }

	        // Copy remaining elements of left half
	        while (left <= mid) {
	            temp[index++] = arr[left++];
	        }

	        // Copy remaining elements of right half
	        while (right <= high) {
	            temp[index++] = arr[right++];
	        }

	        /* Copy elements from temp 
	        array back to original array */
	        System.arraycopy(temp, 0, arr, low, high - low + 1);
	        
	        // Return the count of inversions
	        return cnt;
	    }
}
