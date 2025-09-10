package com.ds.java.stackqueue;

import java.util.Stack;

public class _13_Implement_Min_Stack {

	public static void main(String[] args) {
		MinStack3 min = new MinStack3();
		min.push(12);
		min.push(15);
		min.push(10);
		min.getMin();
		min.pop();
		min.getMin();
		min.push(10);
		min.getMin();

	}
	
	class MinStack {
	    private Stack<Integer> st;
	    private int mini;

	    // Empty Constructor
	    public MinStack() {
	        st = new Stack<>();
	    }

	    // Method to push a value in stack
	    public void push(int value) {
	        // If stack is empty
	        if (st.isEmpty()) {
	            // Update the minimum value
	            mini = value;

	            // Push current value as minimum
	            st.push(value);
	            return;
	        }

	        // If the value is greater than the minimum
	        if (value > mini) {
	            st.push(value);
	        } else {
	            // Add the modified value to stack
	            st.push(2 * value - mini);
	            // Update the minimum
	            mini = value;
	        }
	    }

	    // Method to pop a value from stack
	    public void pop() {
	        // Base case
	        if (st.isEmpty()) return;

	        // Get the top
	        int x = st.pop();

	        // If the modified value was added to stack
	        if (x < mini) {
	            // Update the minimum
	            mini = 2 * mini - x;
	        }
	    }

	    // Method to get the top of stack
	    public int top() {
	        // Base case
	        if (st.isEmpty()) return -1;

	        // Get the top
	        int x = st.peek();

	        // Return top if minimum is less than the top
	        if (mini < x) return x;

	        // Otherwise return mini
	        return mini;
	    }

	    // Method to get the minimum in stack
	    public int getMin() {
	        // Return the minimum
	        return mini;
	    }
	}
	
	
	
}

class MinStack3 {
    private Node head;
    
    public void push(int val) {
        if(head==null){
            head=new Node(val,val,null);
        }else{
            head=new Node(val,Math.min(val,head.min),head);
        }
    }
    
    public void pop() {
        head=head.next;
    }
    
    public int top() {
       return head.val;
    }
    
    public int getMin() {
     return head.min;   
    }
    private class Node{
          int val;
          int min;
          Node next;
          Node(int val, int min ,Node next){
           this.val=val;
           this.min=min;
           this.next=next; 
          }
    }
}
