package com.ds.java.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _25_MajorityElement_II {

	public static void main(String[] args) {
		 int[] arr = {11, 33, 33, 11, 33, 11};
		 System.out.println(majorityElementTwoOptimal(arr));

	}
	
public static List<Integer> majorityElementTwo(int[] nums) {
        
        // Size of the array
        int n = nums.length;

        // List of answers
        List<Integer> result = new ArrayList<>();

        // Declaring a map
        Map<Integer, Integer> mpp = new HashMap<>();

        // Least occurrence of the majority element
        int mini = n / 3 + 1;

        // Storing the elements with its occurrence
        for (int i = 0; i < n; i++) {
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);

            // Checking if nums[i] is the majority element
            if (mpp.get(nums[i]) == mini) {
                result.add(nums[i]);
            }

            // If result size is equal to 2 break out of loop
            if (result.size() == 2) {
                break;
            }
        }

        // Return the majority elements
        return result;
    }

public static List<Integer> majorityElementTwoOptimal(int[] nums) {
	  // Size of the array
    int n = nums.length;

    // List of answers
    List<Integer> result = new ArrayList<>();
    
    // Least occurrence of the majority element
    int mini = n / 3 + 1;
    // Counts for elements el1 and el2
    int count1 =0,count2 = 0;
    /*Initialize Element 1 and 
    Element 2 with INT_MIN value*/
    int ele1 = Integer.MIN_VALUE;
    int ele2 = Integer.MIN_VALUE;
    
    /*Find the potential candidates using
    Boyer Moore's Voting Algorithm*/
    for(int i = 0 ; i < n ; i++) {
    	if(count1==0 && ele2 != nums[i]) {
    		count1++;
    		  // Initialize el1 as nums[i]
    		ele1 = nums[i];
    	}else if(ele1 == nums[i]) {
    		 // Increment count for el1
    		count1++;
    	}else if(count2==0 && ele1 != nums[i]) {
    		 // Initialize el2 as nums[i]
    		count2++;
    		ele2 = nums[i];
    	}else if(ele2 == nums[i]) {
    		 // Increment count for el2
    		count2++;
    	}else {
    		 // Decrement count for el1 , el2
    		count1--;count2--;
    	}
    }
    
    //Validate the candidates by counting occurrences in nums:
    //Reset counts for el1 and el2
    count1 = 0; count2 = 0;
    for (int i = 0; i < nums.length; i++) {
    	 // Count occurrences of el1 and el2
		if(nums[i]==ele1) count1++;
		if(nums[i]==ele2) count2++;
	}

    /*Add elements to the result vector
    if they appear more than n/3 times*/
    if(count1>=mini) {
    	result.add(ele1);
    }
    
    if(count2>=mini) {
    	result.add(ele2);
    }
    return result;
}

}
