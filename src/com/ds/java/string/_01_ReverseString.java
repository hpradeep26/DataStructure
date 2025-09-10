package com.ds.java.string;

import java.util.Stack;
import java.util.Vector;

public class _01_ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void reverseString(Vector<Character> s) {
        Stack<Character> stack = new Stack<>();

        // Push characters onto the stack
        for (char c : s) {
            stack.push(c);
        }

        // Pop characters from the stack to reverse the string
        for (int i = 0; i < s.size(); ++i) {
            s.set(i, stack.pop());
        }

        return;
    }
	
	 public void reverseString1(Vector<Character> s) {
	        int start = 0, end = s.size() - 1;

	        // Until the string is reversed
	        while (start < end) {
	            // Swap the characters at start and end
	            char ch = s.get(start);
	            s.set(start, s.get(end));
	            s.set(end, ch);

	            // Move the pointers towards the center
	            start++;
	            end--;
	        }

	        return;
	    }

}
