package com.ds.java.sorting;

import java.util.Arrays;

public class _01_Selection_Sort {

	public static void main(String[] args) {
		int num[] = {5, 4, 4, 1, 1};
		selectionSort2(num);
		System.out.println(Arrays.toString(num));
	}
	/* 
	 * Select smallest element in the array and swap with i
	 */
	
	public static int[] selectionSort1(int[] nums) {
		for(int i =0;i<nums.length;i++) {
			 for(int j = i+1;j<nums.length;j++) {
				 if(nums[i]>nums[j]) {
					 int temp = nums[i];
						nums[i] = nums[j];
						nums[j] = temp;
				 }
			 }
		 }
		
		return nums;

	}
	
	public static int[] selectionSort2(int[] nums) {
		//method1 
		for(int i = 0; i<nums.length;i++) {
			int minIndex = i;
			for(int j = i+1;j<nums.length;j++) {
				if(nums[minIndex]>nums[j]) {
					minIndex = j;
				}
			}
			if(minIndex != i) {
				int temp = nums[i];
				nums[i] = nums[minIndex];
				nums[minIndex] = temp;
			}
		}
		return nums;
    }
	

}
