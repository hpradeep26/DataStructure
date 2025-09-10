package com.ds.java.stackqueue;

import java.util.Stack;

public class _L_394_Decode_String {

	public static void main(String[] args) {
		//Input: s = "3[a]2[bc]"
		//Output: "aaabcbc"
		
		/*
		 * Input: s = "2[abc]3[cd]ef" 
		 * Output: "abcabccdcdcdef"
		 */
		String s ="3[a2[cc]]";
		System.out.println(decodeString(s));

	}


	public static String decodeString(String s) {
        // Stack to hold the count of repetitions for each nested segment
        Stack<Integer> countStack = new Stack<>();
        // Stack to hold the result of previous segments
        Stack<StringBuilder> resultStack = new Stack<>();
        // StringBuilder to construct the current segment
        StringBuilder current = new StringBuilder();
        int k = 0; // To track the current multiplier
        
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // If the character is a digit, update the multiplier (k)
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                // Push the multiplier and current segment to their respective stacks
                countStack.push(k);
                resultStack.push(current);
                // Reset for the next segment
                k = 0;
                current = new StringBuilder();
            } else if (ch == ']') {
                // End of the current nested segment
                // Pop the multiplier and the previous segment from the stacks
                int repeatCount = countStack.pop();
                StringBuilder previous = resultStack.pop();
                // Repeat the current segment and append it to the previous segment
                for (int i = 0; i < repeatCount; i++) {
                    previous.append(current);
                }
                // Update the current segment with the combined result
                current = previous;
            } else {
                // Append regular characters to the current segment
                current.append(ch);
            }
        }
        // Return the final decoded string
        return current.toString();
	}
}
