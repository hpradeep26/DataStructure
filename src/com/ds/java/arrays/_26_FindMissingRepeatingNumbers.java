package com.ds.java.arrays;

import java.util.Arrays;

public class _26_FindMissingRepeatingNumbers {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 6, 7, 5, 7};
		//output - :[6, 9]
		//6 appears two times in the array and 9 is missing from nums.
		System.out.println(Arrays.toString(findMissingRepeatingNumbers(nums)));

	}
	
	public static int[] findMissingRepeatingNumbers(int[] nums) {
		int n = nums.length;
		int[] freq = new int[n+1];
		int repeatValue = 0;
		int missing = 0;
		int sum = 0;
		for(int i = 0 ; i < n; i++) {
			// track count for number
		 	freq[nums[i]]++;
		 	//adding sum 
		 	sum += nums[i];
		 	//find duplicate
		 	if(freq[nums[i]]==2) {
				repeatValue = nums[i];
			}
		}
		int total = (n * (n+1))/2;
		int diff = total - sum;
		missing = repeatValue + diff;
		/*for(int i = 0 ; i < freq.length; i++) {
			if(freq[i]==2) {
				repeatValue = i;
			}
			if(freq[i]==0) {
				miss = i;
			}
		} */
		
		return new int[] {repeatValue,missing};
    }
	
public static int[] findMissingRepeatingNumbersOptimal(int[] nums) {
        
        // Size of the array
        long n = nums.length;

        // Sum of first n natural numbers
        long SN = (n * (n + 1)) / 2;

        // Sum of squares of first n natural numbers
        long S2N = (n * (n + 1) * (2 * n + 1)) / 6;

        /* Calculate actual sum (S) and sum 
           of squares (S2) of array elements */
        long S = 0, S2 = 0;
        for (int i = 0; i < n; i++) {
            S += nums[i];
            S2 += (long) nums[i] * (long) nums[i];
        }

        // Compute the difference values
        long val1 = S - SN;

        // S2 - S2n = X^2 - Y^2
        long val2 = S2 - S2N;

        // Calculate X + Y using X + Y = (X^2 - Y^2) / (X - Y)
        val2 = val2 / val1;

        /* Calculate X and Y from X + Y and X - Y
           X = ((X + Y) + (X - Y)) / 2
           Y = X - (X - Y) */
        long x = (val1 + val2) / 2;
        long y = x - val1;

        // Return the results as [repeating, missing]
        return new int[]{(int) x, (int) y};
    }

}
