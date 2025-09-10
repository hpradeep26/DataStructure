package com.ds.java.greedyalgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _08_Insert_Interval {

	public static void main(String[] args) {
		int[][] intervals = {{1, 2}, {3, 4}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {5, 8};
        insertNewInterval(intervals, newInterval);
	}
	
	 public static int[][] insertNewInterval(int[][] intervals, int[] newInterval) {
	       List<int[]> resList = new ArrayList<>();
	       
	       int n = intervals.length;
	       int i = 0;
	       // Insert intervals before newInterval
	       while(i<n && intervals[i][1]<newInterval[0]) {
	    	   /* Add intervals to the result list
	            until their end time is before
	            the start time of newInterval */
	    	   resList.add(intervals[i]);
	    	   i++;
	       }
	       // Merge overlapping intervals
	       while(i<n && newInterval[1]>=intervals[i][0]) {
	    	   newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
	    	   newInterval[1]= Math.max(intervals[i][1], newInterval[1]);
	    	   i++;
	       }
	       resList.add(newInterval);
	       
	       while(i<n) {
	    	   //second part
	    	   resList.add(intervals[i]);
	    	   i++;
	       }
	       return resList.toArray(new int[resList.size()][]);
	    }
	 
	 
	 public int[][] insert(int[][] intervals, int[] newInterval) {
	       List<int[]> intervalList = new ArrayList<>(Arrays.asList(intervals));
	        intervalList.add(newInterval);
	        Collections.sort(intervalList, (a, b) -> Integer.compare(a[0], b[0]));

	        List<int[]> res = new ArrayList<>();
	        int[] current = intervalList.get(0);

	        for (int i = 1; i < intervalList.size(); i++) {
	            int[] interval = intervalList.get(i);
	            
	            if (current[1] >= interval[0]) {
	                current[1] = Math.max(current[1], interval[1]);
	            } else {
	                res.add(current);
	                current = interval;
	            }
	        }

	        res.add(current);
	        return res.toArray(new int[res.size()][]);
	    }

}
