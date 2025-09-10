package com.ds.java.hashing;

import java.util.HashMap;
import java.util.Map;

public class _04_CountSubArraySum {

	public static void main(String[] args) {
		int[] num = {4, 2, 2, 6, 4};
		System.out.println(subarraySum(num, 6));
		

	}
	
	public static int subarraySum(int[] arr, int k) {
        int maxCount = 0;
		 for (int i = 0; i < arr.length; i++) {
			 int sum = 0;
			for (int j = i; j < arr.length; j++) {
				sum += arr[j];
				if(sum==k) {
					maxCount++; 
				}
			}
		}
		 return maxCount;
    }
	
	
	public static int subarraySumOpt(int[] arr, int k) {
        int subarrayCount = 0;
        int currentPrefixSum = 0;
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        // Setting 0 in the map.
        prefixSumMap.put(0, 1);
		 for (int i = 0; i < arr.length; i++) {
			 currentPrefixSum += arr[i];
			
			 int sumToRemove = currentPrefixSum - k;
			 
			 subarrayCount += prefixSumMap.getOrDefault(sumToRemove, 0);
			 /*Update the count of current
	            prefix sum in the map*/
	         prefixSumMap.put(currentPrefixSum, prefixSumMap.getOrDefault(currentPrefixSum, 0) + 1);
			 
		}
		 return subarrayCount;
    }
	
	
}
