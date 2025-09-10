package com.ds.java.arrays;

public class _29_MaximumProductSubarray {

	public static void main(String[] args) {
		int[] arr = {1, -2, 3, 4, -4, -3};
		System.out.println(maxProductOptimal(arr));
	}
	
	public static int maxProduct(int[] nums) {
		int maxProd = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
        	long max = nums[i];
        	for(int j = i + 1;j<nums.length;j++) {
        		maxProd = (int) Math.max(maxProd, max);
        		max = max * nums[j];
        	}
        	maxProd = (int) Math.max(maxProd, max);
        }
		return maxProd;
    }
	
	public static int maxProductOptimal(int[] nums) {
        int n = nums.length;
        
        int ans = Integer.MIN_VALUE; // to store the answer
        
        // Indices to store the prefix and suffix multiplication
        int prefix = 1, suffix = 1;
        
        // Iterate on the elements of the given array
        for (int i = 0; i < n; i++) {
            
            /* Resetting the prefix and suffix
            multiplication if they turn out to be zero */
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;
            
            // update the prefix and suffix multiplication
            prefix *= nums[i];
            suffix *= nums[n - i - 1];
            
            // store the maximum as the answer
            ans = Math.max(ans, Math.max(prefix, suffix));
        }
        
        // return the result
        return ans;
    }

}
