package com.ds.java.stackqueue;

import java.util.Stack;

public class _15_Stock_span_problem {
	
	public static void main(String[] args) {
	/*
	 * Input: n = 7, arr = [120, 100, 60, 80, 90, 110, 115]
	 * 
	 * Output: 1 1 1 2 3 5 6
	 * 
	 * Explanation:
	 * 
	 * Traversing the given input span:
	 * 
	 * 120 is greater than or equal to 120 and there are no more elements behind it
	 * so the span is 1,
	 * 
	 * 100 is greater than or equal to 100 and smaller than 120 so the span is 1,
	 * 
	 * 60 is greater than or equal to 60 and smaller than 100 so the span is 1,
	 * 
	 * 80 is greater than or equal to 60, 80 and smaller than 100 so the span is 2,
	 * 
	 * 90 is greater than or equal to 60, 80, 90 and smaller than 100 so the span is
	 * 3,
	 * 
	 * 110 is greater than or equal to 60, 80, 90, 100, 110 and smaller than 120 so
	 * the span is 5,
	 * 
	 * 115 is greater than or equal to all previous elements and smaller than 120 so
	 * the span is 6.
	 * 
	 * Hence the output will be 1 1 1 2 3 5 6. }
	 */
	}
	
	/* Function to find the indices of previous 
    greater element for each element in the array */
    private int[] findPGE(int[] arr) {
        
        int n = arr.length; //size of array
        
        // To store the previous greater elements
        int[] ans = new int[n];
        
        // Stack to get elements in LIFO fashion
        Stack<Integer> st = new Stack<>();
        
        // Start traversing from the front
        for(int i = 0; i < n; i++) {
            
            // Get the current element
            int currEle = arr[i];
            
            /* Pop the elements in the stack until 
            the stack is not empty and the top 
            element is not the greater element */
            while(!st.isEmpty() && arr[st.peek()] <= currEle) {
                st.pop();
            }
            
            /* If the greater element is not 
            found, stack will be empty */
            if(st.isEmpty()) 
                ans[i] = -1;
                
            // Else store the answer
            else 
                ans[i] = st.peek();
            
            // Push the current index in the stack 
            st.push(i);
        }
        
        // Return the result
        return ans;
    }
    
    // Function to find the span of stock prices for each day
    public int[] stockSpan(int[] arr, int n) {
        
        // Get the indices of previous greater elements
        int[] PGE = findPGE(arr);
        
        // To store the answer
        int[] ans = new int[n];
        
        // Compute the result
        for(int i = 0; i < n; i++) {
            ans[i] = i - PGE[i];
        }
        
        // Return the result
        return ans;
    }

}
