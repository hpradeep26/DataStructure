package com.ds.java.stackqueue;

public class _16_Celebrity_Problem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int celebrity(int[][] M) {
		 // Size of given matrix
        int n = M.length;
		  /* To store count of people who 
        know person of index i */
        int[] knowMe = new int[n];
        
        /* To store count of people who 
        the person of index i knows */
        int[] Iknow = new int[n];
        
        // Traverse on given matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
                // If person i knows person j
                if (M[i][j] == 1) {
                    knowMe[j]++;
                    Iknow[i]++;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            
            // Return the index of celebrity
            if (knowMe[i] == n - 1 && Iknow[i] == 0) {
                return i;  
            }
        }
		return -1;
    }
	
	
	 public int celebrityOptimal(int[][] M) {
	        
	        // Size of given matrix
	        int n = M.length;
	        
	        // Top and Down pointers
	        int top = 0, down = n - 1;
	        
	        // Traverse for all the people
	        while (top < down) {
	            
	            /* If top knows down, 
	            it can not be a celebrity */
	            if (M[top][down] == 1) {
	                top = top + 1;
	            }
	            
	            /* If down knows top, 
	            it can not be a celebrity */
	            else if (M[down][top] == 1) {
	                down = down - 1;
	            }
	            
	            /* If both do not know each other, 
	            both cannot be the celebrity */
	            else {
	                top++;
	                down--;
	            }
	        }
	        
	        // Return -1 if no celebrity is found
	        if (top > down) return -1;
	        
	        /* Check if the person pointed 
	        by top is celebrity */
	        for (int i = 0; i < n; i++) {
	            if (i == top) continue;
	            
	            // Check if it is not a celebrity
	            if (M[top][i] == 1 || M[i][top] == 0) {
	                return -1;
	            }
	        }
	        
	        // Return the index of celebrity
	        return top;
	    }


}
