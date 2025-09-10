package com.ds.java.stackqueue;

import java.util.Arrays;
import java.util.Stack;

public class _09_NextGreaterElement {

	public static void main(String[] args) {
		 int n = 6;
	        int[] arr = {5, 7, 1, 7, 6, 0};
	        int[] res = nextGreaterElementsOptimal(arr);
	        System.out.println(Arrays.toString(res));
	}
	
	
	public static int[] nextGreaterElementsOptimal(int[] arr) {
		int n = arr.length;
		int[] ans = new int[n];
		Stack<Integer> st = new Stack<Integer>();
		
		for(int i = 2* n - 1; i>=0 ; i--) {
			
			int index = i % n;
			int element = arr[index];
			
			while(!st.empty() && st.peek()<=element) {
				st.pop();
			}
			
			if(i<n) {
				if(st.isEmpty())
					ans[i] = -1;
				else
					ans[i] = st.peek();
			}
			
			st.push(element);
		}
		
		
		return ans;
		
	}
	
	
	public static int[] nextGreaterElements(int[] arr) {
	       
        int n = arr.length; // size of array
        
        // To store the next greater elements
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
       
        for(int i = 0; i < n; i++) {
           
            // Get the current element
            int currEle = arr[i];
           
            /* Nested loop to get the 
            next greater element */
            for(int j = 1; j < n; j++) {
               
                // Getting the hypothetical index
                int ind = (j + i) % n;
               
                // If the next greater element is found
                if(arr[ind] > currEle) {
                   
                    // Store the next greater element
                    ans[i] = arr[ind];
                   
                    // Break from the loop
                    break;
                }    
            }
        }
       
        // Return the answer
        return ans;
    }

}
