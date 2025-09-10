package com.ds.java.bitmanipulation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _06_Single_Number_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//, if nums = [1, 2, 1, 3, 5, 2], the correct answer is [3, 5], not [5, 3].
		
	}
	
	public int[] singleNumber(int[] nums) {
	    // Array to store the answer
	    int[] ans = new int[2];
	    
	    /* Map to store the elements 
	    and their frequencies */
	    HashMap<Integer, Integer> mpp = new HashMap<>();
	    
	    // Iterate on the array
	    for (int num : nums) {
	        mpp.put(num, mpp.getOrDefault(num, 0) + 1); // Update the map
	    }
	    
	    // Iterate on the map
	    int index = 0;
	    for (Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
	        // If frequency is 1
	        if (entry.getValue() == 1) {
	            /* Add the element to
	            the result array */
	            ans[index++] = entry.getKey();
	        }
	    }
	    Arrays.sort(ans);
	    return ans;
	}

}
