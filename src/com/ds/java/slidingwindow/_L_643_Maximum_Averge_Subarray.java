package com.ds.java.slidingwindow;

public class _L_643_Maximum_Averge_Subarray {

	public static void main(String[] args) {
		//nums = [1,12,-5,-6,50,3], k = 4
		//Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

	}
	
	public double findMaxAverage(int[] nums, int k) {
        double sum = 0;

        // Compute initial window sum
       for (int i = 0; i < k; i++) {
           sum += nums[i];
       }
       double maxSum = sum;
        for (int i = k; i < nums.length; i++) {
           sum += nums[i] - nums[i - k]; // Remove leftmost, add rightmost
           maxSum = Math.max(maxSum, sum);
       }
       return maxSum / k; 
   }

}
