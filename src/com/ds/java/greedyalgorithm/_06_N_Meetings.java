package com.ds.java.greedyalgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _06_N_Meetings {

	public static void main(String[] args) {
		 int[] start = {1, 3, 0, 5, 8, 5};
	     int[] end = {2, 4, 6, 7, 9, 9};
	     maxMeetings(start, end);

	}
	
	public static int maxMeetings(int[] start, int[] end) {
	      List<int[]> meetings = new ArrayList<>();
	      
	      int length= start.length;
	      
	      for (int i = 0; i < length; i++) {
	    	  meetings.add(new int[] {start[i],end[i]});
	      }
	      
	      Collections.sort(meetings, (o1,o2)-> Integer.compare(o1[1], o2[1]));
	      
	      // The end time of last selected meeting
	        int limit = meetings.get(0)[1];
	        
	     // Initialize count
	        int count = 1;
	        
	        for (int i = 1; i < length; i++) {
	        	 if (meetings.get(i)[0] > limit) {
	        		  limit = meetings.get(i)[1];
	        		  count++;
	        	 }
	        }
	      return count;
	    }
	
	
	

}


