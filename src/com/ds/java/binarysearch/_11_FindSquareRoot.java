package com.ds.java.binarysearch;

public class _11_FindSquareRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public static long floorSqrt(long n) {
	      long low = 1, high = n;
	   // Binary search on the answer space
	      while(low<=high) {
	    	  long mid = low + (high-low)/2;
	    	  long val = mid * mid;
	    	  // Check if val is less than or equal to n
	    	  if(val <= n) {
	    		  // Move to the right part
	    		  low = mid + 1;
	    	  }else {
	    		// Move to the left part
	    		  high = mid - 1;
	    	  }
	      }
	      return high;
	    }

}
