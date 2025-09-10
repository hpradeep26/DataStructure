package com.ds.java.recursion;

import java.util.ArrayList;
import java.util.List;

public class _12_GenerateParenthsis {

	public static void main(String[] args) {
		_12_GenerateParenthsis sol = new _12_GenerateParenthsis();
	        int n = 2; // Example input
	        List<String> result = sol.generateParenthesis(n);
	        System.out.println(result);

	}
	
	 public List<String> generateParenthesis(int n) {
		 List<String> result = new ArrayList<>();
		 // Start the recursive generation with initial values
		 generate(0,0,n,"",result);
		 return result;
	    }

	private void generate(int open, int close, int n, String counter, List<String> result) {
		
		if(open==close && open + close == 2*n) {
			result.add(counter);
		}
		
		if(open<n) {
			generate(open+1, close, n, counter +'(',result);
		}
		
		if(close<open) {
			generate(open, close+1, n, counter+')', result);
		}
	}

}
