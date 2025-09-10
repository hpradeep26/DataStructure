package com.ds.java.stackqueue;

import java.util.Stack;

public class _739_DailyTemperatures {

	public static void main(String[] args) {
		int[] arr = {73,74,75,71,69,72,76,73};
			//{55,38,53,81,61,93,97,32,43,78};
		//[1,1,4,2,1,1,0,0]
		dailyTemperatures(arr);
	}
	
	public static int[] dailyTemperatures(int[] temperatures) {
		 Stack<Integer> stack = new Stack<>();
	        int[] result = new int[temperatures.length];
	        for (int i = 0; i < temperatures.length; i++) {
	            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
	                int idx = stack.pop();
	                result[idx] = i - idx;
	            }
	             stack.push(i);
	        }
	        return result;
	}

}
