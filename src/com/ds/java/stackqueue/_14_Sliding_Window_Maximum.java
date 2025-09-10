package com.ds.java.stackqueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class _14_Sliding_Window_Maximum {

	public static void main(String[] args) {
		int[] arr = {1, 3, -1, -3, 5, 3, 6, 7}; int k = 3;
		//[3, 3, 5, 5, 6, 7]
		System.out.println(Arrays.toString(maxSlidingWindowOptimal(arr, k)));

	}
	
	public static int[] maxSlidingWindow(int[] arr, int k) {
	    int[] res = new int[arr.length-k+1];
	    int left = 0;
	    int right = k;
	    
	    while(right<=arr.length) {
	    	int max = findMax(left,right,arr);
	    	res[left] = max;
	    	left++;
	    	right = left + k;
	    }
	    
	    return res;
    }

	private static int findMax(int left, int right,int[] arr) {
		int max = arr[left];
		while(left<right) {
			max = Math.max(arr[left], max); 
			left++;
		}
		return max;
	}
	
public static int[] maxSlidingWindowOptimal(int[] arr, int k) {
        
        int n = arr.length; // Size of array
        
        // To store the answer
        int[] ans = new int[n - k + 1];
        int ansIndex = 0;
        
        // Deque data structure
        Deque<Integer> dq = new LinkedList<>();
        
        // Traverse the array
        for (int i = 0; i < n; i++) {
            
            // Update deque to maintain current window
            if (!dq.isEmpty() && dq.peekFirst() <= (i - k)) {
                dq.pollFirst();
            }
            
            /* Maintain the monotonic (decreasing) 
            order of elements in deque */
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }
            
            // Add current element's index to the deque
            dq.offerLast(i);
            
            /* Store the maximum element from 
            the first window possible */
            if (i >= (k - 1)) {
                ans[ansIndex++] = arr[dq.peekFirst()];
            }
        }
        
        // Return the stored result
        return ans;
    }

}
