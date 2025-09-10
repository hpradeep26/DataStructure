package com.ds.java.greedyalgorithm;

import java.util.Arrays;

public class _04_ShortestJobFirst {

	public static void main(String[] args) {
		int[] nums = {9, 3, 1, 8, 2};
		
		//output - 4
		
		System.out.println(solve(nums));

	}
	//sort - 1,2,3,4,7
	 public static long solve(int[] bt) {
	       int n = bt.length;
	       Arrays.sort(bt);
	       long totalTime = 0;
	       long waitTime = 0;
	       
	       for(int i = 0 ; i<n ;i++) {
	    	   System.out.println("i :"+i + " value :"+bt[i]);
	    	   waitTime += totalTime;
	    	   totalTime += bt[i];
	    	   System.out.println("waitTime - " +waitTime  +" totalTime - "+totalTime );
	       }
	       
	       return waitTime/n;
	    }

}
