package com.ds.java.greedyalgorithm;

import java.util.Arrays;

public class _L_452_Minimum_Number_Arrows {

	public static void main(String[] args) {
		//int[][] a = {{10,16},{2,8},{1,6},{7,12}}; -- output - 2
		int[][] a = {{1,2},{3,4},{5,6},{7,8}}; 
		// output - 4
		System.out.println(findMinArrowShots(a));
		
	}
	
	 public static int findMinArrowShots(int[][] points) {
	   Arrays.sort(points,(a,b) -> Integer.compare(a[1], b[1]));
	   int arrows = 1;
       int prevEnd = points[0][1];
       
    // Count the number of non-overlapping intervals
       for (int i = 1; i < points.length; ++i) {
           if (points[i][0] > prevEnd) {
               arrows++;
               prevEnd = points[i][1];
           }
       }
       
	   return arrows;
	  }

}
