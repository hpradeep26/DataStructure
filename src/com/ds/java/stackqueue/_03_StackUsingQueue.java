package com.ds.java.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class _03_StackUsingQueue {
	
	  Queue<Integer> q = new LinkedList<>();
	  
	  
	// Method to push element in the stack
	    public void push(int x) {
	    	int s = q.size();
	    	// Add element
	        q.add(x);
	        
	     // Move elements before new element to back
	        for (int i = 0; i < s; i++) {
	            q.add(q.poll());
	        }
	    	
	    }
	    
	    // Method to pop element from stack
	    public int pop() {
	        // Get front element
	        int n = q.peek();
	        // Remove front element
	        q.poll();
	        // Return removed element
	        return n;
	    }
	    
	    
	 // Method to return the top of stack
	    public int top() {
	        // Return front element
	        return q.peek();
	    }

	    // Method to check if the stack is empty
	    public boolean isEmpty() {
	        return q.isEmpty();
	    }

	public static void main(String[] args) {
		_03_StackUsingQueue queue = new _03_StackUsingQueue();
		queue.push(5);
		queue.push(10);
		queue.push(15);
		
		queue.pop();
	}

}
