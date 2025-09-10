package com.ds.java.hashing;

import java.util.HashMap;
import java.util.Map;

public class _05_CountSubArrayXorK {

	public static void main(String[] args) {
		int[] num = {1,2,3,-3,1,1,1,4,2,-3};
		System.out.println(subarraysWithXorK(num, 3));
		

	}
	
	public static int subarraysWithXorK(int[] arr, int k) {
        int count = 0;
		 for (int i = 0; i < arr.length; i++) {
			 int xor = 0;
			for (int j = i; j < arr.length; j++) {
				xor ^= arr[j];
				if(xor==k) {
					count++; 
				}
			}
		}
		 return count;
    }
	
	public static int subarraysWithXorKOpt(int[] arr, int k) {
        int subarrayCount = 0;
        int xor = 0;
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        // Setting 0 in the map.
        prefixSumMap.put(0, 1);
		 for (int i = 0; i < arr.length; i++) {
			 xor ^= arr[i];
			
			 int x = xor ^ k;
			 
			 subarrayCount += prefixSumMap.getOrDefault(x, 0);
			 /*Update the count of current
	            prefix sum in the map*/
	         prefixSumMap.put(xor, prefixSumMap.getOrDefault(xor, 0) + 1);
			 
		}
		 return subarrayCount;
    }
}
