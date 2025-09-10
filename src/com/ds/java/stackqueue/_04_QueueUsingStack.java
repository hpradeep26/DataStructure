package com.ds.java.stackqueue;

import java.util.Stack;

public class _04_QueueUsingStack {
	
	Stack<Integer> stack = new Stack<>();
	
	private void push(int x) {
		stack.add(x);
	}
	
	
	  private int pop() { 
		  if(stack.isEmpty()) {
			  System.out.println("queue is empty");
			  return -1;
		  }
		  Integer remove = stack.remove(0);
		  return remove;
	  }
	  
	  private int peek() { 
		  if(stack.isEmpty()) {
			  System.out.println("queue is empty");
			  return -1;
		  }
		  return stack.get(0);
	  }
	  
	  public boolean isEmpty() {
		  return stack.isEmpty();
	    }
	 

	public static void main(String[] args) {
		_04_QueueUsingStack q = new _04_QueueUsingStack();
		 q.push(3);
	        q.push(4);
	        System.out.println("The element popped is " + q.pop());
	        q.push(5);
	        System.out.println("The front of the queue is " + q.peek());
	        System.out.println("Is the queue empty? " + (q.isEmpty() ? "Yes" : "No"));
	        System.out.println("The element popped is " + q.pop());
	        System.out.println("The element popped is " + q.pop());
	        System.out.println("Is the queue empty? " + (q.isEmpty() ? "Yes" : "No"));
	}

}
