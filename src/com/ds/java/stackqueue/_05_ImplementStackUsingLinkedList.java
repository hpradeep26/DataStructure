package com.ds.java.stackqueue;

public class _05_ImplementStackUsingLinkedList {
	
	private Node head; // Top of Stack
    private int size; // Size
    
    public _05_ImplementStackUsingLinkedList() {
    	head = null;
    	size = 0;
    }
    
    private void push(int x) {
    	Node newNode = new Node(x);
    	if(head==null) {
    		head = newNode;
    	}else {
    		Node temp = head;
    		while(temp.next!=null) {
    			temp = temp.next;
    		}
    		temp.next = newNode;
    	}
    	size++;
    }
    
 // Method to push an element onto the stack
    public void pushOptimal(int x) {
        // Creating a node
        Node element = new Node(x);
        
        element.next = head; // Updating the pointers
        head = element; // Updating the top
        
        // Increment size by 1
        size++;
    }
    
    public int pop() {
        // If the stack is empty
        if (head == null) {
            return -1; // Pop operation cannot be performed
        }
        
        int value = head.val; // Get the top value
        Node temp = head; // Store the top temporarily
        head = head.next; // Update top to next node
        temp = null; // Delete old top node
        size--; // Decrement size
        
        return value; // Return data
    }
    
    public int top() {
        // If the stack is empty
        if (head == null) {
            return -1; // Top element cannot be accessed
        }
        
        return head.val; // Return the top
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return (size == 0);
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Node{
	int val;
	Node next;
	
	 Node(int d) {
	        val = d;
	        next = null;
	    }
}