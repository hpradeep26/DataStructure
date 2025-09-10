package com.ds.java.bitmanipulation;

import java.util.Arrays;
import java.util.HashMap;

public class _05_Single_Number_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
public int singleNumberBrute(int[] nums) {
        
        /* Map to store the elements 
        and their frequencies */
        HashMap<Integer, Integer> mpp = new HashMap<>();
        
        // Iterate on the array
        for (int i = 0; i < nums.length; i++) {
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1); // Update the map
        }
        
        // Iterate on the map
        for (HashMap.Entry<Integer, Integer> it : mpp.entrySet()) {
            // If frequency is 1
            if (it.getValue() == 1) {
                // Return the element
                return it.getKey();
            }
        }
        
        /* Return -1, if there is no 
        number having frequency 1 */
        return -1;
    }
	
	public int singleNumber(int[] nums) {
        int n = nums.length;
     
     // Sorting the array
     Arrays.sort(nums);
     
     // Traversing the array
     for (int i = 1; i < nums.length; i += 3) {
         /* Checking the elements 
         in the bucket */
         if (nums[i] != nums[i - 1]) {
             // Return the single number
             return nums[i - 1];
         }
     }
     
     /* If not found till now, then 
     the last number will be single */
     return nums[n - 1];
 }

}
