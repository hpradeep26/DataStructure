package com.ds.java.stackqueue;

import java.util.Stack;

public class _12_RemoveKDigits {

	public static void main(String[] args) {
		String nums = "541892";
		int k = 2;
		System.out.println(removeKdigits(nums, k));

	}

	public static String removeKdigits(String nums, int k) {

		Stack<Character> st = new Stack<>(); // Stack

		// Traverse on the given string
		for(int i = 0; i < nums.length(); i++) {

			// Current digit
			char digit = nums.charAt(i);

			/* Pop last digits (when possible)
            if a smaller digit is found*/
			while(!st.isEmpty() && k > 0
					&& st.peek() > digit) {

				st.pop(); // Pop the last digit
				k--; // Decrement K by 1
			}

			// Push the current digit
			st.push(digit);
		}

		// If more digits can be removed
		while(!st.isEmpty() && k > 0) {

			st.pop(); // Pop the last added digits
			k--; // Decrement K by 1
		}

		// Handling edge case
		if(st.isEmpty()) return "0";

		// To store the result
		StringBuilder res = new StringBuilder();

		// Adding digits in stack to result
		while(!st.isEmpty()) {
			res.append(st.pop());
		}

		// Trimming the zeroes at the back
		while(res.length() > 0 && 
				res.charAt(res.length() - 1) == '0') {

			res.deleteCharAt(res.length() - 1);
		}

		// Reverse to get the actual number
		res.reverse();

		// Edge case
		if(res.length() == 0) return "0";

		// Return the stored result
		return res.toString();
	}

}
