package com.ds.java.binarysearch;

import java.util.Arrays;
import java.util.List;

public class _09_FindMinimumRotatedSortArray {
	//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
	public static void main(String[] args) {
		 System.out.println(findKRotated(Arrays.asList(5,6,2,3,4)));
	}
	
	// logic - find minimum number and return index to find rotated times
	public static int findKRotated(List<Integer> nums) {
        int low = 0;
        int high = nums.size() - 1;
        int index = 0;
        int min = Integer.MAX_VALUE;
        while(low<=high) {
        	int mid = low + (high - low)/2;
        	
        	if(nums.get(low)<=nums.get(mid)) {
        		if(nums.get(low)<min) {
        			min = nums.get(low);
        			index = low;
        		}
        		low = mid + 1;
        	}else {
        		if(nums.get(mid)<= nums.get(high)) {
        			if(nums.get(mid)<min) {
            			min = nums.get(mid);
            			index = mid;
            		}
        		}
        		high = mid - 1;
        	}
        }
        return index;
    }

}
