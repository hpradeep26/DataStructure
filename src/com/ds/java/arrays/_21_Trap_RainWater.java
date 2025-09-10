package com.ds.java.arrays;

public class _21_Trap_RainWater {
	
	public static void main(String[] args) {
		int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(arr));

	}
	//https://leetcode.com/problems/trapping-rain-water/solutions/5126477/video-keep-max-height-on-the-both-side-b-hv39/
	public static int trap(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int leftMax = height[left];
		int rightMax = height[right];
		int water = 0;

		while (left < right) {
			if (leftMax < rightMax) {
				left++;
				leftMax = Math.max(leftMax, height[left]);
				water += leftMax - height[left];
			} else {
				right--;
				rightMax = Math.max(rightMax, height[right]);
				water += rightMax - height[right];
			}
		}

		return water;        
	}


	public static int trap1(int[] height) {
		int n = height.length;
		if (n == 0) return 0;

		int[] left = new int[n];
		int[] right = new int[n];
		int storedWater = 0;

		// Fill left array
		left[0] = height[0];
		for (int i = 1; i < n; i++) {
			left[i] = Math.max(left[i - 1], height[i]);
		}

		// Fill right array
		right[n - 1] = height[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], height[i]);
		}

		// Calculate trapped water
		for (int i = 0; i < n; i++) {
			int minHeight = Math.min(left[i], right[i]);
			storedWater += minHeight - height[i];
		}

		return storedWater;
	}
}
