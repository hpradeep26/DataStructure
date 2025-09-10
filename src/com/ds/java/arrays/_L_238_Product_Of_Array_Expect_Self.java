package com.ds.java.arrays;

import java.util.Arrays;

public class _L_238_Product_Of_Array_Expect_Self {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		 System.out.println(Arrays.toString(productExceptSelf3(nums)));

	}
	
	//brute force
	public static int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        
        for (int i = 0; i < ans.length; i++) {
			int product = 1;
        	for (int j = 0; j < ans.length; j++) {
				if(i!=j) {
					product *= nums[j];
				}
			}
        	ans[i] = product;
		}
        
        return ans;
    }
	
	
	public static int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] ans = new int[n];
        
        prefix[0] = 1;
        suffix[n - 1] = 1;

        // Fill prefix array
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        // Fill suffix array
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        // Calculate the result
        for (int i = 0; i < n; i++) {
            ans[i] = prefix[i] * suffix[i];
        }
        return ans;
    }
	
	
	public static int[] productExceptSelf3(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        
        ans[0] = 1;

     // Calculate prefix products
        for (int i = 1; i < n; i++) {
        	 ans[i] = ans[i - 1] * nums[i - 1];
        }

     // Calculate suffix products and update ans array
        int prevSuffix = 1;
        for (int i = n - 2; i >= 0; i--) {
        	prevSuffix *= nums[i+1];
        	ans[i] *= prevSuffix; 
        }

        // Calculate the result
        return ans;
    }
	

	//better approach issue when 0 comes error Divide by Zero Exception
	public static int[] productExceptSelf1(int[] nums) {
        int[] ans = new int[nums.length];
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
        	product *= nums[i];
		}
        
        for(int i = 0; i < nums.length; i++) {
            ans[i] = product / nums[i];
        }
        
        return ans;
    }
	
	
	

}
