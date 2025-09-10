package com.ds.java.stackqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _10_Asteroid_Collision {

	public static void main(String[] args) {
		int[] arr = {4,7,1,1,2,-3,-7,17,15,-16};
		asteroidCollision(arr);

	}
	
	
	public static int[] asteroidCollision(int[] asteroids) {  // Size of the array
        Stack<Integer> st = new Stack<>();
        
        
        for(int i =0;i<asteroids.length;i++) {
        	int val = asteroids[i];
        	  /* Push the asteroid in stack if a 
            right moving asteroid is seen */
        	if(val>0) {
        		st.push(val);
        		   /* Else if the asteroid is moving 
                left, perform the collisions */
        	}else {
        		/* Until the right moving asteroids are 
                smaller in size, keep on destroying them */ 
        		while(!st.empty() && st.peek()>0 && st.peek() < Math.abs(val)) {
        			   // Destroy the asteroid
        			st.pop();
        		}
        		/* If there is right moving asteroid 
                which is of same size */
        		if(!st.empty() && st.peek()>0 && st.peek()==Math.abs(val)) {
        			// Destroy both the asteroids
        			st.pop();
        		}
        		 /* Otherwise, if there is no left
                moving asteroid, the right moving 
                asteroid will not be destroyed */
        		else if(st.isEmpty() || st.peek()<0){
        			st.push(val);
        		}
        	}
        }
        
        
        int[] res = new int[st.size()];
        int index =0;
        for(Integer num:st) {
        	res[index++] = num;
        }
        
        return res;
        
      }

}
