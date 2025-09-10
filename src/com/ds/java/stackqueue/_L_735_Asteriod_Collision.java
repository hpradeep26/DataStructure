package com.ds.java.stackqueue;

import java.util.Stack;

public class _L_735_Asteriod_Collision {

	public static void main(String[] args) {
		/*
		 * Input: asteroids = [5,10,-5] 
		 * Output: [5,10] 
		 * Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
		 */
			
		/*
		 * Input: asteroids = [8,-8] 
		 * Output: [] 
		 * Explanation: The 8 and -8 collide exploding each other.
		 */
		int[] a= {10,2,-5};
		asteroidCollision(a);
	}
	
	
	public static int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> st = new Stack<>();
		for(int a:asteroids) {
			if(a>0) {
				st.push(a);
			}else {
				while(!st.isEmpty() && st.peek()>0 && st.peek()< -a) {
					st.pop();
				}
				
				if(st.isEmpty()||st.peek()<0) {
					st.push(a);
				}
				
				if (st.peek() == -a) {
                    st.pop();
                }
			}
		}
		int[] res = new int[st.size()];
		 int i = st.size() - 1;

	        while(!st.isEmpty()) {
	            res[i--] = st.pop();
	        }
		return res;
		
	}

}
