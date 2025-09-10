package com.ds.java.sorting;

import java.util.Arrays;

public class _03_Inseration_Sort {

	public static void main(String[] args) {
		int[] nums = {28,1,10,5,2};
		insertionSort(nums);
		System.out.println(Arrays.toString(nums));

	}
	
	public static int[] insertionSort(int[] nums) {
		for(int i=1;i<nums.length;i++) {
			for(int j = i-1;j>=0;j--) {
				if(nums[j]>nums[j+1]) {
					 int temp = nums[j];
						nums[j] = nums[j+1];
						nums[j+1] = temp;
				 }
				 //System.out.println(Arrays.toString(nums));
			}
		}
		return nums;
    }
	
	public int[] insertionSort1(int[] nums) {
        int n = nums.length;
        // Traverse through the array
        for (int i = 1; i < n; i++) {
            int key = nums[i];
            int j = i - 1;

            // Swap elements till we reach greater element
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j = j - 1;
            }
            nums[j + 1] = key;
        }
        return nums;
    }

}
