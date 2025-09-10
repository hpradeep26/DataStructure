package com.ds.java.arrays;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class _08_RemoveDuplicates {

	public static void main(String[] args) {
		int[] nums = {0, 0, 3, 3, 5, 6};
		_08_RemoveDuplicates duplicates = new _08_RemoveDuplicates();
		removeDuplicates(nums);
		System.out.println(duplicates.removeDuplicatesOptimal(nums));
		System.out.println(Arrays.toString(nums));

	}
	
	public static int removeDuplicates(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();
       
        for(int i =0;i<nums.length;i++) {
        	set.add(nums[i]);
        }
        
        int index =0;
       for (Integer integer : set) {
		nums[index++] = integer;
       }
        
        return set.size();
    }
	
	
	public int removeDuplicatesOptimal(int[] nums) {
       int index = 0;
       
       for(int i = 1;i<nums.length;i++) {
    	   if(nums[i]!=nums[i-1]) {
    		   nums[++index] = nums[i];
    	   }
       }
       
       return index+1;
    }

}
