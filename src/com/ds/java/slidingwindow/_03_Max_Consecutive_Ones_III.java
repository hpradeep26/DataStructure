package com.ds.java.slidingwindow;

public class _03_Max_Consecutive_Ones_III {

	public static void main(String[] args) {
		int[] arr = {0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1}; int k = 3;
		System.out.println(longestOnesBetter(arr, k));

	}
	
	public static int longestOnes(int[] nums, int k) {
		int maxLength = 0;
		int zeros = 0;
		for (int i = 0; i < nums.length; i++) {
			zeros = 0;
			for(int j = i;j< nums.length;j++) {
				if (nums[j] == 0) {

					/* Increment zeros count 
                    when encountering a zero */
					zeros++;
				}

				if (zeros <= k) {
					// Calculate the length of substring
					int len = j - i + 1;
					maxLength = Math.max(maxLength, len);
				} else break;
			}
		}
		return maxLength;

	}
	
	public static int longestOnesBetter(int[] nums, int k) {
		int maxLen = 0;
		int zeros = 0;
		int n = nums.length;
		int l = 0,r = 0;

		while(r < n) {
			if(nums[r]==0) {
				zeros++;
			}
			while(zeros > k) {
				if(nums[l] == 0){
					zeros--;
				}
				l++;
			}

			int len = r - l + 1;
			r++;
			maxLen = Math.max(maxLen, len);
		}

		return maxLen;

	}
	
	
	public static int longestOnesOptimal(int[] nums, int k) {
		int maxLen = 0;
		int zeros = 0;
		int n = nums.length;
		int l = 0,r = 0;

		while(r < n) {
			if(nums[r]==0) {
				zeros++;
			}
			while(zeros > k) {
				if(nums[l] == 0){
					zeros--;
				}
				l++;
			}
			if(zeros <= k){
				int len = r - l + 1;
				maxLen = Math.max(maxLen, len);
			}
			r++;
		}

		return maxLen;

	}

}
