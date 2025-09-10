package com.ds.java.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class _12_LeadersInTheArray {

	public static void main(String[] args) {
		//right side element should be lesser than current
		int[] nums = {-3, 4, 5, 1, -4, -5};
		ArrayList<Integer> leaders = leadersOptimal(nums);
		System.out.println(leaders);
	}
	
	public static ArrayList<Integer> leaders(int[] nums) {

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			boolean flag = false;
			for (int j = i+1; j < nums.length; j++) {
				if(nums[i]<=nums[j]) {
					flag = true;
					break;
				}
			}
			if(!flag) {
				list.add(nums[i]);
			}
		}

		return list;

	}
	
	public static ArrayList<Integer> leadersOptimal(int[] nums) {

		
		ArrayList<Integer> list = new ArrayList<>();
		
		if(nums.length==0) {
			return list;
		}
		
		int max = nums[nums.length-1];
		list.add(max);
		for(int i = nums.length -2 ; i>=0;i--) {
			if(nums[i]>=max) {
				list.add(nums[i]);
				max = nums[i];
			}
		}
		
		Collections.reverse(list);
		return list;

	}

}
