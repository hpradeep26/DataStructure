package com.ds.java.stackqueue;

import java.util.Stack;

public class _L_901_Online_Stock_Span {

	public static void main(String[] args) {
		StockSpanner spanner = new StockSpanner();
		System.out.println(spanner.next(100));
		System.out.println(spanner.next(80));
		System.out.println(spanner.next(60));
		System.out.println(spanner.next(70));
		System.out.println(spanner.next(60));
		System.out.println(spanner.next(75));
		System.out.println(spanner.next(85));

	}
	
	
	

}

class StockSpanner {
    Stack<Integer> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
    	int count = 1;
    	for(int i=stack.size()-1;i>=0;i--) {
    		int num = stack.elementAt(i);
    		if(price>=num) {
    			count++;
    		}else {
    			break;
    		}
    		
    	}
        stack.push(price);
        return count;
    }
}