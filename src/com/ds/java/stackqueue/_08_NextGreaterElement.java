package com.ds.java.stackqueue;

import java.util.Arrays;
import java.util.Stack;

public class _08_NextGreaterElement {

	public static void main(String[] args) {
		int[] arr = {1, 3, 2, 4};
		System.out.println(Arrays.toString(nextLargerElementOptimal(arr)));

	}
	
	 public static int[] nextLargerElement(int[] arr) {
		 int n = arr.length;   
		 int[] res = new int[n];
		 
		 for(int i =0;i<n;i++) {
			 boolean flag = false;
			 for(int j = i+1;j<n;j++) {
				 if(arr[j]>arr[i]) {
					 res[i] = arr[j];
					 flag = true;
					 break;
				 }
			 }
			 if(!flag) {
				 res[i] = -1;
			 }
		 }
		 
		 return res;
	    }
	 
	 public static int[] nextLargerElementOptimal(int[] arr) {
		 int n = arr.length;   
		 int[] res = new int[n];
		 
		 Stack<Integer> st = new Stack<>();
		
		 for(int i = n-1;i>=0; i--) {
			 int curelement = arr[i];
			 
			 while(!st.empty()&&st.peek()<=curelement) {
				 st.pop();
			 }
			 
			 if(st.empty())
				 res[i] = -1;
			 else 
				 res[i] = st.peek();
			 
			 st.push(arr[i]);
		 }
		 
		 return res;
	    }

}
