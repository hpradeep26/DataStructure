package com.ds.java.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class _21_Length_of_Loop {

	public static void main(String[] args) {
		  ListNode head = new ListNode(1);
	        ListNode second = new ListNode(2);
	        ListNode third = new ListNode(3);
	        ListNode fourth = new ListNode(4);
	        ListNode fifth = new ListNode(5);

	        // Create a loop from fifth to second
	        head.next = second;
	        second.next = third;
	        third.next = fourth;
	        fourth.next = fifth;

	        // This creates a loop
	        fifth.next = second;
	        findLengthOfLoop(head);

	}
	
	 public static int findLengthOfLoop(ListNode head) {
		 Map<ListNode,Integer> map = new HashMap<>();
		 ListNode temp = head;
		 int index = 0;
		 while(temp!=null) {
			 if(map.containsKey(temp)) {
				 return map.size() - map.get(temp);
			 }
			 map.put(temp, index++);
			 temp = temp.next;
		 }
		 return 0;
     }
	 
	 
	// Function to find the length of the loop
	    public int findLengthOfLoopOptimal(ListNode head) {
	        ListNode slow = head;
	        ListNode fast = head;

	        // Traverse the list to detect a loop
	        while (fast != null && fast.next != null) {
	            // Move slow one step
	            slow = slow.next;
	            // Move fast two steps
	            fast = fast.next.next;

	            // If the slow and fast pointers meet
	            // there is a loop
	            if (slow == fast) {
	                // return the number of nodes 
	                return findLength(slow, fast);
	            }
	        }

	        /* If the fast pointer 
	        reaches the end, 
	        there is no loop */
	        return 0;
	    }
	 
	 int findLength(ListNode slow, ListNode fast) {
	        // Count to keep track of nodes encountered in loop
	        int cnt = 1;
	        
	        // Move fast by one step
	        fast = fast.next;
	        
	        // Traverse fast till it reaches back to slow
	        while (slow != fast) {
	            /* At each node 
	            increase count by 1
	            move fast forward 
	            by one step */
	            cnt++;
	            fast = fast.next;
	        }
	        
	        /* Loop terminates 
	        when fast reaches slow again 
	        and the count is returned*/
	        return cnt;
	    }

}
