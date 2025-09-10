package com.ds.java.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class _L_933_Number_of_Recent_Calls {

	public static void main(String[] args) {
		/*
		 * Explanation RecentCounter
		 *  recentCounter = new RecentCounter();
		 * recentCounter.ping(1); // requests = [1], range is [-2999,1], return 1 = [-2999 , 1] 
		 * recentCounter.ping(100); // requests = [1, 100], range is [-2900,100], return 2 [-2900,100] 
		 * recentCounter.ping(3001); // requests = [1, 100, 3001], range is [1,3001], return 3 [1,3001] 
		 * recentCounter.ping(3002); // requests = [1, 100, 3001, 3002], range is [2,3002], return 3 [2,3002]
		 */		//[[],[642],[1849],[4921],[5936],[5957]]
		
		RecentCounter counter = new RecentCounter();
		System.out.println(counter.ping(642));
		System.out.println(counter.ping(1849));
		System.out.println(counter.ping(4921));
		System.out.println(counter.ping(5936));
		System.out.println(counter.ping(5957));

	}

}

class RecentCounter {
	Queue<Integer> queue;
	
    public RecentCounter() {
        queue = new LinkedList<>();
    }
    
    public int ping(int t) {
    	queue.add(t);
    	int range = t - 3000;
        while(range>queue.peek()) {
        	queue.poll();
        }
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
