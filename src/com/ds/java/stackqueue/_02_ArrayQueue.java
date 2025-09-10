package com.ds.java.stackqueue;

public class _02_ArrayQueue {
	
	int[] arr;
    // Indices for start and end of the queue
    int start, end;
    // Current size and maximum size of the queue
    int currSize, maxSize;
	
	public _02_ArrayQueue(int size) {
		  arr = new int[10];
	        start = -1;
	        end = -1;
	        currSize = 0;
	        maxSize = 10;
		
	}
	
	private boolean isEmpty(){
		 return (currSize == 0);
	}
	
	private void push(int val) {
		if (currSize == maxSize) {
			System.out.println("Queue is full\nExiting...");
			System.exit(1);
		}
		if (end == -1) {
			start = 0;
			end = 0;
		}else {
			end = (end + 1) % maxSize;
		}
		arr[end] = val;
		currSize++;
	}
	
	private int pop() {
		 if (start == -1) {
	            System.out.println("Queue Empty\nExiting...");
	            System.exit(1);
	        }
	        int popped = arr[start];
	        if (currSize == 1) {
	            start = -1;
	            end = -1;
	        } 
	        else {
	            // Circular increment of start
	            start = (start + 1) % maxSize;
	        }
	        currSize--;
	        return popped;
	}
	
	  // Method to get the front element of the queue
    public int peek() {
        // Check if the queue is empty
        if (start == -1) {
            System.out.println("Queue is Empty");
            System.exit(1);
        }
        return arr[start];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
