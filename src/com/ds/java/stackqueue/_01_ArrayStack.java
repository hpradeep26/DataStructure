package com.ds.java.stackqueue;

public class _01_ArrayStack {
	
	private int[] stack;
	
	private int capacity;
	
	private int topIndex;
	
	public _01_ArrayStack(int size) {
		this.capacity = size;
		this.topIndex = -1;
		this.stack = new int[capacity];
	}
	
	
	public void push(int val){
		if(topIndex>= capacity-1) {
			System.out.println("Stack is overflow");
			return;
		}
		topIndex++;
		stack[topIndex]= val;
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		}
		int tobeRemove = stack[topIndex--];
		return tobeRemove; 
	}
	
	public boolean isEmpty() {
        return topIndex == -1;
    }
	
	 // Returns top element
    public int top() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[topIndex];
    }

	public static void main(String[] args) {
		
		_01_ArrayStack stack=new _01_ArrayStack(2);
		stack.push(10);
		stack.push(5);
		stack.push(8);
		
		stack.top();
		stack.pop();
		
	}

}
