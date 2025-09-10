package com.ds.java.arrays;

import java.util.HashMap;
import java.util.Map;

public class _24_MajorityElement {

	public static void main(String[] args) {
		int[] nums = {7, 0, 0, 1, 7, 7, 2, 7, 7};
		majorityElement(nums);

	}
	
	public static int majorityElement(int[] nums) {
		 int n = nums.length;
	        
	        // Hash map to store element counts
	        HashMap<Integer, Integer> map = new HashMap<>();
	        
	        // Count occurrences of each element
	        for (int num : nums) {
	            map.put(num, map.getOrDefault(num, 0)+1);
	        }
	        
	        /* Iterate through the map to
	        find the majority element*/
	        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
	            if (entry.getValue() > n / 2) {
	                return entry.getKey();
	            }
	        }
	        
	        // Return -1 if no majority element is found
	        return -1;
	}
	
	public static int majorityElementOptimal(int[] nums) {
		 int n = nums.length;
	        
	       int count = 0;
	       int element = 0;
	       for (int i = 0; i < nums.length; i++) {
			if(count==0) {
				count++;
				element = nums[i];
			}else if(nums[i]==element){
				count++;
			}else {
				count--;
			}
		}
	       
	       
	        /* Checking if the stored element
	         is the majority element*/
	        int cnt1 = 0;
	        for (int i = 0; i < n; i++) {
	            if (nums[i] == element) {
	                cnt1++;
	            }
	        }
	        
	        if (cnt1 > (n / 2)) {
	            return element;
	        }
	        
	        // Return -1 if no majority element is found
	        return -1;
	}

}
