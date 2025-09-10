package com.ds.java.greedyalgorithm;

import java.util.Arrays;

public class _09_Minimum_No_of_Platforms_Required {

	public static void main(String[] args) {
		int[] arr = {900, 945, 955, 1100, 1500, 1800};
        int[] dep = {920, 1200, 1130, 1150, 1900, 2000};
        findPlatformOptimal(arr, dep);
	}
	
	 public int findPlatformBrute(int[] Arrival, int[] Departure) {
		 int n = Arrival.length;

	        // To store the result
	        int ans = 1;

	        // Iterate on the trains platforms
	        for (int i = 0; i < n; i++) {
	            
	            int count = 1;

	            // Iterate on all the trains 
	            for (int j = 0; j < n; j++) {
	                // Check with other trains
	                if (i != j) {

	                    // Check for the overlapping trains 
	                    if ((Arrival[i] >= Arrival[j] && Departure[j] >= Arrival[i])) {
	                        // Increment count
	                        count++;
	                    }

	                    // Update the minimum platforms needed
	                    ans = Math.max(ans, count);
	                }
	            }
	        }

	        // Return number of platforms
	        return ans;
		 
	 }
	 
	 
	 public static int findPlatformOptimal(int[] Arrival, int[] Departure) {
	        int n = Arrival.length;

	        // Sort both arrival and departure arrays
	        Arrays.sort(Arrival);
	        Arrays.sort(Departure);

	        int ans = 1;
	        int count = 1;
	        int i = 1, j = 0;

	        // Iterate through the arrays
	        while (i < n && j < n) {
	            if (Arrival[i] <= Departure[j]) {
	                // Increment count
	                count++;
	                i++;
	            } else {
	                // Decrement count
	                count--;
	                j++;
	            }
	            // Find maximum
	            ans = Math.max(ans, count);
	        }
	        return ans;
	    }

}
