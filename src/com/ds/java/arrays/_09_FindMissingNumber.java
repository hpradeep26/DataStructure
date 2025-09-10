package com.ds.java.arrays;

public class _09_FindMissingNumber {

	public static void main(String[] args) {
		int[] nums = {0, 1, 2, 4, 5, 6};
		System.out.println(missingNumberOptimal(nums));

	}
	
	public static int missingNumber(int[] nums) {
        int num = 0;
        for (int i = 0; i <= nums.length; i++) {
        	boolean exist = false;
			for (int j = 0; j < nums.length; j++) {
				if(nums[j]==i) {
					exist = true;
					break;
				}
			}
			if(!exist) {
				return i;
			}
		}
        
        return num;
    }
	
	public static int missingNumberBetter(int[] nums) {
		int len = nums.length;
        int[] freq = new int[len+1];
        
        for (int num : nums) {
			freq[num]++;
		}
        
        for (int i = 0; i <= len; i++) {
			if(freq[i]==0) {
				return i;
			}
		}
        
        return -1;
    }
	
	public static int missingNumberOptimal(int[] nums) {
		 int N = nums.length;
	        
	        // Summation of first N natural numbers
	        int sum1 = (N * (N + 1)) / 2;
	        
	        // Summation of all elements in nums
	        int sum2 = 0;
	        for (int num : nums) {
	            sum2 += num;
	        }
	        
	        // Calculate the missing number
	        int missingNum = sum1 - sum2;
	        
	        // Return the missing number
	        return missingNum;
    }
	
	public static int missingNumberOptimal2(int[] nums) {
		int xor1 = 0, xor2 = 0;

        // Calculate XOR of all array elements
        for (int i = 0; i < nums.length; i++) {
            xor1 = xor1 ^ (i + 1); // XOR up to [1...N]
            xor2 = xor2 ^ nums[i]; // XOR of array elements
        }

        // XOR of xor1 and xor2 gives missing number
        return (xor1 ^ xor2);
   }

}
