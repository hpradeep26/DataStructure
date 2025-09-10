package com.ds.java.recursion;

import java.util.Arrays;

public class _07_ReverseArray {

	public static void main(String[] args) {
		int[] num = {1,2,3,4,5};
		System.out.println(Arrays.toString(num));
		reverseArray(num);
		System.out.println(Arrays.toString(num));
	}
	
	public static int[] reverseArray(int[] nums) {
        reverse(0, nums.length-1, nums);
        return nums;
    }
	
	private static void reverse(int left,int right,int[] nums) {
		if(left>=right) {
			return;
		}
		
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
		
		reverse(left+1, right-1, nums);
	}

}
