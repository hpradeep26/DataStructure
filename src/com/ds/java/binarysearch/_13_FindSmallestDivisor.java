package com.ds.java.binarysearch;

public class _13_FindSmallestDivisor {

	public static void main(String[] args) {
		int[] nums = {8,4,2,3}; int limit = 4;
		System.out.println(smallestDivisorOptimal(nums, limit));

	}
	
	public static int smallestDivisorBruteForce(int[] nums, int limit) {
		 // Size of array
       int n = nums.length;

       // Find the maximum element in nums
       int maxi = Integer.MIN_VALUE;
       for (int i = 0; i < n; i++) {
           maxi = Math.max(maxi, nums[i]);
       }
	       
    // Find the smallest divisor
       for (int d = 1; d <= maxi; d++) {
           int sum = 0;

           /* Calculate the sum of ceil
           (nums.get(i) / d) for all elements */
           for (int i = 0; i < n; i++) {
               sum += Math.ceil((double) nums[i] / (double)(d));
           }

           // Check if the sum is <= limit
           if (sum <= limit)
               return d;
       }
       return -1;
   }
	
	
	public static int smallestDivisorOptimal(int[] nums, int limit) {

		int n = nums.length;
		if (n > limit) return -1;

		// Find the maximum element in nums
		int maxi = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			maxi = Math.max(maxi, nums[i]);
		}
		 int low = 1, high = maxi;

	        // Apply binary search
	        while (low <= high) {
	            int mid = (low + high) / 2;
	            if (sumByD(nums, mid) <= limit) {
	                high = mid - 1;
	            } else {
	                low = mid + 1;
	            }
	        }
	        return low;
	}
	
	 /* Helper unction to find the 
    summation of division values */
    private static int sumByD(int[] nums, int limit) {
        // Size of array
        int n = nums.length; 
        
        // Find the summation of division values
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.ceil((double)nums[i] / (double)limit);
        }
        return sum;
    }

}
