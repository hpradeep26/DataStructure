package com.ds.java.binarysearch;

import java.util.Arrays;

public class _06_FirstAndLastOccurance {
	
	//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
	public static void main(String[] args) {
		int[] nums = {5, 7, 7, 8, 8, 10};
		System.out.println(Arrays.toString(searchRangeBinarySearch(nums, 7)));

	}
	
	
	public static int[] searchRange(int[] nums, int target) {
	    int[] res = {-1,-1};
	    //from beginning
	    for(int i = 0;i<nums.length;i++) {
	    	if(nums[i]==target) {
	    		res[0] = i;
	    		break;
	    	}
	    }
	    //from end
	    for(int i = nums.length-1;i>=0;i--) {
	    	if(nums[i]==target) {
	    		res[1] = i;
	    		break;
	    	}
	    }
	    
	    return res;
    }
	
	public static int[] searchRangeBinarySearch(int[] nums, int target) {
		int firstOccurance = findFirstOccurance(nums,target);
		
		int secondOccurance = findSecondOccurance(nums,target);
		 
		return new int[] {firstOccurance,secondOccurance};
	}


	private static int findSecondOccurance(int[] nums, int target) {
		int ans = -1;
		int low = 0;
		int high = nums.length -1;
		while(low<=high) {
			int mid = low + (high - low)/2;
			
			if(nums[mid]==target) {
				ans = mid;
				low = mid + 1;
			}else if (nums[mid]>target) {
				high = mid - 1;
			}else {
				low = mid + 1;
			}
		}
		
		return ans;
	}


	private static int findFirstOccurance(int[] nums, int target) {
		int ans = -1;
		int low = 0;
		int high = nums.length -1;
		while(low<=high) {
			int mid = low + (high - low)/2;
			
			if(nums[mid]==target) {
				ans = mid;
				high = mid - 1;
			}else if (nums[mid]>target) {
				high = mid - 1;
			}else {
				low = mid + 1;
			}
		}
		
		return ans;
	}

}
