package com.ds.java.arrays;

import java.util.Arrays;

public class _22_SortAnArraysZeroOneTwo {

	public static void main(String[] args) {
		int[] num = {1, 0, 2, 1, 0};
		sortZeroOneTwo1(num);
		System.out.println(Arrays.toString(num));

	}
	// sort an array
	public static void sortZeroOneTwo(int[] nums) {
        Arrays.sort(nums);
   }

	// using seprate counter 0,1,2 counter
	public static void sortZeroOneTwo1(int[] nums) {
        int countZero = 0;
        int countOne = 0;
        int countTwo = 0;
        
        for (int i = 0; i < nums.length; i++) {
			if(nums[i]==0) {
				countZero++;
			}
			if(nums[i]==1) {
				countOne++;
			}
			if(nums[i]==2) {
				countTwo++;
			}
		}
        int index = 0;
        while(countZero>0) {
        	nums[index++] = 0;
        	countZero--;
        }
        
        while(countOne>0) {
        	nums[index++] = 1;
        	countOne--;
        }
        while(countTwo>0) {
        	nums[index++] = 2;
        	countTwo--;
        }
        
        System.out.println(Arrays.toString(nums));
   }
	
	/*Initialize low and mid at 0 and high is sizeOfArray - 1, & iterate in the array until mid <= high. There can be three different values of mid pointer i.e. arr[mid].
			If arr[mid] is equal to 0, swap arr[low] and arr[mid] and increment both low and mid. Now the subarray from index 0 to (low-1) only contains 0.
			If arr[mid] is equal to 1, just increment the mid pointer and then the index (mid-1) will point to 1 as it should according to the rules.
			If arr[mid] is equal to 2, swap arr[mid] and arr[high] and decrement high. Now the subarray from index high+1 to (n-1) only contains 2.
			 In this step, do nothing to the mid-pointer as even after swapping, the subarray from mid to high(after decrementing high) might be unsorted.
			  So, check the value of mid again in the next iteration. Finally, the array should be sorted*/
	public static void sortZeroOneTwo2(int[] nums) {
		int low = 0,mid = 0,high = nums.length - 1;
		while( mid < high) {
			if(nums[mid]==0) {
				int temp = nums[low];
				nums[low] = nums[mid];
				nums[mid] = temp;
				low++;mid++;
			}else if(nums[mid]==1) {
				mid++;
			}else {
				int temp = nums[mid];
				nums[mid] = nums[high];
				nums[high] = temp;
				high--;
			}
		}
		
	}
}
