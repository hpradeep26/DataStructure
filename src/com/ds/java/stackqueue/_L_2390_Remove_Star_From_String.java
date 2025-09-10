package com.ds.java.stackqueue;

import java.util.Stack;

public class _L_2390_Remove_Star_From_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Input: s = "leet**cod*e";
		//Output: "lecoe"
		//Input: s = "erase*****"
			//	Output: ""
		
	}
	
	public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='*'){
                if(!st.isEmpty()){
                  st.pop();
                }
            }else{
                st.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }

}
