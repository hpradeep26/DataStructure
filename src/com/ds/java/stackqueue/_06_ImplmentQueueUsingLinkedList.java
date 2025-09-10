package com.ds.java.stackqueue;

public class _06_ImplmentQueueUsingLinkedList {
	
	 private Node start; // Start of the queue
	    private Node end; // End of the queue
	    private int size; // Size of the queue
	    
	    
	 // Constructor
	    public _06_ImplmentQueueUsingLinkedList() {
	        start = end = null;
	        size = 0;
	    }
	    
	    // Method to push an element in the queue
	    public void push(int x) {
	        // Creating a node
	        Node element = new Node(x);
	        
	        // If it is the first element being pushed
	        if (start == null) {
	            // Initialize the pointers
	            start = end = element;
	        } else {
	            end.next = element; // Updating the pointers
	            end = element; // Updating the end
	        }
	        
	        // Increment size by 1
	        size++;
	    }
	    
	    // Method to pop an element from the queue
	    public int pop() {
	        // If the queue is empty
	        if (start == null) {
	            return -1; // Pop operation cannot be performed
	        }
	        
	        int value = start.val; // Get the front value
	        Node temp = start; // Store the front temporarily
	        start = start.next; // Update front to next node
	        temp = null; // Delete old front node
	        size--; // Decrement size
	        
	        return value; // Return data
	    }
	    
	    // Method to get the front element in the queue
	    public int peek() {
	        // If the queue is empty
	        if (start == null) {
	            return -1; // Front element cannot be accessed
	        }
	        
	        return start.val; // Return the front
	    }
	    
	    // Method to check if the queue is empty
	    public boolean isEmpty() {
	        return (size == 0);
	    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}