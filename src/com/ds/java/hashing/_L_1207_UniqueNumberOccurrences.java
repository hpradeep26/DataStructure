package com.ds.java.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _L_1207_UniqueNumberOccurrences {

	public static void main(String[] args) {
		
		List<Integer> asList = Arrays.asList(1,2,3,4);
		asList.add(5);
		int[] arr = {-3,0,1,-3,1,1,1,-3,10,0};
		uniqueOccurrences(arr);

	}
	
	 public static boolean uniqueOccurrences(int[] arr) {
	        Map<Integer,Integer> freq = new HashMap<>();
	        int n = arr.length;
	        for (int x : arr) {
	            freq.put(x, freq.getOrDefault(x, 0) + 1);
	        }
	        Set<Integer> set = new HashSet<>();
	        for (Map.Entry<Integer, Integer> me : freq.entrySet()) {
	            if (set.contains(me.getValue())) {
	                return false;
	            } else {
	                set.add(me.getValue());
	            }
	        }
	        return true;
	    }

}
