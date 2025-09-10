package com.ds.java.hashing;

import java.util.HashMap;
import java.util.Map;

public class _06_Contains_Duplicates {

	public static void main(String[] args) {
		int[] nums = {1,2,3,1,2,3}; int k = 2;
		System.out.println(containsNearbyDuplicate(nums, k));

	}
	
	 public static boolean containsNearbyDuplicate(int[] nums, int k) {
	      Map<Integer,Integer> map = new HashMap<>();   
		 for(int i =0 ; i < nums.length; i++) {
			 int num = nums[i];
	        	if(map.containsKey(num)) {
	        		int index = map.get(num);
	        		int diff = Math.abs(i - index);
	        		if(diff<=k) {
	        			return true;
	        		}
	        	}
	        	map.put(nums[i], i);
	      }
		 return false;
	  }

}
