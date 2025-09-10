package com.ds.java.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class _04_Fruit_Into_Basket {

	public static void main(String[] args) {
		int[] fruits = {1,2,3,2,2};
		System.out.println(totalFruitBetter(fruits));

	}
	
	
	public static int totalFruit(int[] fruits) {
		int maxLength = 0;
		int n = fruits.length;
		for(int i = 0 ;i < n; i++) {
			Set<Integer> set = new HashSet<>();
			for (int j = i; j < n; j++) {
				set.add(fruits[j]);
				if(set.size()<=2) {
					maxLength = Math.max(maxLength, j-i+1);
				}else {
					break;
				}
			}
		}
		return maxLength;
	}
	
	public static int totalFruitBetter(int[] fruits) { 
		int n = fruits.length;
    
    /* Variable to store the 
    maximum length of substring */
    int maxLen = 0;  
    
    /* Map to track the count of each
    fruit type in the current window */
    HashMap<Integer, Integer> mpp = new HashMap<>();
    
    // Pointers for the sliding window approach
    int l = 0, r = 0;
    
    while (r < n) {
        mpp.put(fruits[r], mpp.getOrDefault(fruits[r], 0) + 1);
        
        /* If number of different fruits exceeds
         2 shrink the window from the left */
        if (mpp.size() > 2) {
            while (mpp.size() > 2) {
                mpp.put(fruits[l], mpp.get(fruits[l]) - 1);
                if (mpp.get(fruits[l]) == 0) {
                    mpp.remove(fruits[l]);
                }
                l++;
            }
        }
        
        /* If number of different fruits 
        is at most 2, update maxLen */
        if (mpp.size() <= 2) {
            maxLen = Math.max(maxLen, r - l + 1);
        }
        
        r++;
    }
	return maxLen;
	}
	
public int totalFruits(int[] fruits) {
        
        // Length of the input array
        int n = fruits.length;
        
        /* Variable to store the 
        maximum length of substring */
        int maxLen = 0;  
        
        /* Map to track the count of each
        fruit type in the current window */
        HashMap<Integer, Integer> mpp = new HashMap<>();
        
        // Pointers for the sliding window approach
        int l = 0, r = 0;
        
        while (r < n) {
            mpp.put(fruits[r], mpp.getOrDefault(fruits[r], 0) + 1);
            
            /* If number of different fruits exceeds
             2 shrink the window from the left */
            if (mpp.size() > 2) {
                mpp.put(fruits[l], mpp.get(fruits[l]) - 1);
                if (mpp.get(fruits[l]) == 0) {
                    mpp.remove(fruits[l]);
                }
                l++;
            }
            
            /* If number of different fruits 
            is at most 2, update maxLen */
            if (mpp.size() <= 2) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            
            r++;
        }
        
        // Return the maximum fruit
        return maxLen;
    }

}
