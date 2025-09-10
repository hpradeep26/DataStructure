package com.ds.java.greedyalgorithm;

import java.util.Arrays;

public class _07_Non_Overlaping_Intervals {

	public static void main(String[] args) {
		 int[][] intervals = {{1,3}, {1, 4}, {3,5}, {3, 4}, {4, 5}};
		 MaximumNonOverlappingIntervals(intervals);

	}
	
	
	 public static int MaximumNonOverlappingIntervals(int[][] intervals) {
	        // Sort the intervals based on their ending times
	        Arrays.sort(intervals, (a,b)-> Integer.compare(a[1], b[1]));
	    
	        // Get total number of intervals
	        int n = intervals.length;
	    
	        // Initialize counter
	        int cnt = 1;
	    
	        // Keep track of the ending time
	        int lastEndTime = intervals[0][1];
	    
	        // Iterate through all intervals
	        for (int i = 1; i < n; i++) {
	            /* Check if the starting time of the current 
	            interval is greater than or equal to 
	            the ending time of the last 
	            selected interval */
	            if (intervals[i][0] >= lastEndTime) {
	                // Increment counter
	                cnt++;
	                // Update the ending time
	                lastEndTime = intervals[i][1];
	            }
	        }
	        return n-cnt;
	    }
	
}
